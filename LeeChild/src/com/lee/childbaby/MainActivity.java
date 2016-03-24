package com.lee.childbaby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lee.childbaby.activitys.LauncherActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_a).setOnClickListener(this);
        findViewById(R.id.main_b).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_a:
                startActivity(new Intent(MainActivity.this, LauncherActivity.class));
                break;
            case R.id.main_b:
                startActivity(new Intent(MainActivity.this, LauncherActivity.class));
                break;
            default:
                break;

        }
    }
}
