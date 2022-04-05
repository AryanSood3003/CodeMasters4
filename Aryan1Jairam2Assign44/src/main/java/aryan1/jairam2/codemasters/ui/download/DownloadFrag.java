//Jairam Kakar - N01179234 - CENG-258-RNC
//Aryan Sood - N01393003 - CENG-258-RNA
package aryan1.jairam2.codemasters.ui.download;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;


import androidx.fragment.app.ListFragment;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import aryan1.jairam2.codemasters.R;
import aryan1.jairam2.codemasters.databinding.FragmentDownloadBinding;

public class DownloadFrag extends ListFragment {
    ImageView imageView= null;
    ProgressBar progressBar;

    String[] list = new String[]
            {"Flower", "Nature", "Mars"};
    String[] links = new String[]
            {"https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg?cs=srgb&dl=pexels-pixabay-60597.jpg&fm=jpg",
                    "https://images.unsplash.com/photo-1610878180933-123728745d22?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1674&q=80",
                    "https://aws.cricketmedia.com/media/20151007132801/Mars-Shutterstock-scaled.jpg"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_download, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,list);
        setListAdapter(adapter);
        imageView=view.findViewById(R.id.image);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        return view;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        getListView().setSelector(android.R.color.holo_blue_bright);
        AsyncTaskExample asyncTask=new AsyncTaskExample();
        progressBar.setProgress(0);
        asyncTask.execute(links[position]);

    }


    private class AsyncTaskExample extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bmImg = null;
            Integer count=0;

       while(count < 4) {
                try {
                    Thread.sleep(500);
                    URL ImageUrl = new URL(strings[0]);
                    count++;
                    publishProgress(String.valueOf(count*25));
                    HttpURLConnection urlConnection = (HttpURLConnection) ImageUrl.openConnection();
                    int responseCode = urlConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        InputStream is = urlConnection.getInputStream();
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = Bitmap.Config.RGB_565;
                        bmImg = BitmapFactory.decodeStream(is, null, options);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return bmImg;
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (imageView != null) {
                progressBar.setVisibility(View.INVISIBLE);
                imageView.setImageBitmap(bitmap);
            }
        }
        @Override
        protected void onProgressUpdate(String... values) {
            progressBar.setProgress(Integer.parseInt(values[0]));
        }
    }
}
