package com.example.firstmodule

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter1(private val displayList: ArrayList<DisplayList>) :
    RecyclerView.Adapter<RecyclerViewAdapter1.GenericVH>() {

    companion object {
        private val TAG = "RecyclerViewAdapter1"
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericVH {
        if (viewType == 0) {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.blank_title, parent, false)
            return TitleVH(v)
        } else if(viewType==1){
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.using_constraint_layout, parent, false)
            return ItemVH(v)

        }else
        {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.loader_layout, parent, false)
            return LoaderVH(v)
        }
    }

    override fun getItemCount(): Int {
        return displayList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (displayList[position].getType() == ItemType.TITLE)
            0
        else if(displayList[position].getType() == ItemType.LIST_ITEM)
            1
        else
            2
    }

    override fun onBindViewHolder(holder: GenericVH, position: Int) {
        val item = displayList[position]
        Log.d(TAG,"onBind")
        if (holder is TitleVH) {
            holder.bindItems(item as TitleData)
        } else if (holder is ItemVH) {
            holder.bindItems(item as Person)
            flag = false
            if (item.checked)
                flag = true
        } else if (holder is LoaderVH)
        {
            holder.bindItems(item as Loader)
        }

    }

    open class GenericVH(itemView: View) : RecyclerView.ViewHolder(itemView)

    class ItemVH(itemView: View) : GenericVH(itemView) {
        var checkbox = itemView.findViewById(R.id.checkBox) as CheckBox


        fun bindItems(user: Person) {
            val textViewName = itemView.findViewById(R.id.textview) as TextView
            //Log.d("Person","$textViewName")
            textViewName.text = user.id
            Log.d("Person","$user.id")
            checkbox.isChecked = flag

            checkbox.setOnClickListener {
                if (checkbox.isChecked)
                    user.checked = true
            }
        }
    }

    class TitleVH(itemView: View) : GenericVH(itemView) {
            fun bindItems(user: TitleData) {
            val textViewName = itemView.findViewById(R.id.numberTextview) as TextView

            textViewName.text = user.number
                Log.d("Person","$user.number")

        }

    }
    class LoaderVH(itemView: View) : GenericVH(itemView) {
        fun bindItems(user: Loader) {
            Log.d("Loader","  ")

        }

    }

}