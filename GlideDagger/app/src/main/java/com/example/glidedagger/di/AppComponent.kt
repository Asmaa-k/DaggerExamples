package com.example.glidedagger.di

import com.example.glidedagger.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AndroidSupportInjectionModule::class
    , ActivityBuilderModule::class
    , AppModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app : App) : Builder

        fun build() : AppComponent
    }
}