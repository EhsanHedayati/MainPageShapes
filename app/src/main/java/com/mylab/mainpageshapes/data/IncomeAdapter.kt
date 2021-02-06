package com.mylab.mainpageshapes.data


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mylab.mainpageshapes.R
import kotlinx.android.synthetic.main.income_item.view.*

class IncomeAdapter : ListAdapter<IncomeItem, IncomeAdapter.ViewHolder>(IncomeDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.income_item,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(currentList[position])

    }


    class IncomeDiffUtil : DiffUtil.ItemCallback<IncomeItem>() {
        override fun areItemsTheSame(oldItem: IncomeItem, newItem: IncomeItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: IncomeItem, newItem: IncomeItem): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        private val title = view.list_income_title
        private val percent = view.list_income_percent
        private val image = view.list_income_image

        fun bind(incomeItem: IncomeItem) {

            title.text = incomeItem.title
            percent.text = incomeItem.percent
            image.setImageResource(R.drawable.ic_icon_pay)

        }

    }


}