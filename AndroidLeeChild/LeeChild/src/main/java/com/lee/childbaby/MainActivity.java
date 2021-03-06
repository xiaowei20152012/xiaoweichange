package com.lee.childbaby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lee.childbaby.dbhelper.DbService;
import com.lee.entitys.Users;

public class MainActivity extends AppCompatActivity {

    private DbService db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DbService.getInstance(this);

        Users user = new Users();
        user.setId(1L);
        user.setUAge("15");
        user.setUChannel("16");
        user.setUName("nihao");
        user.setUPic("hell.png");
        user.setUSex("man");
        db.saveNote(user);

        findViewById(R.id.hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FadingWebActivity.class));
            }
        });


    }
}
