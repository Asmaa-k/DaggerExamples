package com.example.viewmodeldaggerex

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val testString: String) : ViewModel() {
}