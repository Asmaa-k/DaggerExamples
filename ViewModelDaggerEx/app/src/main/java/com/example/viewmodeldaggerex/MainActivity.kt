package com.example.viewmodeldaggerex

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldaggerex.viewModel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this, providerFactory).get(MainActivityViewModel::class.java)
        mainText.text = viewModel.testString
    }
}

/* for lifecycle 2.2.0 dependacy

**With ViewModelFactory
*** val viewModel = ViewModelProvider(this, YourViewModelFactory).get(YourViewModel::class.java)

**Without ViewModelFactory
*** val viewModel = ViewModelProvider(this).get(YourViewModel::class.java)

 */