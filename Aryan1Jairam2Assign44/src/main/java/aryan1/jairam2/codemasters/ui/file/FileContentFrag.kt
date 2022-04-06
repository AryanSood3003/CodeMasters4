package aryan1.jairam2.codemasters.ui.file

import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import aryan1.jairam2.codemasters.R
import aryan1.jairam2.codemasters.databinding.FileContentFragmentBinding
import java.io.File
import java.io.InputStreamReader


class FileContentFrag : Fragment() {

    private var binding: FileContentFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FileContentFragmentBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val displayBtn : Button = binding!!.jairamAryanDisplayBtn
        val deleteBtn : Button = binding!!.jairamAryanDeleteBtn
        val displayTxt : TextView = binding!!.jairamAryanDisplayTV


        displayBtn.setOnClickListener {
            try {
                val fileInputStream = requireActivity().openFileInput(getText(R.string.jayAryanET).toString())
                val inputReader = InputStreamReader(fileInputStream)
                val input = inputReader.readText()

                displayTxt.text = input

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        deleteBtn.setOnClickListener(){
            val file = File(getText(R.string.jayAryanET).toString())
            val result = file.delete()
            if (result) {
                Toast.makeText(activity, "Deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Didn't Work", Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}