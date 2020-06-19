package com.example.glidedagger.di

import com.example.glidedagger.GlideActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributesGlideActivity(): GlideActivity
}