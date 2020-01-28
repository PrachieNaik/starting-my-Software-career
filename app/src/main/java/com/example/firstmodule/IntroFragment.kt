package com.example.firstmodule
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class IntroFragment : Fragment() {
    companion object {
        fun newInstance(Number: String): Fragment {
            val fragment = IntroFragment()
            val args = Bundle()
            args.putString("Number", Number)
            fragment.arguments = args
            return fragment
        }}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_intro_screen, container, false)!!
    }




}