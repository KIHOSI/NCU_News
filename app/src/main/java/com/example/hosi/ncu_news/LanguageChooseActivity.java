package com.example.hosi.ncu_news;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class LanguageChooseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.language_choose);
    }
}
