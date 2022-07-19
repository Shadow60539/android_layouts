package com.example.layouts

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val users = mutableListOf<User>()
    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)

        getUsers()

        recyclerView = findViewById(R.id.rvUsers)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userAdapter = UserAdapter(users) {
            Toast.makeText(this, users[it].email, Toast.LENGTH_SHORT).show()
        }

        recyclerView.adapter = userAdapter
    }

    private fun getUsers() {
        for (i in 0..10) {
            users.add(User(i, "Person $i", "someone$i@gmail.com"))
        }
    }
}