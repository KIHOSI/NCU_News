package com.example.hosi.ncu_news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HOSI on 2018/3/25.
 */

public class InnercontentActivity  extends AppCompatActivity { /*要extends AppCompatActivity，比較好*/
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_innercontent);
        /*setContentView(R.layout.activity_innercontent); //開啟activity_innercontent畫面
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);*/
    }
}
