package com.example.subcomponentdaggerexample.di

import com.example.subcomponentdaggerexample.di.firstActivity.FirstActivityModule
import com.example.subcomponentdaggerexample.di.firstActivity.FirstActivityScope
import com.example.subcomponentdaggerexample.di.secondActivity.FragmentBuildersModule
import com.example.subcomponentdaggerexample.di.secondActivity.SecondActivityModule
import com.example.subcomponentdaggerexample.di.secondActivity.SecondActivityScope
import com.example.subcomponentdaggerexample.ui.fitstActivity.FirstActivity
import com.example.subcomponentdaggerexample.ui.secondActivity.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @FirstActivityScope
    @ContributesAndroidInjector(
        modules = [FirstActivityModule::class]
    )
    abstract fun contributesFirstActivity() : FirstActivity


    @SecondActivityScope
    @ContributesAndroidInjector(
        modules = [SecondActivityModule::class, FragmentBuildersModule::class]
    )
    abstract fun contributesSecondActivity() : SecondActivity
}