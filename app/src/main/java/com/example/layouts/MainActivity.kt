package com.example.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
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

//    private val users = mutableListOf<User>()
    private lateinit var adapter: ArrayAdapter<String>
//    lateinit var spWeekDays: Spinner
//    private lateinit var userAdapter: UserAdapter
    private lateinit var lvUsers: ListView
//    private lateinit var recyclerView: RecyclerView
    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview)

//        for (i in 0..10) {
//            users.add(User(i, "Person $i", "someone$i@gmail.com"))
//        }

        adapter = ArrayAdapter<String>(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            weekDaysList,
        )
//        spWeekDays = findViewById(R.id.spWeekdays)
//        spWeekDays.adapter = adapter
//
//        spWeekDays.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, index: Int, id: Long) {
//                Toast.makeText(this@MainActivity, users[index].email, Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//            }
//
//        }
//        recyclerView = findViewById(R.id.rvUsers)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        userAdapter = UserAdapter(users) {
//            Toast.makeText(this, users[it].email, Toast.LENGTH_SHORT).show()
//        }
//        recyclerView.adapter = userAdapter
        lvUsers = findViewById(R.id.lvUsers)
        lvUsers.adapter = adapter
        lvUsers.setOnItemClickListener { _, _, index, _ ->
            Toast.makeText(this, weekDaysList[index], Toast.LENGTH_SHORT).show()
        }

        refreshLayout = findViewById<SwipeRefreshLayout>(R.id.refreshLayout).apply {
            setOnRefreshListener {
                weekDaysList.add(0,weekDaysList.random())
                adapter.notifyDataSetChanged()
                this.isRefreshing = false
            }
        }
    }
}