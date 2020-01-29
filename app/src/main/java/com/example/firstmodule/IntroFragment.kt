package com.example.firstmodule

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class IntroFragment : Fragment() {
    companion object {
        val TAG = "IntroFragment"
        fun newInstance(Number: String): Fragment {
            val fragment = IntroFragment()
            val args = Bundle()
            args.putString("Number", Number)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"onCreateView")
        val root = inflater.inflate(R.layout.fragment_intro_screen, container, false)!!
        val textView = root.findViewById<TextView>(R.id.tv)
        if (savedInstanceState != null) {
            textView.text = savedInstanceState.get("Number").toString()

        }
        return root
    }


}