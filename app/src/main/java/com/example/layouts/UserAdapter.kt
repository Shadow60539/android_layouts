package com.example.layouts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.PrecomputedTextCompat
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Future

class UserAdapter(private val users: List<User>, private val listener: (index: Int) -> Unit)
    : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvId: AppCompatTextView = itemView.findViewById(R.id.tvId)
        val tvName: AppCompatTextView = itemView.findViewById(R.id.tvName)
        val tvEmail: AppCompatTextView = itemView.findViewById(R.id.tvEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.spinner_item,
            parent,
            false,
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, index: Int) {
        val user = users[index]
        holder.tvId.setTextFuture(getTextFuture(user.id.toString(), holder))
        holder.tvName.setTextFuture(getTextFuture(user.name, holder))
        holder.tvEmail.setTextFuture(getTextFuture(user.email, holder))

        holder.itemView.setOnClickListener { listener(index) }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    private fun getTextFuture(text: String, holder: ViewHolder): Future<PrecomputedTextCompat>? {
        return PrecomputedTextCompat.getTextFuture(
            text,
            holder.tvId.textMetricsParamsCompat,
            null,
        )
    }
}