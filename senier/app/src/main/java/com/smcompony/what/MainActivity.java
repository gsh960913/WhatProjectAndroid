package com.smcompony.what;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.Formatter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.smcompony.what.LoginActivity;
import com.smcompony.what.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    public static String userID;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);              //화면 특정한 방향 고정

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);                  // 드로어 레이아웃 id 가져오기
        navigationView = (NavigationView) findViewById(R.id.main_navigationView);        // 메인 네비게이션 id 가져오기
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);                              // Adding Toolbar to the activity
        setSupportActionBar(myToolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);                            // Initializing the TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("소개"));
        tabLayout.addTab(tabLayout.newTab().setText("웹뷰"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);

        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());           //Creating TabPagerAdapter adapter
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){                                   // set TabSelectedListener

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Toast.makeText(getApplicationContext(),"Tab Fragment on click ",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
        getSupportActionBar().setTitle("");  //해당 액티비티의 툴바에 있는 타이틀을 공백으로 처리

        userID = getIntent().getStringExtra("userID");
        new BackgroundTask().execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {             // 메뉴 생성시 menu.main_menu 기본지정

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                // User chose the "Settings" item, show the app settings UI...
                drawerLayout.openDrawer(GravityCompat.START);
//                Toast.makeText(getApplicationContext(), "네비게이션 버튼 활성화됨", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_logout:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
//                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Log.d(this.getClass().getName(), "메시지 박스 출력");

        switch (menuItem.getItemId()) {
            case R.id.systemitem: {
                Intent intent = new Intent(MainActivity.this, SystemActivity.class);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(), "시스템해킹 네비게이션 활성화됨", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.networkitem: {
                Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(), "네트워크해킹 네비게이션  활성화됨", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.webitem: {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(), "웹해킹 네비게이션  활성화됨", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.bug_report: {
//                Toast.makeText(getApplicationContext(), "버그 리포트 버튼 활성화됨", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.setting: {
//                Toast.makeText(getApplicationContext(), "설정 버튼 활성화됨", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.logout: {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(), "로그아웃 버튼 활성화됨", Toast.LENGTH_LONG).show();
                break;
            }

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String target;          // 접속 홈페이지 주소

        protected void onPreExecute() {
            target = "#";
        }
        @Override
        protected String doInBackground(Void... voids) {

//            try{
//                URL url = new URL(target);
//                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                InputStream inputStream = httpURLConnection.getInputStream();       // 넘어노느 결과값 저장
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));     //버퍼에 값 저장
//                String temp;
//                StringBuilder stringBuilder = new StringBuilder();
//                while((temp = bufferedReader.readLine()) != null)       // 버퍼값 읽고 temp 저장
//                {
//                    stringBuilder.append(temp + "\n");
//                }
//                bufferedReader.close();
//                inputStream.close();
//                httpURLConnection.disconnect();
//                return stringBuilder.toString().trim();
//            }catch( Exception e){
//                e.printStackTrace();
//            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate();
        }


        @Override
        public void onPostExecute(String result){           // 결과 처리
//            try{
//                JSONObject jsonObject = new JSONObject(result);
//                JSONArray jsonArray = jsonObject.getJSONArray("response");
//                int count = 0;
//                String noticeContent, noticeName, noticeDate;
//                while(count < jsonArray.length())
//                {
//                    JSONObject object = jsonArray.getJSONObject(count);     // 배열 원소값 가져오기
//                    noticeContent = object.getString("noticeContent");  // 값 가져오기
//                    noticeName = object.getString("noticeName");
//                    noticeDate = object.getString("noticeDate");
////                    Notice notice = new Notice(noticeContent, noticeName, noticeDate);  // 공지사항 객체 생성
////                    noticeList.add(notice);
////                    adapter.notifyDataSetChanged();
//                    count++;
//                }
//            } catch(Exception e){
//                e.printStackTrace();
//            }
        }
    }

    private long lastTimeBackPressed;

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
        if(System.currentTimeMillis() - lastTimeBackPressed < 1500)
        {
            finish();
            return ;
        }
        Toast.makeText(this, "뒤로 버튼을 한 번 더 눌러 종료 합니다", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }
}
