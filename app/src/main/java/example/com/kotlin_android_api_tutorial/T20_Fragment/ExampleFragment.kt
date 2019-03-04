package example.com.kotlin_android_api_tutorial.T20_Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import example.com.kotlin_android_api_tutorial.R
import kotlinx.android.synthetic.main.fragment_example.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ExampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_example, container, false)
        var btnIncrease = v.findViewById<Button>(R.id.btnIncrease)
        btnIncrease.setOnClickListener {
            var count = textViewCounter.text.toString().toInt() + 1
            textViewCounter.text = count.toString()
        }

        return v
    }


}
