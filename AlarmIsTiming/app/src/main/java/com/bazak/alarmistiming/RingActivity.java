package com.bazak.alarmistiming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RingActivity extends AppCompatActivity {

    TextView ringAmPm;
    TextView ringTime;
    TextView ringMemo;
    CurrentTimeThread ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);

        ringAmPm = (TextView)findViewById(R.id.ring_ampm);
        ringTime = (TextView)findViewById(R.id.ring_time);
        ringMemo = (TextView)findViewById(R.id.ring_memo);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BUNDLE");

        TimeItem ti = (TimeItem)bundle.getSerializable("TIME_ITEM");
        ringMemo.setText(ti.getMemo());

        ct = new CurrentTimeThread();
        ct.start();
    }

    public void mOnClick(View v){
        switch(v.getId()){
            case R.id.btn_ring_confirm:
                stopService(new Intent(this, AlarmService.class));
                Toast.makeText(this, "알람이 꺼졌습니다", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }

    class CurrentTimeThread extends Thread{

        boolean isRun = true;
        boolean isWait = false;
        Calendar cal = Calendar.getInstance();

        int hour, minute;
        String strAmPm;

        @Override
        public void run() {

            while(isRun){
                cal.setTimeInMillis(System.currentTimeMillis());

                strAmPm = (cal.get(Calendar.AM_PM) == Calendar.AM)? "오전":"오후";
                hour = cal.get(Calendar.HOUR);
                minute = cal.get(Calendar.MINUTE);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String str = String.format("%02d:%02d", hour, minute);
                        ringAmPm.setText(strAmPm);
                        ringTime.setText(str);
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (this){
                    if(isWait){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }//end while
        } //end run

        public void pauseThread(boolean wait){
            isWait = wait;
            synchronized (this){
                notify();
            }
        }

        public void stopThread(){
            isRun = false;
            synchronized (this){
                notify();
            }
        }

    } //end CurrentTimeThread

}
