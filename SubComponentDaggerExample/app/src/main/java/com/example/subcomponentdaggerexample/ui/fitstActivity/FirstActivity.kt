package com.example.subcomponentdaggerexample.ui.fitstActivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.RequestManager
import com.example.subcomponentdaggerexample.R
import com.example.subcomponentdaggerexample.ui.secondActivity.SecondActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_first.*
import javax.inject.Inject

class FirstActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        requestManager.load("https://images.unsplash.com/photo-1462275646964-a0e3386b89fa?ixlib=rb-1.2.1")
            .into(login_logo)


    }

    fun next(view: View) {
        if(view.id != R.id.btn) return
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}