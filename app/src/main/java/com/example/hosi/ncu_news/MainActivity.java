package com.example.hosi.ncu_news;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //使用Spinner
        Spinner notify = (Spinner)findViewById(R.id.notify_spinner);
        final ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(this,R.array.officeName_array,android.R.layout.simple_spinner_item);
        nAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //設定一個比較美觀的版面配置
        notify.setAdapter(nAdapter);
        //事件處理
        notify.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) { //有點選選項
                Toast.makeText(MainActivity.this,nAdapter.getItem(position),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { //沒點選選項

            }
        });

        //使用ListView
        ListView activityListView = (ListView) findViewById(R.id.activity_list);
        activityListView.setAdapter(new ActivityAdapter(this));
        activityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { //事件處理
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { //點下去會跳到活動詳細內容(activity_activitys_content)


            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);  右下角紅色的懸浮按鈕(app_bar_main.xml)
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* 右上角出現setting功能
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);*/

        /*搜尋功能*/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        // 顯示完成鈕
        searchView.setSubmitButtonEnabled(true);

        /*測試，onQueryTTextSubmit是當你按下enter時觸發，
        onQueryTextChange是當你在SearchView上打的每一個文字都會觸發的效果，詳細可以見你的Log*/
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "搜尋結果為：" + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("當文字改變時", "改變的文字 ：" + newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //ListView怎麼顯現
    private class ActivityAdapter extends BaseAdapter{ //從BaseAdapter衍生出一個新的class，非匿名inner class
        private LayoutInflater layoutInflater;
        private List<Activity> activityList;

        public ActivityAdapter(Context context){
            layoutInflater = LayoutInflater.from(context);

            activityList = new ArrayList<>(); //增加活動列表內容，時間、類別、活動標題
            activityList.add(new Activity(1,1070310,"工作坊","工作方標題"));
            activityList.add(new Activity(2,1070315,"活動","活動標題"));
            activityList.add(new Activity(3,1070320,"演講","演講標題"));

        }

        @Override
        public int getCount() {
            return activityList.size();
        } //得知有多少count，預留多少位置

        @Override
        public Object getItem(int position) {
            return activityList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return activityList.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.listview_item, viewGroup, false); //原本layout什麼都沒有，inflate展開view， inflate就是把xml轉成view
                if (position % 2 == 1)
                    convertView.setBackgroundColor(Color.BLUE);
                if (position % 2 == 0)
                    convertView.setBackgroundColor(Color.YELLOW);
            }

            Activity activity = activityList.get(position);
            TextView idTextView = (TextView) convertView.findViewById(R.id.tvId);
            TextView timeTextView = (TextView) convertView.findViewById(R.id.tvTime);
            TextView typeTextView = (TextView) convertView.findViewById(R.id.tvType);
            TextView titleTextView = (TextView) convertView.findViewById(R.id.tvTitle);
            return convertView;
        }
    }

}
