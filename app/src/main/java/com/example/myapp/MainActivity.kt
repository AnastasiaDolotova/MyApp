package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.holders.header.DataHeaderHolder
import com.example.myapp.holders.info.DataInfoHolder
import com.example.myapp.holders.project.DataProjectHolder
import com.example.myapp.holders.skills.DataSkillsHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = Adapter(
        listOf(
            DataInfoHolder(
                "Anastasia Dolotova",
                "10 class",
                "https://github.com/AnastasiaDolotova"
            ),
            DataProjectHolder("Project", "Very cool project :)"),
            DataHeaderHolder("Skills"),
            DataSkillsHolder("Python", "3 years"),
            DataSkillsHolder("Java", ">1 year"),
            DataSkillsHolder("C++", "1 year"),
            DataSkillsHolder("Kotlin", "<1 year")
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }
}
