//Jairam Kakar - N01179234 - CENG-258-RNC
//Aryan Sood - N01393003 - CENG-258-RNA
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
        RadioGroup colorRG = view.findViewById(R.id.jairamAryanColorRG); // Holder for RadioGroup reference
        colorRG.setOnCheckedChangeListener((radioGroup, i) -> selectBgColor()); // If a radio button in RadioGroup is checked, call function
        Button saveBtn = view.findViewById(R.id.jairamAryanSaveSettingsBtn); // Holder for save button reference

        // When save button is clicked
        saveBtn.setOnClickListener(view -> {
            String colorSelection = getString(R.string.userChoiceKey); // Holder for key (Text)
            SharedPreferences pref = getActivity().getSharedPreferences(colorSelection, 0); // Get SharedPref file
            SharedPreferences.Editor editor = pref.edit(); // Open editor
            editor.putInt(colorSelection, userChoice); // Input the key and value
            editor.apply(); // Apply changes and close editor
        });

        Button defaultBtn = view.findViewById(R.id.jairamAryanDefaultSettingsBtn); // Holder for default button reference

        // If default button is clicked
        defaultBtn.setOnClickListener(view -> {
            userChoice = 0; // Default choice (0)
            String colorSelection = getString(R.string.userChoiceKey);  // Holder for key (Text)
            SharedPreferences pref = getActivity().getSharedPreferences(colorSelection, 0); //Get SharedPref file
            SharedPreferences.Editor editor = pref.edit(); // Open editor
            editor.putInt(colorSelection, userChoice); // Input the key and value
            editor.apply(); // Apply changes and close editor
            colorRG.clearCheck(); // Uncheck all radio buttons
        });

        return view;
    }

    // Select background color function
    private int selectBgColor() {
        RadioButton redRB = getView().findViewById(R.id.jairamAryanRedRB); // Holder for 'red' radio button reference
        RadioButton purpleRB = getView().findViewById(R.id.jairamAryanPurpleRB); // Holder for 'purple' radio button reference
        RadioButton yellowRB = getView().findViewById(R.id.jairamAryanYellowRB); // Holder for 'yellow' radio button reference

        if(redRB.isChecked()){ // If 'red' RadioButton is checked
            userChoice = 1; // User option 1 was selected
        }
        if(purpleRB.isChecked()){ // If 'purple' RadioButton is checked
            userChoice = 2; // User option 2 was selected
        }
        if(yellowRB.isChecked()){ // If 'yellow' RadioButton is checked
            userChoice = 3; // User option 3 was selected
        }
        return userChoice; // Return option selected by user
    }


}