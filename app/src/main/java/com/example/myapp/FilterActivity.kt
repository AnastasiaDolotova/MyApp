package com.example.myapp

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : AppCompatActivity() {

    companion object {
        private const val KEY_CHECKED = "checked"
        private const val KEY_SELECT_ALL = "selectAll"
        const val KEY_ITEMS = "items"
        const val KEY_FLAG = "flag"
    }

    private val items = listOf(
        "<1 year",
        "1 year",
        "2 years",
        "More"
    )

    private var flag = false

    private lateinit var adapter: FilterAdapter
    private lateinit var list: BooleanArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        list = savedInstanceState?.getBooleanArray(KEY_CHECKED) ?: BooleanArray(4)
        if (savedInstanceState?.getBoolean(KEY_SELECT_ALL) == null) {
            flag = true
            checkAll.isChecked = true
        } else {
            checkAll.isChecked = savedInstanceState.getBoolean(KEY_SELECT_ALL)
            flag = false
        }
        adapter = FilterAdapter(items, this, list, checkAll.isChecked, flag)
        if (checkAll.isChecked)
            selectAll()
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            recyclerFilter.layoutManager = LinearLayoutManager(this)
        else if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            recyclerFilter.layoutManager = GridLayoutManager(this, 2)
        recyclerFilter.adapter = adapter
        btnApply.setOnClickListener {
            intent = Intent().putExtra(KEY_ITEMS, adapter.list)
            intent.putExtra(KEY_FLAG, checkAll.isChecked)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        checkAll.setOnClickListener {
            if (checkAll.isChecked) {
                adapter.selectAll()
            } else {
                adapter.unSelectAll()
            }
            adapter.flag = true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(KEY_SELECT_ALL, checkAll.isChecked)
        outState.putBooleanArray(KEY_CHECKED, adapter.list)
        super.onSaveInstanceState(outState)
    }

    fun unSelectAll() {
        checkAll.isChecked = false
    }

    fun selectAll() {
        checkAll.isChecked = true
    }
}
