package aryan1.jairam2.codemasters.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
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
        val textView: TextView = binding!!.jairamTV1
        val currentDate= LocalDate.now()
        textView.text = currentDate.toString()
        //val textClock : TextClock = binding!!.jairamTC1
        val storeBtn : Button = binding!!.button




        storeBtn.setOnClickListener(){
            createAndAdd()
            val file = File(getText(R.string.jayAryanET).toString())
            val fExist = file.exists()
            val editText : EditText = binding!!.jairamET1
            editText.text.clear()
            if(fExist){
                addToExisting()
            }else{
                createAndAdd()
            }
        }
        return root
    }

    private fun addToExisting(){
        val file = File(getText(R.string.jayAryanET).toString())
        val editText : EditText = binding!!.jairamET1
        file.appendText(editText.text.toString())
        Toast.makeText(activity, getText(R.string.addTxtSuc).toString(), Toast.LENGTH_SHORT).show()
    }

    private fun createAndAdd() {
        try {
            val editText : EditText = binding!!.jairamET1
            val fileOutputStream: FileOutputStream = requireActivity().openFileOutput(getText(R.string.jayAryanET).toString(), Context.MODE_PRIVATE)
            val outputWriter = OutputStreamWriter(fileOutputStream)
            outputWriter.append(editText.text.toString())
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