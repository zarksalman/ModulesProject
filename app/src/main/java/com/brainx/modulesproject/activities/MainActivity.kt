package com.brainx.modulesproject.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brainx.modulesproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        btn_line_graph.setOnClickListener {
            startActivity(Intent(this, LineGraphActivity::class.java))
        }

        btn_multiline_graph.setOnClickListener {
            startActivity(Intent(this, MultiLineChartActivity::class.java))
        }

        btn_gauge.setOnClickListener {
            startActivity(Intent(this, GaugeActivity::class.java))
        }

        btn_hilt.setOnClickListener {
            startActivity(Intent(this, HiltActivity::class.java))
        }
    }
}