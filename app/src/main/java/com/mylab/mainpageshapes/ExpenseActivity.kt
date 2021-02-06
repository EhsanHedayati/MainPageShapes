package com.mylab.mainpageshapes

import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.mylab.mainpageshapes.data.ExpenseAdapter
import com.mylab.mainpageshapes.data.ExpenseItem
import kotlinx.android.synthetic.main.activity_expense.*
import kotlinx.android.synthetic.main.activity_expense.more_less_layout
import kotlinx.android.synthetic.main.activity_income.*

class ExpenseActivity : AppCompatActivity() {

    //val itemValue = ArrayList<ExpenseItemValue>()

    private val expenseAdapter = ExpenseAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense)

        expense_recycler.adapter = expenseAdapter
        val list = getList()
        expenseAdapter.submitList(list)

        val barEntry = ArrayList<BarEntry>()
        barEntry.add(BarEntry(0f, 2500000f))
        barEntry.add(BarEntry(1f, 4000000f))
        barEntry.add(BarEntry(2f, 1000000f))
        barEntry.add(BarEntry(3f, 3600000f))
        barEntry.add(BarEntry(4f, 890000f))
        barEntry.add(BarEntry(5f, 120000f))
        barEntry.add(BarEntry(6f, 3600000f))
        barEntry.add(BarEntry(7f, 1200000f))
        barEntry.add(BarEntry(8f, 0f))
        barEntry.add(BarEntry(9f, 2000000f))
        barEntry.add(BarEntry(10f, 500000f))

        //--------------------------------------
        val labelsName = ArrayList<String>()
        labelsName.add("خوراک")
        labelsName.add("مسکن")
        labelsName.add("حمل و نقل")
        labelsName.add("نقلیه")
        labelsName.add("تفریح")
        labelsName.add("ارتباط")
        labelsName.add("پوشاک")
        labelsName.add("بهداشت")
        labelsName.add("متفرقه")
        labelsName.add("پس انداز")
        labelsName.add("سرمایه")
        //--------------------------------------

        val barDataSet = BarDataSet(barEntry, "")
        barDataSet.color = R.color.navy_blue
        barDataSet.valueTextColor = ContextCompat.getColor(this, R.color.white)

        val barData = BarData(barDataSet)
        expense_barChart.data = barData
        val xAxis = expense_barChart.xAxis
        val yAxisLeft = expense_barChart.getAxis(YAxis.AxisDependency.LEFT)
        val yAxisRight = expense_barChart.getAxis(YAxis.AxisDependency.RIGHT)
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
        expense_barChart.animateY(2000)
        expense_barChart.invalidate()


        more_less_layout.setOnClickListener {

            if (expense_recycler.visibility == View.GONE) {

                expense_recycler.visibility = View.VISIBLE
                expense_barChart.visibility = View.GONE
                more_less_img.setImageResource(R.drawable.ic_baseline_expand_less_24)

            } else {

                expense_recycler.visibility = View.GONE
                more_less_img.setImageResource(R.drawable.ic_baseline_expand_more_24)
                expense_barChart.visibility = View.VISIBLE

            }
        }


    }

    private fun getList(): ArrayList<ExpenseItem> {

        return arrayListOf(
            ExpenseItem("خوراک", "56%", R.drawable.ic_icon_food),
            ExpenseItem("خوراک", "56%", R.drawable.ic_icon_food),
            ExpenseItem("خوراک", "56%", R.drawable.ic_icon_food),
            ExpenseItem("خوراک", "56%", R.drawable.ic_icon_food),
            ExpenseItem("خوراک", "56%", R.drawable.ic_icon_food),
            ExpenseItem("خوراک", "56%", R.drawable.ic_icon_food),
            ExpenseItem("خوراک", "56%", R.drawable.ic_icon_food),
            ExpenseItem("خوراک", "56%", R.drawable.ic_icon_food),
            ExpenseItem("خوراک", "56%", R.drawable.ic_icon_food),
            ExpenseItem("خوراک", "56%", R.drawable.ic_icon_food)
        )

    }


}
