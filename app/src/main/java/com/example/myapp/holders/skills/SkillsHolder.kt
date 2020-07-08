package com.example.myapp.holders.skills

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.skills_view.view.*

class SkillsHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(dataSkillsHolder: DataSkillsHolder) {
        view.apply {
            skill.text = dataSkillsHolder.skill
            experience.text = dataSkillsHolder.experience
        }
    }
}