package com.ray.lightofandroidadvanced

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyFragmentAdapter(private val fm:FragmentManager,private val fragments:List<Fragment>,private val titles:List<String>):
    FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}