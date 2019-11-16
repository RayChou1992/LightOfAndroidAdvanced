package com.ray.lightofandroidadvanced

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
        initTitle()
        initViewPager()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.first->Toast.makeText(this,"first",Toast.LENGTH_SHORT).show()
            R.id.second->Toast.makeText(this,"second",Toast.LENGTH_SHORT).show()
            R.id.third->Toast.makeText(this,"third",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 初始化
     */
    private fun initTitle() {
        setSupportActionBar(home_toolbar)
        home_nv.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.first->Toast.makeText(this,"first",Toast.LENGTH_SHORT).show()
                R.id.second->Toast.makeText(this,"second",Toast.LENGTH_SHORT).show()
                R.id.third->Toast.makeText(this,"third",Toast.LENGTH_SHORT).show()
            }
            return@setNavigationItemSelectedListener true
        }
    }

    /**
     * 初始化ViewPager
     */
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
            fragments.add(MyListFragment())
        }

        var adapter=MyFragmentAdapter(supportFragmentManager,fragments,titles)
        home_vp.adapter=adapter
        home_tl.setupWithViewPager(home_vp)
        home_tl.setTabsFromPagerAdapter(adapter)


    }
}
