package com.mylab.mainpageshapes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.mylab.mainpageshapes.databinding.ActivityAddExpenseBinding

class AddExpenseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddExpenseBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_expense)

        val list = arrayListOf<String>()
        list.add("حقوق")
        list.add("دستمزد")
        list.add("پاداش")
        list.add("سود سهام")
        list.add("سود بانکی")
        list.add("یارانه")
        list.add("سایر درآمدها")


        val arrayAdapter = ArrayAdapter(this, R.layout.spinner_item, list)
        arrayAdapter.setDropDownViewResource(R.layout.drop_down_item)

        binding.expenseSpinner.adapter = arrayAdapter


        binding.expenseSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
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