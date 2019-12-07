package com.ray.lightofandroidadvanced

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
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
        menuInflater.inflate(R.menu.toolbar, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.first -> Toast.makeText(this, "first", Toast.LENGTH_SHORT).show()
            R.id.second -> Toast.makeText(this, "second", Toast.LENGTH_SHORT).show()
            R.id.third -> Toast.makeText(this, "third", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * 初始化
     */
    private fun initTitle() {
        setSupportActionBar(home_toolbar)
        home_nv.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.first -> Toast.makeText(this, "first", Toast.LENGTH_SHORT).show()
                R.id.second -> Toast.makeText(this, "second", Toast.LENGTH_SHORT).show()
                R.id.third -> startActivity(Intent(this, MessageActivity::class.java))
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

        repeat(titles.size) {
            fragments.add(MyListFragment(it))
        }

        val adapter = MyFragmentAdapter(
            supportFragmentManager,
            fragments,
            titles,
            FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT
        )
        home_vp.adapter = adapter
        home_vp.offscreenPageLimit = 1

        home_tl.setupWithViewPager(home_vp)




        home_tl.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "${p0!!.position}####", Toast.LENGTH_SHORT).show()
            }

        })
        home_vp.currentItem = 3
//        home_tl.getTabAt(3)!!.select()
    }
}
