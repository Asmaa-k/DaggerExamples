package com.example.retrofitdagger.di

import com.example.retrofitdagger.ui.RetrofitExampleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesRetrofitExampleActivity() : RetrofitExampleActivity
}