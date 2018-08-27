package com.bazak.alarmistiming;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 윤수민 on 2016-02-21.
 */
public class AlarmService extends Service {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(EEE) HH:mm:ss");
    int preVolume; //시스템에 저장되있던 기본볼륨

    AudioManager adoManager;
    MediaPlayer mp;
    int reqPending;
    TimeItem ti;
    Bundle bundle;
    Vibrator vibrator = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        adoManager = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
        reqPending = intent.getIntExtra("REQ_PENDING", -1);
        bundle = intent.getBundleExtra("BUNDLE");
        ti = (TimeItem)bundle.getSerializable("TIME_ITEM");

        preVolume = adoManager.getStreamVolume(AudioManager.STREAM_ALARM); //이전 볼륨크기 저장

        adoManager.setStreamVolume(AudioManager.STREAM_ALARM, ti.getVolume(), AudioManager.FLAG_ALLOW_RINGER_MODES); //볼륨 크기 설정

        mp = new MediaPlayer();
        try {
            mp.setDataSource(ti.getAlarmMusic());
            mp.setAudioStreamType(AudioManager.STREAM_ALARM);
            mp.setLooping(true);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();


        if(ti.isVibration()){
            vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

            long [] pattern = {0, 1000, 100, 800, 100, 1500, 100, 700};
            vibrator.vibrate(pattern, 0); //0:무한반복 -1은 한번만 진동하란 뜻
        }

        Log.i("BTag", "onStartCommand : PenReq " + reqPending);

        if(reqPending%10 != 8  &&  reqPending != -1) { //다시울림 알람이 아닌 경우

            Log.i("BTag", "다시울림 알람이 아닌 경우 reqPending : "+reqPending);

//            Toast.makeText(this, "알람울림", Toast.LENGTH_SHORT).show();
            String reqPstr = String.format("%03d", reqPending);
            Log.i("MyTag", "알람울림 : PenReq " + reqPstr + " 현재시간 " + sdf.format(new Date(System.currentTimeMillis())) + " 울림 : " + sdf.format(new Date(System.currentTimeMillis())));

            Intent intent1 = null;


            if (ti.isWeather()) {
                Log.i("BTag", "날씨 알린 후 꺼짐 Intent");

                //날씨 알린 후 꺼짐
                intent1 = new Intent(this, WeatherActivity.class);
            } else if (ti.isShake()) {
                Log.i("BTag", "흔들은 후 꺼짐 Intent");

                //흔들어야 꺼짐
                intent1 = new Intent(this, ShakeActivity.class);
            } else if (ti.getGameChoice() != 0) {

                if (ti.getGameChoice() == 1) {
                    //1 to50 게임
                    Log.i("BTag", "1to50 Intent");

                    intent1 = new Intent(this, Game1to50Activity.class);
                } else if (ti.getGameChoice() == 2) {
                    //버블 터뜨리기
                    Log.i("BTag", "Bubble Intent");

                    intent1 = new Intent(this, GameBubbleActivity.class);
                }
            } else {
                //기본 알람울림 화면
                intent1 = new Intent(this, RingActivity.class);
            }

            //다시울림 확인
            Intent intent2 = null;
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            if (ti.getReMinute() != 0 && ti.getReRound() != 0) {
                Log.i("BTag", "다시울림확인부분 minute, round : "+ti.getReMinute()+", "+ti.getReRound());

                for (int i = 0; i < ti.getReRound(); i++) {
                    intent2 = new Intent(this, AlarmService.class); //자기를 부름

                    String reqPending2 = ""+ reqPending + ti.getReRound() + ti.getReMinute() + i + "8";

                    Log.i("BTag", "라운드for문 reqPending2 : "+reqPending2);

                    Log.i("MyATag", reqPending2);
                    intent2.putExtra("REQ_PENDING", reqPending2);
                    intent2.putExtra("BUNDLE", bundle);
                    PendingIntent pi = PendingIntent.getService(this, Integer.parseInt(reqPending2), intent2, PendingIntent.FLAG_UPDATE_CURRENT);

                    //다시울림 알람등록
                    alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (ti.getReMinute()*(i+1)*1000*60), pi);
//                    alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (ti.getReMinute()*(i+1)*1000*60), pi);
                    Log.i("MyTag", "알람다시울림등록 : PenReq " + reqPending2 + " 현재시간 " + sdf.format(new Date(System.currentTimeMillis())) + " 등록 : " + sdf.format(System.currentTimeMillis() + (ti.getReMinute()*(i+1)*1000*60)));
                }
            }

            intent1.putExtra("BUNDLE", bundle);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);

        } //다시울림 알람인 경우 끝


        else if(reqPending%10 != 8){ //다시울림 알람일 경우 기본알람화면으로 울림
            Intent intent1 = null;
            Log.i("MyTag","다시울림알람울림 : PenReq"+reqPending + " 현재시간"+sdf.format(new Date(System.currentTimeMillis())));
            intent1 = new Intent(this, RingActivity.class);
            intent1.putExtra("BUNDLE", bundle);
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent1);
        }

        return START_STICKY;
//        return값 : Service가 중단되었을경우 어떻게 할지 flag값
//        START_STICKY;             service가 죽으면 다시 살려낸다
//        START_NOT_STICKY;         다시 살려 내지 않는다
//        START_REDELIVER_INTENT    다시 살려내면서 intent가 가진 값도 살려낸다

    }

    @Override
    public void onDestroy() {
        if(vibrator != null) {
            vibrator.cancel(); //진동 취소
        }
        if(mp!=null){
            mp.stop();
            mp.release();
            mp = null;
        }
        adoManager.setStreamVolume(AudioManager.STREAM_ALARM, preVolume, AudioManager.FLAG_ALLOW_RINGER_MODES); //이전 볼륨크기 복원
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
