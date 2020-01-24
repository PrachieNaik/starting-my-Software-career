package com.example.firstmodule

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
var checkBoxStateArray = SparseBooleanArray()
class RecyclerViewAdapter(val userList: ArrayList<PersonDataClass>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.using_constraint_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.checkbox.isChecked = checkBoxStateArray.get(position,false)

        var data_position = userList.get(position).position
        holder.bindItems(userList[data_position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var checkbox = itemView.findViewById(R.id.checkBox) as CheckBox

        init{

            checkbox.setOnClickListener {

                if(!checkBoxStateArray.get(adapterPosition,false))
                {
                    checkbox.isChecked = true
                    checkBoxStateArray.put(adapterPosition,true)
                }
                else
                {
                    checkbox.isChecked = false
                    checkBoxStateArray.put(adapterPosition,false)
                }

            }
        }
        fun bindItems(user: PersonDataClass) {
            val textViewName = itemView.findViewById(R.id.textview) as TextView
            textViewName.text = user.id


        }


    }
}