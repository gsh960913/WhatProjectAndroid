package com.smcompony.what

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.AsyncTask
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.smcompony.what.MainActivity.userID

class MainActivity3 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var drawerLayout: DrawerLayout? = null
    private var navigationView: NavigationView? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null

    private var lastTimeBackPressed: Long = 0

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        drawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        navigationView = findViewById<View>(R.id.main_navigationView) as NavigationView
        navigationView!!.setNavigationItemSelectedListener(this)

        val myToolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(myToolbar)

        tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout
        tabLayout!!.addTab(tabLayout!!.newTab().setText("소개"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("웹뷰"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        viewPager = findViewById<View>(R.id.pager) as ViewPager

        val pagerAdapter = TabPagerAdapter(supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = pagerAdapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabReselected(p0: TabLayout.Tab?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


        })
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp)
        supportActionBar!!.setTitle("") // 해당 액티비티의 툴바에 있는 타이틀을 공백으로 처리

        userID = intent.getStringExtra("userID")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {

                drawerLayout!!.openDrawer(GravityCompat.START)

                return true
            }
            R.id.menu_logout -> {
                val intent =Intent(this@MainActivity3, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                finish()
                return true
            }
            else ->


                    return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {


        Log.d(this.javaClass.name, "메시지 박스 출력")

        when (menuItem.itemId) {
            R.id.systemitem -> {
                val intent = Intent(this@MainActivity3, SystemActivity::class.java)
                startActivity(intent)
            }
            R.id.networkitem -> {
                val intent = Intent(this@MainActivity3, NetworkActivity::class.java)
                startActivity(intent)
            }
            R.id.bug_report -> {
                val intent = Intent(this@MainActivity3, WebActivity::class.java)
                startActivity(intent)
            }
            R.id.setting -> {
                val intent = Intent(this@MainActivity3, SystemActivity::class.java)
                startActivity(intent)
            }
            R.id.logout -> {
                val intent = Intent(this@MainActivity3, SystemActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext, "로그아웃 버튼 활성화 됨", Toast.LENGTH_LONG).show()
            }
        }

        drawerLayout!!.closeDrawer(GravityCompat.START)
        return true
    }

    @Override
    override fun onBackPressed() {
        if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawers()
        } else {
            super.onBackPressed()
        }
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
            finish()
            return
        }
        Toast.makeText(this, "뒤로 버튼ㅇ르 한 번 더 눌러 종료 합니다", Toast.LENGTH_SHORT).show()
        lastTimeBackPressed = System.currentTimeMillis()
    }

    companion object {

    }

}
