package com.example.subcomponentdaggerexample.ui.secondActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.subcomponentdaggerexample.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named

class FragmentOne : DaggerFragment(){
    @Inject
    @Named("string_1")
    lateinit var string: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     val view = inflater.inflate(R.layout.fragment_one, container, false)
        view.findViewById<TextView>(R.id.textView).text = string
        return view
    }
}