package aryan1.jairam2.codemasters.ui.file

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import aryan1.jairam2.codemasters.R
import aryan1.jairam2.codemasters.databinding.FileContentFragmentBinding
import aryan1.jairam2.codemasters.databinding.HomeFragmentBinding
import aryan1.jairam2.codemasters.ui.home.HomeViewModel

class FileContentFrag : Fragment() {

    private var binding: FileContentFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FileContentFragmentBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        //val textView: TextView = binding!!.
        //textView.text = getText(R.string.jkTest)


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}