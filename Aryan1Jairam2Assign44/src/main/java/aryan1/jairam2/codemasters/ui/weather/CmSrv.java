//Jairam Kakar - N01179234 - CENG-258-RNC
//Aryan Sood - N01393003 - CENG-258-RNA
package aryan1.jairam2.codemasters.ui.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import aryan1.jairam2.codemasters.R;
import aryan1.jairam2.codemasters.databinding.SmSrvBinding;

public class CmSrv extends Fragment implements AdapterView.OnItemSelectedListener {

    private SmSrvBinding binding;
    Spinner city;
    int selection;
    private TextView latitude,longitude,humidity,count,des,names,userselection;
    private String mString;
    String lat,longi,country,humid,name,desc;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = SmSrvBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        city = (Spinner) root.findViewById(R.id.cities_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(adapter);
       city.setOnItemSelectedListener(this);
//        final TextView textView = binding.textWeather;
//        weatherViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        latitude=(TextView) root.findViewById(R.id.Lat);
        longitude=(TextView) root.findViewById(R.id.longi);
        humidity=(TextView)root.findViewById(R.id.humid);
        count=(TextView) root.findViewById(R.id.country);
        des=(TextView) root.findViewById(R.id.description);
        names=(TextView) root.findViewById(R.id.name);
        userselection=(TextView) root.findViewById(R.id.city_selected);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selection= city.getSelectedItemPosition();
        Log.d("city",String.valueOf(selection));
        getWeather();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    // onClick method of the button
    public void getWeather()
    {

        //get weather information using geo coordinates
        //this method calls OpenWeatherMap API
        //
        //create the URL to call JSON service
        //"http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=13f04464b7119837cf1dc4fa8b39caa3");

        String url = "https://api.openweathermap.org/data/2.5/weather?";
        String [] arr= getResources().getStringArray(R.array.lats);
        String [] arr2= getResources().getStringArray(R.array.longs);
        String [] arr3= getResources().getStringArray(R.array.cities);
        url+="lat="+ arr[selection];
        url+="&lon="+arr2[selection];
        url+="&appid=70dadb116a1e4ab671ed539c507302af"; //from OpenWeatherMap website, get the proper key
        userselection.setText(arr3[selection]);
        Log.d("URL",url);
        new ReadJSONFeedTask().execute(url);
    }

    private class ReadJSONFeedTask extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){
            // anything to display prior to work such as display progressbar!
        }

        protected String doInBackground(String... urls) {
            URL url = null;
            HttpURLConnection httpURLConnection = null;
            StringBuilder bufferReader = null;
            try {
                url = new URL(urls[0]);
                bufferReader = new StringBuilder();
                httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream content = new BufferedInputStream(httpURLConnection.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        bufferReader.append(line);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                assert httpURLConnection != null;
                httpURLConnection.disconnect();
            }
            return bufferReader.toString();

        }
        protected void onPostExecute(String result) {
            try {
                JSONObject weatherJson = new JSONObject(result);
                JSONArray dataArray1= weatherJson.getJSONArray("weather");
                JSONObject area= weatherJson.getJSONObject("sys");
                JSONObject locationObj= weatherJson.getJSONObject("coord");
                JSONObject weathrObj= weatherJson.getJSONObject("main");
                for (int i = 0; i < dataArray1.length(); i++) {
                    JSONObject jsonObject = dataArray1.getJSONObject(i);
                 desc =jsonObject.getString("description");
                }
                    longi=locationObj.getString("lon");
                    lat=locationObj.getString("lat");
                    humid =weathrObj.getString("humidity");
                    country =area.getString("country");
                    name= weatherJson.getString("name");
                    latitude.setText(lat);
                    longitude.setText(longi);
                    humidity.setText(humid);
                    des.setText(desc);
                    names.setText(name);
                    count.setText(country);
                Log.d("test",desc);
                Log.d("name", name);
                Log.d("c",country);
                Log.d("humid",humid);
                Log.d("lat",(lat+" " +longi));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}