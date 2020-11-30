package com.prueba.pruebafinloop.ui.usersList.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prueba.pruebafinloop.R
import com.prueba.pruebafinloop.domain.model.User
import com.prueba.pruebafinloop.utils.inflate
import kotlinx.android.synthetic.main.row_user.view.*

class CustomAdapterUsersList(
    private val listUsers: List<User>,
    private val listener: (Int) -> Unit) : RecyclerView.Adapter<CustomAdapterUsersList.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.row_user))

    override fun getItemCount() = listUsers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position, listUsers[position].email,
        listUsers[position].username, listener)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int, email: String, userName: String, listener: (Int) -> Unit) = with(itemView) {

            txv_email.text = email
            txv_username.text = userName

            setOnClickListener { listener(position) }
        }
    }
}