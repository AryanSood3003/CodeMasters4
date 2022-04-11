//Jairam Kakar - N01179234 - CENG-258-RNC
//Aryan Sood - N01393003 - CENG-258-RNA
package aryan1.jairam2.codemasters.ui.file

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import aryan1.jairam2.codemasters.R
import aryan1.jairam2.codemasters.databinding.FileFragBinding
import java.io.File
import java.io.InputStreamReader


class FileContentFrag : Fragment() {

    private var binding: FileFragBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FileFragBinding.inflate(inflater, container, false)
        val root: View = binding!!.root

        // Creating variable holders for buttons
        val displayBtn : Button = binding!!.jairamAryanDisplayBtn
        val deleteBtn : Button = binding!!.jairamAryanDeleteBtn

        // If display button is clicked
        displayBtn.setOnClickListener {//On clicking of Display button
            display() // Call display function
        }
        // If delete button is clicked
        deleteBtn.setOnClickListener() {//On clicking of Delete button
            val displayTxt : TextView = binding!!.jairamAryanDisplayTV // Variable holder for TextView
            val filePath = getString(R.string.filePath)// Set the file path
            val file = File(filePath) // Set variable 'file', to file with given filepath
            val exist = file.exists() // Set variable 'exist', to file with given filepath if it exists
            if (exist) {// If file exists
                file.delete()//Deleting the file
                    Toast.makeText(activity, getString(R.string.deleted), Toast.LENGTH_SHORT).show() // Toast to tell user file was deleted
                displayTxt.text = ""//Clearing the display
                } else {
                    //File non existing
                    Toast.makeText(activity, getString(R.string.nonExisting), Toast.LENGTH_SHORT)
                        .show() // Toast to tell user that file does not exist
                }
            }
        return root
    }
    // Display function
    private fun display() {
        val displayTxt : TextView = binding!!.jairamAryanDisplayTV
        try {
            val filePath = getString(R.string.filePath) // Set filepath
            val file = File(filePath) // Set variable 'file', to file with given filepath
            val exist = file.exists() // Set variable 'exist', to file with given filepath if it exists
            Log.d(getString(R.string.input), exist.toString()) // Log Message To Test
            if(exist) {//Opening the file Reader if the file is existing
                val fileInputStream = requireActivity().openFileInput(getString(R.string.txtFile))
                val inputReader = InputStreamReader(fileInputStream)
                val input = inputReader.readText()
                displayTxt.text = input//Sending the data to the textView
            }
            else {
                //If file is non existing
                Toast.makeText(activity, getString(R.string.nonExisting), Toast.LENGTH_SHORT)
                    .show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}