package aryan1.jairam2.codemasters.ui.settings;

import static androidx.core.os.BundleKt.bundleOf;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentResultOwner;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import aryan1.jairam2.codemasters.R;
import aryan1.jairam2.codemasters.ui.home.HomeFrag;
import aryan1.jairam2.codemasters.ui.shape.ShapeFrag;

public class SettingsFrag extends Fragment {

    View view;
    public static SettingsFrag newInstance() {
        return new SettingsFrag();
    }
    private int userChoice = 0;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.settings_frag, container, false);
        RadioGroup colorRG = view.findViewById(R.id.jairamAryanColorRG);
        colorRG.setOnCheckedChangeListener((radioGroup, i) -> selectBgColor());
        Button saveBtn = view.findViewById(R.id.jairamAryanSaveSettingsBtn);

        saveBtn.setOnClickListener(view -> {
            String colorSelection = getString(R.string.userChoiceKey);
            SharedPreferences pref = getActivity().getSharedPreferences(colorSelection, 0);
            SharedPreferences.Editor editor = pref.edit();
            editor.putInt(colorSelection, userChoice);

            editor.apply();
        });

        return view;
    }

    private int selectBgColor() {
        RadioButton redRB = getView().findViewById(R.id.jairamAryanRedRB);
        RadioButton blackRB = getView().findViewById(R.id.jairamAryanBlackRB);
        RadioButton blueRB = getView().findViewById(R.id.jairamAryanBlueRB);

        if(redRB.isChecked()){
            userChoice = 1;
            //Toast.makeText(getActivity(), "Red",Toast.LENGTH_LONG).show();
        }
        if(blackRB.isChecked()){
            userChoice = 2;
            //Toast.makeText(getActivity(), "Purple",Toast.LENGTH_LONG).show();
        }
        if(blueRB.isChecked()){
            userChoice = 3;
            //Toast.makeText(getActivity(), "Yellow",Toast.LENGTH_LONG).show();
        }
        return userChoice;
    }


}