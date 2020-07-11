package com.example.myapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.holders.header.DataHeaderHolder
import com.example.myapp.holders.info.DataInfoHolder
import com.example.myapp.holders.project.DataProjectHolder
import com.example.myapp.holders.skills.DataSkillsHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 666
    }

    private var list = BooleanArray(4)
    private var flag = true

    private lateinit var items: ArrayList<Any>
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createList()
        adapter = Adapter(items, flag)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        var i = 0
        for (item in list) {
            if (item) {
                items.removeAt(i + 3)
                i--
            }
            i++
        }
        adapter = Adapter(items, flag)
        recycler.adapter = adapter
        createList()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            list = data.getBooleanArrayExtra(FilterActivity.KEY_ITEMS)
            flag = data.getBooleanExtra(FilterActivity.KEY_FLAG, flag)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun createList() {
        items = arrayListOf(
            DataInfoHolder(
                "Anastasia Dolotova",
                "11 grade",
                "https://github.com/AnastasiaDolotova"
            ),
            DataProjectHolder("Project", "Very cool project :)"),
            DataHeaderHolder("Skills", this, REQUEST_CODE),
            DataSkillsHolder("Kotlin", "<1 year"),
            DataSkillsHolder("C++", "1 year"),
            DataSkillsHolder("Java", "2 year"),
            DataSkillsHolder("Python", "3 years")
        )
    }
}
