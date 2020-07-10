package com.example.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.holders.header.DataHeaderHolder
import com.example.myapp.holders.header.HeaderHolder
import com.example.myapp.holders.info.DataInfoHolder
import com.example.myapp.holders.info.InfoHolder
import com.example.myapp.holders.project.DataProjectHolder
import com.example.myapp.holders.project.ProjectHolder
import com.example.myapp.holders.skills.DataSkillsHolder
import com.example.myapp.holders.skills.SkillsHolder

class Adapter(private var items: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            0 -> InfoHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.user_info_view,
                    parent,
                    false
                )
            )
            1 -> ProjectHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.project_info_view,
                    parent,
                    false
                )
            )
            2 -> HeaderHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.header,
                    parent,
                    false
                )
            )
            else -> SkillsHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.skills_view,
                    parent,
                    false
                )
            )
        }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 -> (holder as InfoHolder).onBind(items[0] as DataInfoHolder)
            1 -> (holder as ProjectHolder).onBind(items[1] as DataProjectHolder)
            2 -> (holder as HeaderHolder).onBind(items[2] as DataHeaderHolder)
            else -> (holder as SkillsHolder).onBind(items[position] as DataSkillsHolder)
        }
    }
}