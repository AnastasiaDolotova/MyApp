package com.example.myapp.holders.project

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.Adapter
import kotlinx.android.synthetic.main.project_info_view.view.*

class ProjectHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(dataProjectHolder: DataProjectHolder) {
        view.apply {
            project.text = dataProjectHolder.project
            info.text = dataProjectHolder.info
        }
    }
}