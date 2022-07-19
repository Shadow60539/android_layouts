package com.example.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

//    private val weekDaysList = listOf<String>(
//        "Monday",
//        "Tuesday",
//        "Wednesday",
//        "Thursday",
//        "Friday",
//        "Saturday",
//        "Sunday",
//    )

    private val users = mutableListOf<User>()
//    private lateinit var adapter: ArrayAdapter<User>
//    lateinit var spWeekDays: Spinner
    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview)

        for (i in 0..10) {
            users.add(User(i, "Person $i", "someone$i@gmail.com"))
        }

//        adapter = ArrayAdapter<User>(
//            this,
//            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
//            users,
//        )
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
        recyclerView = findViewById(R.id.rvUsers)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(users) {
            Toast.makeText(this, users[it].email, Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = userAdapter
    }
}