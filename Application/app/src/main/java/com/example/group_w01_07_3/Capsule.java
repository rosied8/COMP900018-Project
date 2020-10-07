package com.example.group_w01_07_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//请勿更改extends AppCompatActivity,不然navigation无法工作
//清implement需要的interface
public class Capsule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capsule);
        //bottom navigation bar相关
        //Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set page selected
        bottomNavigationView.setSelectedItemId(R.id.capsule);

        //Item Selected Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.discover:
                        startActivity(new Intent(getApplicationContext(), Discover.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;
                    case R.id.capsule:
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        return true;
                }
                return false;
            }
        });
    }
    //send request to database to store the dataInformation
    public void SendRequest(View view) {
        RequestSend request=new RequestSend();
        request.execute("48185039ab0b7cb57072bfcf64b0702c4eb5249b"," the beach is as hot as the microwave just turned off after heating a big, red, spicy sauce. "
        ,"Holiday","37.8136","144.9631","0");
    }
}