package com.example.retrofitdagger.di

import com.example.retrofitdagger.util.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
abstract class AppModule {
    @Module
    companion object{
        @Singleton
        @JvmStatic
        @Provides
        fun providesRetrofitInstance() : Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}