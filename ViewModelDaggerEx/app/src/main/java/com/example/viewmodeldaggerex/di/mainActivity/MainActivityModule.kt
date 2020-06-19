package com.example.viewmodeldaggerex.di.mainActivity

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Module
    companion object{
        @JvmStatic
        @Provides
        fun someStrings() : String = "Hello World from... \nView model"
    }

}