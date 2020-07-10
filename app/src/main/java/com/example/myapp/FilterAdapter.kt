package com.example.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.filter_view.view.*

class FilterAdapter(
    private var items: List<String>,
    var filterActivity: FilterActivity,
    var list: BooleanArray,
    var isSelectedAll: Boolean,
    var flag: Boolean
) :
    RecyclerView.Adapter<FilterAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.filter_view, parent, false))


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.onBind(items[position], position)
        if (flag)
            holder.itemView.checkBox.isChecked = isSelectedAll
        else
            holder.itemView.checkBox.isChecked = !(list[position])
        holder.itemView.checkBox.setOnCheckedChangeListener { _, isChecked ->
            list[position] = !isChecked
            if (!isChecked)
                filterActivity.unSelectAll()
            if (checkArray(list))
                filterActivity.selectAll()
        }
    }

    private fun checkArray(checked: BooleanArray): Boolean {
        for (b in checked) {
            if (b) {
                return false
            }
        }
        return true
    }

    fun selectAll() {
        isSelectedAll = true
        notifyDataSetChanged()
    }

    fun unSelectAll() {
        isSelectedAll = false
        notifyDataSetChanged()
    }

    inner class Holder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(string: String, position: Int) {
            view.apply {
                checkBox.text = string

            }
        }
    }

}