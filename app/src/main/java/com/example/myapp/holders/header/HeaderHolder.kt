package com.example.myapp.holders.header

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header.view.*

class HeaderHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(dataHeaderHolder: DataHeaderHolder) {
        view.apply {
            header.text = dataHeaderHolder.header
        }
    }
}