package com.example.todoapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private val context: Context,
    private val itemClickListener: RecyclerViewHolder.ItemClickListener,
    private val itemList: ArrayList<Item>
) : RecyclerView.Adapter<RecyclerViewHolder>() {

    private fun print(str: String) {
        Log.d("print_debug", str)
    }

    // リストにデータを追加する
    fun addListItem(item: Item) {
        itemList.add(item)
        notifyItemInserted(itemList.size)
        notifyDataSetChanged() // これを忘れるとRecyclerViewにItemが反映されない
    }

    // リストのデータを削除する
    private fun removeItem(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
        notifyDataSetChanged() // これを忘れるとRecyclerViewにItemが反映されない
    }

    private var mRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        // itemList.mNameをリスト上のテキストボックスにセット
        holder.itemTextView.text = itemList[position].mName
        // itemList.itemImageButtonにリムーブメソッドをセット
        holder.itemImageButton.setOnClickListener {
            print("remove!$position")
            removeItem(position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.list_item, parent, false)

        mView.setOnClickListener { view ->
            mRecyclerView?.let {
                itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }

        return RecyclerViewHolder(mView)
    }

}