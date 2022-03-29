package aryan1.jairam2.codemasters.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import aryan1.jairam2.codemasters.R
import aryan1.jairam2.codemasters.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    private var binding: HomeFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val textView: TextView = binding!!.tv1
        textView.text = getText(R.string.jkTest)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}