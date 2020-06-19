package com.example.retrofitdagger.network

import com.google.gson.annotations.SerializedName

data class PostModel(
    @SerializedName("title") val title : String
)