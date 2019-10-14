    package com.example.gridrandomdata

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log
import androidx.appcompat.app.AlertDialog as AlertDialog1

    class MainActivity : AppCompatActivity()
{

    var recycle: RecyclerView ?= null
    open   var itemList: ArrayList<ItemModel> ?= null
    var randomItemList: ArrayList<ItemModel> ?= null
    open var spinBtn: Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycle = findViewById<RecyclerView>(R.id.recycle)
        spinBtn = findViewById<Button>(R.id.spin)
        spinBtn!!.setOnClickListener { spinNumber() }
        createArrayList()
    }




    private fun createArrayList()
    {
        itemList = ArrayList()
        for (i in 1..100)
        {
        val item = ItemModel("$i")
            itemList!!.add(item)
        }
        createGrid()
    }

    private fun createGrid(){
            val recyclerAdapter = RecyclerAdapter(applicationContext,itemList!!)
            recycle!!.layoutManager = GridLayoutManager(applicationContext, 15)
            recycle!!.adapter = recyclerAdapter

    }

    fun spinNumber()
    {

        val low = 1
        val high = itemList!!.size
        val random = Random()

        val result = random.nextInt(high-low)+low

        val recyclerAdapter:RecyclerAdapter = RecyclerAdapter(applicationContext,itemList!!)
        recyclerAdapter.randomNumber(result)

    }


    override fun onBackPressed() {
        super.onBackPressed()

        val builder = AlertDialog.Builder(this)
        val alertDialog = builder.create()
        builder.setTitle("Housy")
        builder.setMessage("Do You Want To Quit Game")

        builder.setPositiveButton("Yes"){dialog, which ->
            finish()
        }

        builder.setNeutralButton("Continue"){dialog, which ->  alertDialog.dismiss() }
        alertDialog.show()

    }






}
