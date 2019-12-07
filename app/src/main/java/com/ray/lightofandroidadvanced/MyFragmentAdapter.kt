package com.ray.lightofandroidadvanced

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * @date  2019/12/7
 * @author  ray
 * @desc Fragment适配器
 */
class MyFragmentAdapter(
    fm: FragmentManager,
    private val fragments: List<Fragment>,
    private val titles: List<String>,
    behavior: Int
) :
    FragmentStatePagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    /**
     * @date 2019/12/7
     * @author ray
     * @desc 在为TabLayout设置联动效果（setupWithViewPager）后，必须重写该方法，否则Title的text为空白
     */
    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}