package com.brainx.modulesproject.activities

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.brainx.modulesproject.R
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.activity_line_graph.*
import java.util.*


class LineGraphActivity : AppCompatActivity() {

    var values = ArrayList<Entry>()
    var iterator = 0f

    private val colors = intArrayOf(
        R.color.white,
        R.color.design_default_color_primary_variant,
        R.color.design_default_color_secondary_variant
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_graph)

        object : CountDownTimer(300000, 2000) {
            override fun onTick(millisUntilFinished: Long) {
                // setData((millisUntilFinished / 10000).toInt(), millisUntilFinished.toFloat())
                setData()
                lineChart.invalidate()
            }

            override fun onFinish() {}
        }.start()
    }


    private fun setData(count: Int, range: Float) {

        if (lineChart == null) return

        //val endPoint: Int = values.size + count
        for (i in 0..2) {

            var values = ArrayList<Entry>()
            var iterator = 0f

            while (iterator < 100) {
                val randomValue = (Math.random() * range).toFloat()
                values.add(Entry(iterator, randomValue, iterator * 1.25))
                iterator++
            }
            var set1: LineDataSet
            /*if (lineChart.getData() != null &&
                lineChart.getData().getDataSetCount() > 0
            ) {
                set1 = (lineChart.getData().getDataSetByIndex(0) as LineDataSet?)!!
                set1.values = values
                set1.notifyDataSetChanged()
                lineChart.getData().notifyDataChanged()
                lineChart.notifyDataSetChanged()
            } else*/
            val l: Legend = lineChart.getLegend()
            l.form = Legend.LegendForm.SQUARE
            l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
            l.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
            l.orientation = Legend.LegendOrientation.HORIZONTAL
            l.setDrawInside(true)
            lineChart.getDescription().setEnabled(false)

            // create a dataset and give it a type
            set1 = LineDataSet(values, "Dataset_$i")
            set1.setDrawIcons(false)

            // black lines and points for multiple lines
            if (i == 0) {
                set1.color = Color.WHITE
                set1.setCircleColor(Color.WHITE)
            } else if (i == 1) {
                set1.color = Color.GREEN
                set1.setCircleColor(Color.GREEN)
            } else if (i == 2) {
                set1.color = Color.BLUE
                set1.setCircleColor(Color.BLUE)
            } else if (i == 3) {
                set1.color = Color.parseColor("#6606060")
                set1.setCircleColor(Color.parseColor("#6606060"))
            } else {
                set1.color = Color.parseColor("#84848484")
                set1.setCircleColor(Color.parseColor("#84848484"))
            }

            // line thickness and point size
            set1.lineWidth = 1f

            // draw points as solid circles
            set1.setDrawCircleHole(false)

            // hide circles on edges
            set1.setDrawCircles(false)

            // hide values
            set1.setDrawValues(false)

            // customize legend entry
            set1.formLineWidth = 1f

/*
                set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
                set1.setFormSize(15.f);
*/

            // text size of values
            set1.valueTextSize = 9f

            // set the filled area
            set1.setDrawFilled(false)
            set1.fillFormatter =
                IFillFormatter { dataSet: ILineDataSet?, dataProvider: LineDataProvider? ->
                    lineChart.getAxisLeft().getAxisMinimum()
                }
            val dataSets = ArrayList<ILineDataSet>()
            dataSets.add(set1) // add the data sets

            // create a data object with the data sets
            val data = LineData(dataSets)

            // set data
            lineChart.setData(data)
            lineChart.notifyDataSetChanged()
            lineChart.invalidate()
        }
    }

    fun setData() {
        val dataSets: ArrayList<ILineDataSet> = ArrayList()

        for (z in 0..2) {

            val values: ArrayList<Entry> = ArrayList()

            for (i in 0 until 100) {
                val `val`: Double = Math.random() * 100 * i + 3
                values.add(Entry(i.toFloat(), `val`.toFloat()))
            }
            val d = LineDataSet(values, "DataSet " + (z + 1))
            d.lineWidth = 1f
            d.circleRadius = 0f
            val color: Int = colors[z % colors.size]
            d.color = color

            d.setDrawCircleHole(false)
            d.setCircleColor(color)
            dataSets.add(d)
        }

        // make the first DataSet dashed

        // make the first DataSet dashed
/*        (dataSets[0] as LineDataSet).enableDashedLine(10f, 10f, 0f)
        (dataSets[0] as LineDataSet).setColors(*ColorTemplate.VORDIPLOM_COLORS)
        (dataSets[0] as LineDataSet).setCircleColors(*ColorTemplate.VORDIPLOM_COLORS)*/

        val data = LineData(dataSets)
        lineChart.setData(data)
        lineChart.invalidate()
    }
}