//Jairam Kakar - N01179234 - CENG-258-RNC
//Aryan Sood - N01393003 - CENG-258-RNA
package aryan1.jairam2.codemasters.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import aryan1.jairam2.codemasters.R
import aryan1.jairam2.codemasters.databinding.HomeFragmentBinding
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.time.LocalDate


class HomeFrag : Fragment() {

    private var binding: HomeFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        // Call setHomeBG function right away, set background of HomeFrag accordingly
        setHomeBG()
        // Create  holder for TextView
        val textView: TextView = binding!!.jairamAryanHomeTV1
        // Create  holder for current date and time
        val currentDate= LocalDate.now()
        // Set the textview to current date and time, to display it
        textView.text = currentDate.toString()
        // Create  holder for Store Button
        val storeBtn : Button = binding!!.jairamAryanStoreButton
        // When Store button is clicked
        storeBtn.setOnClickListener(){//Storing the Data
            val editText : EditText = binding!!.jairamET1
            val filePath = getString(R.string.filePath) // Holder for filepath
            val file = File(filePath) // Set 'file' to file with specified filepath
            val fileExists = file.exists() // Check if file exists
            Log.d(getString(R.string.addFile), fileExists.toString()) // Log to test and check
            if(fileExists){//If file exists
                addToExisting()//Append function
            }else{
                createAndAdd()//Create and append
            }
            editText.text.clear()//Clearing Edit text
        }
        return root
    }


    private fun setHomeBG() {
        val colorSelection = getString(R.string.userChoiceKey) //The 'key' used for SharedPref
        //Set up SharedPref
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences(colorSelection, 0)
        //Create variable that holds the data
        val userChoice = sharedPreferences.getInt(colorSelection, 0)
        //Create variable that holds the HomeFrag layout reference
        val homeLayout = binding!!.jairamAryanHomeFrag
        //Create wanted colors programmatically
        val homeGreen = Color.rgb(143, 255, 145)
        val lightRed = Color.rgb(255, 166, 166)
        val lightPurple = Color.rgb(192, 173, 247)
        val lightYellow = Color.rgb(247, 243, 151)
        // Start If/Else clause
        if (userChoice == 0) { //If 0, (Default)
            homeLayout.setBackgroundColor(homeGreen) // Set HomeFrag background to default light-green
        }
        if (userChoice == 1) { // If 1, (First Option)
            homeLayout.setBackgroundColor(lightRed) // Set HomeFrag background to light-red
        }
        if (userChoice == 2) { // If 2, (Second Option)
            homeLayout.setBackgroundColor(lightPurple) // Set HomeFrag background to light-purple
        }
        if (userChoice == 3) { // If 3, (Third Option)
            homeLayout.setBackgroundColor(lightYellow) // Set HomeFrag background to light-Yellow
        }
    }

    // Function to add if file exists
    private fun addToExisting(){
        val filePath = getString(R.string.filePath) // Get file path
        val file = File(filePath) // Get File from specified file path
        val editText : EditText = binding!!.jairamET1 // Holder for EditText reference
        file.appendText(editText.text.toString()+ "\n")//Adding the inputted data to the file
        Toast.makeText(activity, getText(R.string.addTxtSuc).toString(), Toast.LENGTH_SHORT).show() // Toast to let user know that text was added
    }

    // Function to create a file then append text
    private fun createAndAdd() {
        try {
            //Creating and writing to the file
            val editText : EditText = binding!!.jairamET1 // Holder for EditText
            //Specify file, create it and append EditText input
            val fileOutputStream: FileOutputStream = requireActivity().openFileOutput(getText(R.string.jayAryanET).toString(), Context.MODE_PRIVATE)
            val outputWriter = OutputStreamWriter(fileOutputStream)
            outputWriter.append(editText.text.toString()+"\n")
            outputWriter.close()
            Toast.makeText(activity, getText(R.string.addTxtSuc), Toast.LENGTH_SHORT).show() // Toast to let user know that file was created and text added
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
