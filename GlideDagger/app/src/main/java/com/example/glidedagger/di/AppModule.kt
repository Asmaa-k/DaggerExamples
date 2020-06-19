package com.example.glidedagger.di

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.glidedagger.App
import com.example.glidedagger.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Module
    companion object {
        @Singleton
        @JvmStatic
        @Provides
        fun provideRequestOptions(): RequestOptions =
            RequestOptions().placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

        @Singleton
        @JvmStatic
        @Provides
        fun provideGlideInstance(app: App, requestOptions: RequestOptions): RequestManager =
            Glide.with(app)
                .setDefaultRequestOptions(requestOptions)

    }
}