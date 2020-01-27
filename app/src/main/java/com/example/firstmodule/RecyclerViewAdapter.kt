package com.example.firstmodule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

var flag: Boolean = false
var flag1: Boolean = false


class RecyclerViewAdapter(private val userList: ArrayList<Person>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.using_constraint_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data_position = userList.get(position).position
        holder.bindItems(userList[data_position])
        flag = false
        if (userList[data_position].checked)
            flag = true

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var checkbox = itemView.findViewById(R.id.checkBox) as CheckBox


        fun bindItems(user: Person) {
            val textViewName = itemView.findViewById(R.id.textview) as TextView
            textViewName.text = user.id

            checkbox.isChecked = flag

            checkbox.setOnClickListener {
                if (checkbox.isChecked)
                    user.checked = true
            }
        }


    }

}