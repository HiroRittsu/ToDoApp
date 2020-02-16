package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.UUID

data class Item(
    val mId: String = UUID.randomUUID().toString(),
    val mName: String
)

class MainActivity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {

    private lateinit var viewManager: RecyclerView.LayoutManager

    private fun print(str: String) {
        Log.d("print_debug", str)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        print("start")

        val adapter = RecyclerAdapter(this, this, ArrayList())

        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

        bt_add_item.setOnClickListener {
            print("click")
            val task = Item(mName = "test")
            adapter.addListItem(task)
        }

        mainRecyclerView.adapter = adapter
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "position $position was tapped", Toast.LENGTH_SHORT)
            .show()
    }
}
