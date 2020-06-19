package com.example.glidedagger

import android.os.Bundle
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_glide.*
import javax.inject.Inject

class GlideActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var rm: RequestManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        rm.load("https://images.unsplash.com/photo-1462275646964-a0e3386b89fa?ixlib=rb-1.2.1")
            .into(login_logo)
    }
}