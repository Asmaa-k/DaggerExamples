package com.example.viewmodeldaggerex.di

import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldaggerex.viewModel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(modelFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}