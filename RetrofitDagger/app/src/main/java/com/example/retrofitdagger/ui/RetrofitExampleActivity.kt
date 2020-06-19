package com.example.retrofitdagger.ui

import android.os.Bundle
import com.example.retrofitdagger.R
import com.example.retrofitdagger.network.PostApi
import com.example.retrofitdagger.network.PostModel
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitExampleActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var retrofit: Retrofit

    private lateinit var disposable: CompositeDisposable
    private var myAdapter: PostAdapter? = null
    private var posts: ArrayList<PostModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        disposable = CompositeDisposable()
        loadData()
    }

    fun loadData() {
        val requestInterface = retrofit.create(PostApi::class.java)
        disposable.add(
            requestInterface.getData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse)
        )

    }

    private fun handleResponse(listPosts: List<PostModel>) {
        posts = ArrayList(listPosts)
        myAdapter = PostAdapter(posts!!)
        rvPost.adapter = myAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}