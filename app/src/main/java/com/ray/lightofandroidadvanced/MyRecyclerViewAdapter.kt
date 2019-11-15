package com.ray.lightofandroidadvanced

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_fragment_mylist.view.*

class MyRecyclerViewAdapter(private val mContext: Context):
    RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_fragment_mylist,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.setOnClickListener {
            Toast.makeText(mContext,"点击了${position+1}项",Toast.LENGTH_SHORT).show()
        }
        holder.content.text="第${position+1}項"
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val  view:View=itemView
        val content= itemView.item_mylist_tv!!

    }
}