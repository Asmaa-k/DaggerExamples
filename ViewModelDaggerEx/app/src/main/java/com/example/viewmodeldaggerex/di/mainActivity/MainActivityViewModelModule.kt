package com.example.viewmodeldaggerex.di.mainActivity

import androidx.lifecycle.ViewModel
import com.example.viewmodeldaggerex.MainActivityViewModel
import com.example.viewmodeldaggerex.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel


    //if there's another view model relates to fragment we add it here in same class
    //for example
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(ProfileViewModel::class)
    //    abstract fun bindProfileViewModel(viewModel: ProfileViewModel) : ViewModel
}