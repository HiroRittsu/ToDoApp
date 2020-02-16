package com.example.todoapp

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // 独自に作成したListener
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val itemTextView: TextView = view.findViewById(R.id.itemTextView)
    val itemImageView: ImageView = view.findViewById(R.id.itemImageView)
    val itemImageButton: ImageButton = view.findViewById(R.id.itemImageView)

    init {
        // layoutの初期設定するときはココ
    }

}