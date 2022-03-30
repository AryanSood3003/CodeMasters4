package aryan1.jairam2.codemasters.ui.shape;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import aryan1.jairam2.codemasters.R;

public class ShapeFrag extends Fragment {

    private ShapeViewModel mViewModel;

    public static ShapeFrag newInstance() {
        return new ShapeFrag();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.shape_fragment, container, false);

        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView textView = (AutoCompleteTextView) root.findViewById(R.id.autoCompleteTextView);
// Get the string array
        String[] emails = getResources().getStringArray(R.array.emails);
// Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, emails);
        textView.setAdapter(adapter);
        return root;
    }


}