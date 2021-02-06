package com.mylab.mainpageshapes

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.model.GradientColor
import com.mylab.mainpageshapes.data.IncomeAdapter
import com.mylab.mainpageshapes.data.IncomeItem
import kotlinx.android.synthetic.main.activity_income.*


class IncomeActivity : AppCompatActivity() {

    private val gradientColors: MutableList<GradientColor>? = null


    private val incomeAdapter = IncomeAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income)

        //--------------------------------------


        //--------------------------------------


        income_recycler.adapter = incomeAdapter

        incomeAdapter.submitList(doubleList())

        val barEntry = ArrayList<BarEntry>()
        barEntry.add(BarEntry(0f, 25000000f))
        barEntry.add(BarEntry(1f, 2000000f))
        barEntry.add(BarEntry(2f, 560000f))
        barEntry.add(BarEntry(3f, 450000f))
        barEntry.add(BarEntry(4f, 3000000f))
        barEntry.add(BarEntry(5f, 0f))

        //------------------------------------------

        val labelsName = ArrayList<String>()
        labelsName.add("حقوق")
        labelsName.add("پاداش")
        labelsName.add("دستمزد")
        labelsName.add("یارانه")
        labelsName.add("سودبانکی")
        labelsName.add("سودسهام")
        //-------------------------------------------


        val barDataSet = BarDataSet(barEntry, "")

        barDataSet.setGradientColor(R.color.start_color_bar, R.color.end_color_bar)

        val barData = BarData(barDataSet)



        barDataSet.valueTextColor = ContextCompat.getColor(this, R.color.white)
        income_barChart.data = barData
        val xAxis = income_barChart.xAxis
        val yAxisLeft = income_barChart.getAxis(YAxis.AxisDependency.LEFT)
        val yAxisRight = income_barChart.getAxis(YAxis.AxisDependency.RIGHT)
        xAxis.textColor = ContextCompat.getColor(this, R.color.white)
        yAxisLeft.textColor = ContextCompat.getColor(this, R.color.white)
        yAxisRight.textColor = ContextCompat.getColor(this, R.color.white)
        xAxis.valueFormatter = object : IndexAxisValueFormatter(labelsName) {}
        xAxis.position = XAxis.XAxisPosition.TOP
        xAxis.setDrawAxisLine(false)
        xAxis.granularity = 1f

        xAxis.setDrawGridLines(false)
        xAxis.labelCount = labelsName.size
        xAxis.labelRotationAngle = 270f



        income_barChart.animateY(2000)
        income_barChart.invalidate()



        income_more_less_img.setOnClickListener {

            if (income_barChart.visibility == View.VISIBLE) {

                incomeAdapter.submitList(multipleList())
                income_barChart.visibility = View.GONE
                income_more_less_img.setImageResource(R.drawable.ic_baseline_expand_less_24)

            } else {
                incomeAdapter.submitList(doubleList())
                income_barChart.visibility = View.VISIBLE
                income_more_less_img.setImageResource(R.drawable.ic_baseline_expand_more_24)
            }

        }
    }

    private fun doubleList(): List<IncomeItem> {
        return listOf<IncomeItem>(
            IncomeItem("حقوق", "70%", R.drawable.ic_icon_pay),
            IncomeItem("دستمزد", "24%", R.drawable.ic_icon_salary)
        )
    }

    private fun multipleList(): List<IncomeItem> {

        return listOf(
            IncomeItem("دستمزد", "74%", R.drawable.ic_icon_pay),
            IncomeItem("یارانه", "1%", R.drawable.ic_icon_pay),
            IncomeItem("سود بانکی", "17%", R.drawable.ic_icon_pay),
            IncomeItem("حقوق", "5%", R.drawable.ic_icon_pay),
            IncomeItem("پاداش", "6%", R.drawable.ic_icon_pay),
            IncomeItem("سود سهام", "7%", R.drawable.ic_icon_pay),
            IncomeItem("سود عدالت", "8%", R.drawable.ic_icon_pay),
            /*  IncomeItem("سود عدالت", "8%", R.drawable.ic_icon_pay),
              IncomeItem("سود عدالت", "8%", R.drawable.ic_icon_pay),
              IncomeItem("سود عدالت", "8%", R.drawable.ic_icon_pay)*/


        )

    }
}