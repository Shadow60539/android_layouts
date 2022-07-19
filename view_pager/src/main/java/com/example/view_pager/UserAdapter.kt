package com.example.view_pager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.PrecomputedTextCompat
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPhoto: ImageView = itemView.findViewById(R.id.ivPhoto)
        val tvUserName: AppCompatTextView = itemView.findViewById(R.id.tvUserName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_view_item,
            parent,
            false,
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val user = users[position]
        viewHolder.ivPhoto.setImageResource(user.image)
        viewHolder.tvUserName.setTextFuture(
            PrecomputedTextCompat.getTextFuture(
            user.name,
            viewHolder.tvUserName.textMetricsParamsCompat,
            null,
        ))
    }

    override fun getItemCount(): Int = users.size
}