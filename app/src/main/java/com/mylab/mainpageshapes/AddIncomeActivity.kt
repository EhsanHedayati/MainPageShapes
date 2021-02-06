package com.mylab.mainpageshapes

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mylab.mainpageshapes.databinding.ActivityAddIncomeBinding


class AddIncomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddIncomeBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_income)

        /*val px = binding.editTextTextPersonName.textSize
        val sp = px / resources.displayMetrics.scaledDensity
        Toast.makeText(this, sp.toString(), Toast.LENGTH_SHORT).show()*/





        val list = arrayListOf<String>()
        list.add("مسکن")
        list.add("خوراک")
        list.add("حمل و نقل")
        list.add("وسیله نقلیه")
        list.add("تفریحات")
        list.add("ارتباطات")
        list.add("پوشاک")
        list.add("بهداشت")
        list.add("سرمایه گذاری")
        list.add("پس انداز")
        list.add("سایر هزینه ها")

        val arrayAdapter = ArrayAdapter(this, R.layout.spinner_item, list)
        arrayAdapter.setDropDownViewResource(R.layout.drop_down_item)

        binding.incomeSpinner.adapter = arrayAdapter

        binding.incomeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val selectedItem = parent?.getItemAtPosition(position)
                if (selectedItem.toString() != "انتخاب عنوان هزینه") {
                    //Toast.makeText(this@AddIncomeActivity, "$selectedItem", Toast.LENGTH_SHORT).show()


                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
    }
}