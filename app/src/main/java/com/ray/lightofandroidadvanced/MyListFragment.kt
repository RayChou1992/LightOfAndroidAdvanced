package com.ray.lightofandroidadvanced

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyListFragment(private val position: Int) : Fragment() {


    var isViewCreated = false
    var isUIVisible = false

    var mRecyclerView: RecyclerView? = null

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isUIVisible = true
            lazyLoad()
        } else {
            isUIVisible = false
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("tag", "第${position}页onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("tag", "第${position}onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRecyclerView = inflater.inflate(R.layout.fragment_mylist, container, false) as RecyclerView
        isViewCreated = true
        lazyLoad()
        return mRecyclerView
    }

    /**
     * @date 2019/12/7
     * @author ray
     * @desc 懒加载数据
     */
    private fun lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            loadData()
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false
            isUIVisible = false

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRecyclerView?.let {
            mRecyclerView!!.layoutManager = LinearLayoutManager(mRecyclerView!!.context)
            mRecyclerView!!.adapter = MyRecyclerViewAdapter(mRecyclerView!!.context, position)
        }

    }

    private fun loadData() {
        Log.e("tag", "第${position}加载数据")
    }

    override fun onStart() {
        super.onStart()

        Log.e("tag", "第${position}onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.e("tag", "第${position}页onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.e("tag", "第${position}页onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.e("tag", "第${position}页onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.e("tag", "第${position}页onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("tag", "第${position}页onDestroy")
    }

    override fun onDetach() {
        super.onDetach()

        Log.e("tag", "第${position}页onDetach")
    }


}