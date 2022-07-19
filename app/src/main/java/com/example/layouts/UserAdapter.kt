package com.example.layouts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val users: List<User>, private val listener: (index: Int) -> Unit) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: TextView = itemView.findViewById<TextView>(R.id.tvId)
        val tvName: TextView = itemView.findViewById<TextView>(R.id.tvName)
        val tvEmail: TextView = itemView.findViewById<TextView>(R.id.tvEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.spinner_item,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        val user = users[index]
        holder.tvId.text = user.id.toString()
        holder.tvName.text = user.name
        holder.tvEmail.text = user.email

        holder.itemView.setOnClickListener { listener(index) }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}