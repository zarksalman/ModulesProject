package com.brainx.modulesproject.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.brainx.modulesproject.R
import com.brainx.modulesproject.viewmodel.TestViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    @Inject
    @Named("string1")
    lateinit var stringFromAppModule: String

    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

        Log.d("main_activity", "test string from main activity is $stringFromAppModule")
        testViewModel
    }
}