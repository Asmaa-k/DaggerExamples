package com.example.subcomponentdaggerexample.di.secondActivity

import com.example.subcomponentdaggerexample.ui.secondActivity.FragmentTwo
import com.example.subcomponentdaggerexample.ui.secondActivity.FragmentOne
import com.example.subcomponentdaggerexample.ui.secondActivity.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector()
    abstract fun contributesFragmentOne() : FragmentOne

    @ContributesAndroidInjector()
    abstract fun contributesFragmentTwo() : FragmentTwo

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment() : HomeFragment

}