package com.example.list_view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    private val weekDaysList = arrayListOf<String>(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday",
    )

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var lvUsers: ListView
    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview)

        adapter = ArrayAdapter<String>(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            weekDaysList,
        )

        lvUsers = findViewById(R.id.lvUsers)
        lvUsers.adapter = adapter
        lvUsers.setOnItemClickListener { _, _, index, _ ->
            Toast.makeText(this, weekDaysList[index], Toast.LENGTH_SHORT).show()
        }

        refreshLayout = findViewById<SwipeRefreshLayout>(R.id.refreshLayout).apply {
            setOnRefreshListener {
                weekDaysList.add(0, weekDaysList.random())
                adapter.notifyDataSetChanged()
                this.isRefreshing = false
            }
        }
    }
}