package com.example.hosi.ncu_news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);
    }

    public void chooseLanguage(View view) {
        Intent intent = new Intent(this, LanguageChooseActivity.class);
        startActivity(intent);
    }
}
