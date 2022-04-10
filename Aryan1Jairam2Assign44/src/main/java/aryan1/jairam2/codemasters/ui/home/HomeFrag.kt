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
        val textView: TextView = binding!!.jairamAryanHomeTV1
        val currentDate= LocalDate.now()
        textView.text = currentDate.toString()
        val storeBtn : Button = binding!!.jairamAryanStoreButton
        setHomeBG()
        storeBtn.setOnClickListener(){
            val editText : EditText = binding!!.jairamET1
            val filePath = "/data/data/aryan1.jairam2.codemasters/files/CodeMasters.txt"
            val file = File(filePath)
            var fileExists = file.exists()
            Log.d("addfile", fileExists.toString())
            if(fileExists){
                addToExisting()
            }else{
                createAndAdd()
            }
            editText.text.clear()
        }
        return root
    }


    private fun setHomeBG() {
        val colorSelection = getString(R.string.userChoiceKey)
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences(colorSelection, 0)
        val userChoice = sharedPreferences.getInt(colorSelection, 0)

        val homeLayout = binding!!.jairamAryanHomeFrag
        val homeGreen = Color.rgb(143, 255, 145)
        val lightRed = Color.rgb(255, 166, 166)
        val lightPurple = Color.rgb(192, 173, 247)
        val lightYellow = Color.rgb(247, 243, 151)

        if (userChoice == 0) {
            homeLayout.setBackgroundColor(homeGreen)
        }
        if (userChoice == 1) {
            homeLayout.setBackgroundColor(lightRed)
        }
        if (userChoice == 2) {
            homeLayout.setBackgroundColor(lightPurple)
        }
        if (userChoice == 3) {
            homeLayout.setBackgroundColor(lightYellow)
        }
    }

    private fun addToExisting(){
        val filePath = "/data/data/aryan1.jairam2.codemasters/files/CodeMasters.txt"
        val file = File(filePath)
        val editText : EditText = binding!!.jairamET1
        file.appendText(editText.text.toString()+ "\n")
        Toast.makeText(activity, getText(R.string.addTxtSuc).toString(), Toast.LENGTH_SHORT).show()
    }

    private fun createAndAdd() {
        try {
            val editText : EditText = binding!!.jairamET1
            val fileOutputStream: FileOutputStream = requireActivity().openFileOutput(getText(R.string.jayAryanET).toString(), Context.MODE_PRIVATE)
            val outputWriter = OutputStreamWriter(fileOutputStream)
            outputWriter.append(editText.text.toString()+"\n")
            outputWriter.close()
            Toast.makeText(activity, getText(R.string.addTxtSuc), Toast.LENGTH_SHORT).show()
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
