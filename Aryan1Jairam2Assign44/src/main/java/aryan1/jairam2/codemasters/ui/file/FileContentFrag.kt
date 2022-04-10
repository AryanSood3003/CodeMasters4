//Jairam Kakar - N01179234 - CENG-258-RNC
//Aryan Sood - N01393003 - CENG-258-RNA
package aryan1.jairam2.codemasters.ui.file

import android.os.Bundle
import android.os.Environment
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
import java.io.FileInputStream
import java.io.InputStreamReader
import java.nio.file.Files.exists


class FileContentFrag : Fragment() {

    private var binding: FileFragBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FileFragBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val displayBtn : Button = binding!!.jairamAryanDisplayBtn
        val deleteBtn : Button = binding!!.jairamAryanDeleteBtn
        displayBtn.setOnClickListener {//On clicking of Display button
            display()
        }

        deleteBtn.setOnClickListener() {//On clicking of Delete button
            val displayTxt : TextView = binding!!.jairamAryanDisplayTV
            val filePath = "/data/data/aryan1.jairam2.codemasters/files/CodeMasters.txt"
            val file = File(filePath)
            val exist = file.exists()
            if (exist) {// If file exists
                file.delete()//Deleting the file
                    Toast.makeText(activity, getString(R.string.deleted), Toast.LENGTH_SHORT).show()
                displayTxt.text = ""//Clearing the display
                } else {
                    //File non existing
                    Toast.makeText(activity, getString(R.string.nonexisting), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        return root
    }

    private fun display() {
        val displayTxt : TextView = binding!!.jairamAryanDisplayTV
        try {
            val filePath = "/data/data/aryan1.jairam2.codemasters/files/CodeMasters.txt"
            val file = File(filePath)
            val exist = file.exists()
            Log.d("input", exist.toString())
            if(exist) {//Opening the file Reader if the file is existing
                val fileInputStream = requireActivity().openFileInput("CodeMasters.txt")
                val inputReader = InputStreamReader(fileInputStream)
                val input = inputReader.readText()
                displayTxt.text = input//Sending the data to the textView
            }
            else {
                //If file is non existing
                Toast.makeText(activity, getString(R.string.nonexisting), Toast.LENGTH_SHORT)
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