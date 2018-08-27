package com.bazak.alarmistiming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity {

    Timer timer = new Timer();

    public void onBackPressed(){
        //뒤로가기 눌렀을 때 아무것도 안함
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        timer.schedule(task, 2000);
    }

    TimerTask task = new TimerTask(){
        @Override
        public void run() {
            Intent intent = new Intent(IntroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
