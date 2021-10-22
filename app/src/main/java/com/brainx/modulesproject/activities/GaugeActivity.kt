package com.brainx.modulesproject.activities

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.animation.AnimationSet
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.brainx.modulesproject.R
import kotlinx.android.synthetic.main.activity_gauge.*
import java.util.*


class GaugeActivity : AppCompatActivity() {

    var previous = 0f
    var newValue = 0f

    var upperPrevious = 0f
    var upperNewValue = 0f

    var lowerPrevious = 0f
    var lowerNewValue = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gauge)

        object : CountDownTimer(300000, 2000) {
            override fun onTick(millisUntilFinished: Long) {
                setData(Random().nextFloat() * 1000)
            }

            override fun onFinish() {}
        }.start()


        object : CountDownTimer(300000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                //         setUpperData(Random().nextFloat() * 101)
            }

            override fun onFinish() {}
        }.start()

        object : CountDownTimer(300000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                //       setLowerData(Random().nextFloat() * 99)
            }

            override fun onFinish() {}
        }.start()
    }

    private fun setData(nextFloat: Float) {

        newValue = Math.abs(nextFloat - previous)

        Log.d("speed", "new_$newValue")
        Log.d("speed", "old_$previous")

        val animSet = AnimationSet(true)
        animSet.interpolator = LinearInterpolator()
        animSet.fillAfter = true
        animSet.isFillEnabled = true

        val animRotate = RotateAnimation(
            previous, newValue / 1000,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )

        animRotate.duration = 2000
        animSet.addAnimation(animRotate)

        iv_main_needle.startAnimation(animSet)
        previous = newValue
    }

    private fun setUpperData(nextFloat: Float) {

        upperNewValue = Math.abs(nextFloat - upperPrevious)

        val animSet = AnimationSet(true)
        animSet.interpolator = LinearInterpolator()
        animSet.fillAfter = true
        animSet.isFillEnabled = true

        val animRotate = RotateAnimation(
            upperPrevious, upperNewValue,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )

        animRotate.duration = 500
        animRotate.fillAfter = true
        animSet.addAnimation(animRotate)
        iv_upper_needle.startAnimation(animSet)

        upperPrevious = upperNewValue
    }

    private fun setLowerData(nextFloat: Float) {

        lowerNewValue = Math.abs(nextFloat - lowerPrevious)

        val animSet = AnimationSet(true)
        animSet.interpolator = LinearInterpolator()
        animSet.fillAfter = true
        animSet.isFillEnabled = true

        val animRotate = RotateAnimation(
            -lowerPrevious, -lowerNewValue,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )

        animRotate.duration = 500
        animRotate.fillAfter = true
        animSet.addAnimation(animRotate)
        iv_lower_needle.startAnimation(animSet)

        lowerPrevious = lowerNewValue
    }
}