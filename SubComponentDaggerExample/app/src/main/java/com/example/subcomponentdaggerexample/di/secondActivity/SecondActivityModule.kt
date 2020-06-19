package com.example.subcomponentdaggerexample.di.secondActivity

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class SecondActivityModule {
    @Module
    companion object{

        @SecondActivityScope
        @Named("home")
        @Provides
        @JvmStatic
        fun stringMain() : String = "Hello From Home Fragment \n this app is for sub component implementation"

        @SecondActivityScope
        @Named("string_1")
        @Provides
        @JvmStatic
        fun stringOne() : String = "Hello From Fragment One"

        @SecondActivityScope
        @Named("string_2")
        @Provides
        @JvmStatic
        fun stringSecond() : String = "Hello From Fragment Two"
    }
}