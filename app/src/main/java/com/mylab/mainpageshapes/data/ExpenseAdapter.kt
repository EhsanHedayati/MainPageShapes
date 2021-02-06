package com.mylab.mainpageshapes.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mylab.mainpageshapes.R
import kotlinx.android.synthetic.main.expense_item.view.*

class ExpenseAdapter : ListAdapter<ExpenseItem, ExpenseAdapter.ViewHolder>(ExpenseDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.expense_item,
            parent,
            false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(currentList[position])

    }


    class ExpenseDiffUtil : DiffUtil.ItemCallback<ExpenseItem>() {
        override fun areItemsTheSame(oldItem: ExpenseItem, newItem: ExpenseItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ExpenseItem, newItem: ExpenseItem): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.list_expense_title
        private val percent = view.list_expense_percent
        private val image = view.list_expense_image

        fun bind(expenseItem: ExpenseItem) {
            title.text = expenseItem.title
            percent.text = expenseItem.percent
            image.setImageResource(R.drawable.ic_icon_food)


        }

    }


}