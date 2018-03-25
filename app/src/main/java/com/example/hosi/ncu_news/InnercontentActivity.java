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
        setContentView(R.layout.content_innercontent); // 跳到content_innercontent畫面
    }
}
