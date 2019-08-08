package com.smcompony.what

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.AsyncTask
import android.os.Bundle
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

class MainActivity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var drawerLayout: DrawerLayout? = null
    private var navigationView: NavigationView? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null

    private var lastTimeBackPressed: Long = 0

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT              //화면 특정한 방향 고정
        drawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout               // 드로어 레이아웃 id 가져오기
        navigationView = findViewById<View>(R.id.main_navigationView) as NavigationView     // 메인 네비게이션 id 가져오기
        navigationView!!.setNavigationItemSelectedListener(this)

        val myToolbar = findViewById<Toolbar>(R.id.my_toolbar)                              // Adding Toolbar to the activity
        setSupportActionBar(myToolbar)

        tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout                            // Initializing the TabLayout
        tabLayout!!.addTab(tabLayout!!.newTab().setText("소개"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("웹뷰"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        viewPager = findViewById<View>(R.id.pager) as ViewPager

        val pagerAdapter = TabPagerAdapter(supportFragmentManager, tabLayout!!.tabCount)           //Creating TabPagerAdapter adapter
        viewPager!!.adapter = pagerAdapter
        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))


        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {                                   // set TabSelectedListener

            @Override
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            @Override
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            @Override
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp)
        supportActionBar!!.setTitle("")  //해당 액티비티의 툴바에 있는 타이틀을 공백으로 처리

        userID = intent.getStringExtra("userID")
    }
    @Override
    override fun onCreateOptionsMenu(menu: Menu): Boolean {             // 메뉴 생성시 menu.main_menu 기본지정

        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item);
        when (item.itemId) {
            android.R.id.home -> {
                // User chose the "Settings" item, show the app settings UI...
                drawerLayout!!.openDrawer(GravityCompat.START)
                //                Toast.makeText(getApplicationContext(), "네비게이션 버튼 활성화됨", Toast.LENGTH_LONG).show();
                return true
            }
            R.id.menu_logout -> {
                val intent = Intent(this@MainActivity2, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                finish()
                return true
            }
            else ->
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                //                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item)
        }
    }
    @Override
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        Log.d(this.javaClass.name, "메시지 박스 출력")

        when (menuItem.itemId) {
            R.id.systemitem -> {
                val intent = Intent(this@MainActivity2, SystemActivity::class.java)
                startActivity(intent)
            }//                Toast.makeText(getApplicationContext(), "시스템해킹 네비게이션 활성화됨", Toast.LENGTH_LONG).show();
            R.id.networkitem -> {
                val intent = Intent(this@MainActivity2, NetworkActivity::class.java)
                startActivity(intent)
            }//                Toast.makeText(getApplicationContext(), "네트워크해킹 네비게이션  활성화됨", Toast.LENGTH_LONG).show();
            R.id.webitem -> {
                val intent = Intent(this@MainActivity2, WebActivity::class.java)
                startActivity(intent)
            }//                Toast.makeText(getApplicationContext(), "웹해킹 네비게이션  활성화됨", Toast.LENGTH_LONG).show();
            R.id.bug_report -> {
            }//                Toast.makeText(getApplicationContext(), "버그 리포트 버튼 활성화됨", Toast.LENGTH_LONG).show();
            R.id.setting -> {
            }//                Toast.makeText(getApplicationContext(), "설정 버튼 활성화됨", Toast.LENGTH_LONG).show();
            R.id.logout -> {
                val intent = Intent(this@MainActivity2, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext, "로그아웃 버튼 활성화됨", Toast.LENGTH_LONG).show()
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
        Toast.makeText(this, "뒤로 버튼을 한 번 더 눌러 종료 합니다", Toast.LENGTH_SHORT).show()
        lastTimeBackPressed = System.currentTimeMillis()
    }
}
