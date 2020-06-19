package com.example.retrofitdagger.network

import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    fun getData() : Observable<List<PostModel>>
}