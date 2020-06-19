package com.example.subcomponentdaggerexample.di.firstActivity

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.subcomponentdaggerexample.App
import com.example.subcomponentdaggerexample.R
import dagger.Module
import dagger.Provides

@Module
class FirstActivityModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @FirstActivityScope
        fun providesRequestOption(): RequestOptions =
            RequestOptions().placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

        @JvmStatic
        @Provides
        @FirstActivityScope
        fun requestManager(app: App, requestOption: RequestOptions): RequestManager =
            Glide.with(app).setDefaultRequestOptions(requestOption)


    }
}