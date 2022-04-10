package aryan1.jairam2.codemasters.ui.settings;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import aryan1.jairam2.codemasters.R;


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

        Button defaultBtn = view.findViewById(R.id.jairamAryanDefaultSettingsBtn);

        defaultBtn.setOnClickListener(view -> {
            userChoice = 0;
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
        RadioButton purpleRB = getView().findViewById(R.id.jairamAryanPurpleRB);
        RadioButton yellowRB = getView().findViewById(R.id.jairamAryanYellowRB);

        if(redRB.isChecked()){
            userChoice = 1;
        }
        if(purpleRB.isChecked()){
            userChoice = 2;
        }
        if(yellowRB.isChecked()){
            userChoice = 3;
        }
        return userChoice;
    }


}