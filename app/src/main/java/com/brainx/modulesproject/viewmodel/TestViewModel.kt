package com.brainx.modulesproject.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import javax.inject.Named

class TestViewModel @ViewModelInject constructor(
    @Named("string1") string1: String
) : ViewModel() {

    init {
        Log.d("viewModel", "String from view Model - $string1")
    }
}