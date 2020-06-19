package com.example.viewmodeldaggerex.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

//used coz the normal view model can't have parameter (and made di not effective on vm so that's why we need workaround)
//@JvmSuppressWildcards : used to fix problem happend in kotlin library ver 1.3.30 <= 
class ViewModelProviderFactory @Inject
constructor (val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) { // if the viewmodel has not been created

            // loop through the allowable keys (aka allowed classes with the @ViewModelKey)
            for ((key, value) in creators) {
                // if it's allowed, set the Provider<ViewModel>
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        // if this is not one of the allowed keys, throw exception
        requireNotNull(creator) { "unknown model class $modelClass" }

        // return the Provider
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

    companion object {
        val TAG = "ViewModelProviderFactor"
    }
}