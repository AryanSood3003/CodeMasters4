package aryan1.jairam2.codemasters.ui.shape;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import aryan1.jairam2.codemasters.R;

public class ShapeFrag extends Fragment {

    private ShapeViewModel mViewModel;

    public static ShapeFrag newInstance() {
        return new ShapeFrag();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shape_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ShapeViewModel.class);
        // TODO: Use the ViewModel
    }

}