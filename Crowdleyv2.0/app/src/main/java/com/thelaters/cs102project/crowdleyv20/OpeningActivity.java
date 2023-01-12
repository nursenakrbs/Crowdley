package com.thelaters.cs102project.crowdleyv20;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
/*
  This class creates the opening page of the app
  @authors Nursena Kurubas and Melike Arslan
  @date 12.05.17
 */
public class OpeningActivity extends AppCompatActivity {

    //We create the page and close it after 3 seconds
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView( R.layout.activity_opening);

        int delayedSeconds = 1;
        new Handler().postDelayed( new Runnable() {
            public void run() {
                startActivity( new Intent( OpeningActivity.this, CheckinActivity.class));
                finish();
            }
        }, delayedSeconds * 3000);

    }

}