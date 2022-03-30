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


import androidx.fragment.app.ListFragment;
import aryan1.jairam2.codemasters.R;
import aryan1.jairam2.codemasters.databinding.FragmentDownloadBinding;

public class DownloadFrag extends ListFragment {
    private FragmentDownloadBinding binding;
    String[] list = new String[]
            {"Flower",
                    "Nature",
                    "Mars"};
    String[] links = new String[]
            {"https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pexels.com%2Fsearch%2Fflowers%2F&psig=AOvVaw36_u6hxWbu3cys3YeORkcH&ust=1648709375362000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCNDRkpef7fYCFQAAAAAdAAAAABAE",
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fs%2Fphotos%2Fcanada-nature&psig=AOvVaw03WHblcrdURjlghemK22w4&ust=1648709405657000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCKDut6Wf7fYCFQAAAAAdAAAAABAD",
                    "https://www.google.com/url?sa=i&url=https%3A%2F%2Fmars.nasa.gov%2Fscience%2Fsummary%2F&psig=AOvVaw2BSEmlEazs7S57996CpqiJ&ust=1648709421655000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCPDA3a2f7fYCFQAAAAAdAAAAABAD"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_download, container, false);
        //ArrayAdapter creates a view for each array item
        // by calling toString() on each item and placing
        // the contents in a TextView.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,list);
        //bind the list view with array adapter
        setListAdapter(adapter);
        return view;
    }


}
