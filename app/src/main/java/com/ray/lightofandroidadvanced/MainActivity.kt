package com.ray.lightofandroidadvanced

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val titles = mutableListOf<String>()
    private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewPager()
    }

    private fun initViewPager() {
        titles.add("精选")
        titles.add("体育")
        titles.add("购物")
        titles.add("明星")
        titles.add("视频")
        titles.add("健康")
        titles.add("励志")
        titles.add("图文")
        titles.add("本地")
        titles.add("动漫")
        titles.add("搞笑")

        titles.forEach {
            //            val tab = home_tl.newTab()
//            tab.text = it
//            home_tl.addTab(tab)
            home_tl.addTab(home_tl.newTab().setText(it))
            fragments.add(ListFragment())
        }




    }
}
