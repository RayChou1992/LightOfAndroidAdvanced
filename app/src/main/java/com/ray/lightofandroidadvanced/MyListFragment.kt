package com.ray.lightofandroidadvanced

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyListFragment :Fragment(){

    var mRecyclerView:RecyclerView?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRecyclerView=inflater.inflate(R.layout.fragment_mylist,container,false) as RecyclerView
        return mRecyclerView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRecyclerView?.let{
            mRecyclerView!!.layoutManager=LinearLayoutManager(mRecyclerView!!.context)
            mRecyclerView!!.adapter=MyRecyclerViewAdapter(mRecyclerView!!.context)
        }

    }
}