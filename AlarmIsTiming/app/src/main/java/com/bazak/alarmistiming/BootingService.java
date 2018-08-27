package com.bazak.alarmistiming;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by alfo12 on 2016-02-22.
 */
public class BootingService extends Service{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(EEE) HH:mm:ss");

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        load();
        setAlarm();
        shortTimeNotification();
        stopSelf();
        return START_STICKY;
    }

    public void setAlarm(){
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);;
        Intent intentAlarm = new Intent(this, AlarmService.class);
        String pendingReq;

        for(int i=0; i<M.datas.size(); i++) {
            if(M.datas.get(i).isOn()) { //On 이면 알람 설정

                if (M.datas.get(i).isWeekRepeat()) { //요일반복체크
                    for (int j = 0; j < 7; j++) {
                        pendingReq = "" + i + 1 + j; //i:데이터인덱스 1:요일반복 j:요일
                        intentAlarm.putExtra("REQ_PENDING", Integer.parseInt(pendingReq));
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("TIME_ITEM", M.datas.get(i));
                        intentAlarm.putExtra("BUNDLE", bundle);

                        PendingIntent pi = PendingIntent.getService(this, Integer.parseInt(pendingReq), intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);

                        //현재시간 이후의 시간에 알람 등록 (일주일간 반복)
                        if (M.datas.get(i).getWeek()[j] == true && M.datas.get(i).getAlarmTimeArr()[j] > System.currentTimeMillis()) {
                            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, M.datas.get(i).getAlarmTimeArr()[j], 1000 * 60 * 60 * 24 * 7, pi);

//                            Toast.makeText(this, "알람등록 : PenReq" + pendingReq+" 등록 : " + sdf.format(new Date(M.datas.get(i).getAlarmTimeArr()[j])), Toast.LENGTH_SHORT).show();
                            Log.i("MyTag", "알람등록 : PenReq " + pendingReq + " 현재시간 " + sdf.format(new Date(System.currentTimeMillis())) + " 등록 : " + sdf.format(new Date(M.datas.get(i).getAlarmTimeArr()[j])));
                        }
                    }

                } else { //요일반복안할때
                    for (int j = 0; j < 7; j++) {
                        pendingReq = "" + i + 0 + j;
                        intentAlarm.putExtra("REQ_PENDING", Integer.parseInt(pendingReq));
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("TIME_ITEM", M.datas.get(i));
                        intentAlarm.putExtra("BUNDLE", bundle);

                        PendingIntent pi = PendingIntent.getService(this, Integer.parseInt(pendingReq), intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);

                        //현재시간 이후의 시간에 알람 등록
                        if (M.datas.get(i).getWeek()[j] == true && M.datas.get(i).getAlarmTimeArr()[j] > System.currentTimeMillis()) {
                            alarmManager.set(AlarmManager.RTC_WAKEUP, M.datas.get(i).getAlarmTimeArr()[j], pi);

//                            Toast.makeText(this, "알람등록 : PenReq" + pendingReq+" 등록 : " + sdf.format(new Date(M.datas.get(i).getAlarmTimeArr()[j])), Toast.LENGTH_SHORT).show();
                            Log.i("MyTag", "알람등록 : PenReq "+pendingReq+" 현재시간 " + sdf.format(new Date(System.currentTimeMillis()))+" 등록 : "+sdf.format(new Date(M.datas.get(i).getAlarmTimeArr()[j])));
                        }
                    }
                }
            }
        }
    }

    public void shortTimeNotification(){
        long temp = -1;
        long shortTime=-1;
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd HH:mm 다음 알람 설정됨");

        //가까운 시간을 계산하는 부분
        for(int i=0; i<M.datas.size(); i++){
            for(int j=0; j<7; j++){
                if(M.datas.get(i).getWeek()[j]==true  &&  M.datas.get(i).isOn()){
                    if(temp == -1){
                        temp = M.datas.get(i).getAlarmTimeArr()[j] - System.currentTimeMillis();
                        shortTime = M.datas.get(i).getAlarmTimeArr()[j];
                    } else {
                        if(temp > M.datas.get(i).getAlarmTimeArr()[j]-System.currentTimeMillis()){
                            temp = M.datas.get(i).getAlarmTimeArr()[j]-System.currentTimeMillis();
                            shortTime = M.datas.get(i).getAlarmTimeArr()[j];
                        }
                    }
                }
            }
        }

        if (temp == -1) {
            BootingReceiver.notificationMake(getApplicationContext(), "지정된 알람이 없습니다", R.drawable.ic_alarm_off_small);
        } else {
            BootingReceiver.notificationMake(getApplicationContext(), sdf2.format(new Date(shortTime)), R.drawable.ic_alarm_on_small);
        }
    }

    public void load(){
        FileInputStream fis = null;

        try{
            fis = openFileInput("alarmtime.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            M.datas = (ArrayList<TimeItem>)ois.readObject();

            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
