package com.example.viewmodeldaggerex.di

import com.example.viewmodeldaggerex.MainActivity
import com.example.viewmodeldaggerex.di.mainActivity.MainActivityModule
import com.example.viewmodeldaggerex.di.mainActivity.MainActivityViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [MainActivityViewModelModule::class, MainActivityModule::class]
    )
   abstract fun contributesMainActivity() : MainActivity
}