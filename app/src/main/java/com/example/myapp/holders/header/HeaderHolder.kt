package com.example.myapp.holders.header

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.FilterActivity
import kotlinx.android.synthetic.main.header.view.*

class HeaderHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(dataHeaderHolder: DataHeaderHolder) {
        view.apply {
            header.text = dataHeaderHolder.header
            imgFilter.setOnClickListener {
                val intent = Intent(dataHeaderHolder.activity, FilterActivity::class.java)
                dataHeaderHolder.activity.startActivityForResult(
                    intent,
                    dataHeaderHolder.requestCode
                )
            }
        }
    }
}