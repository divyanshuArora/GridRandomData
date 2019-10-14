package com.example.gridrandomdata

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.view.menu.MenuView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class RecyclerAdapter(var context: Context,var list: ArrayList<ItemModel>): RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>()
{

    var randomNumber:String ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ItemViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.grid_item,parent,false)
        return ItemViewHolder(v)
    }


    override fun getItemCount(): Int {
        return  list.size

    }

    @RequiresApi(Build.VERSION_CODES.P)
    override  fun onBindViewHolder( holder: ItemViewHolder, position: Int) {
        holder.number.text = list[position].number
        holder.item.setOnClickListener { holder.item.setBackgroundColor(Color.LTGRAY) }

    }

    class ItemViewHolder(itemView:View): RecyclerView.ViewHolder(itemView)
    {
        var number = itemView.findViewById<TextView>(R.id.number)
        val item = itemView.findViewById<LinearLayout>(R.id.layoutItem)

    }


    fun randomNumber(number: Number)
    {
        randomNumber = number.toString()
        Toast.makeText(context,"random: $randomNumber",Toast.LENGTH_SHORT).show()
        notifyDataSetChanged()
    }




}