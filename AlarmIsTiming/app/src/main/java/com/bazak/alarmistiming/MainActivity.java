package com.bazak.alarmistiming;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    //리스트 보여주기 위한 변수
    ListView list;
    TimeItemAdapter adapter;

    //현재시간 변수
    TextView mTime, mAmpm;
    CurrentTimeThread ctt = null;

    TextView txtMainRest;
    final int REQ_CODE_MAIN = 100;

    Intent intentAsa;
    long temp;

    AlarmManager alarmManager;
    Intent intentAlarm;
    String pendingReq;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(EEE) HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd HH:mm 다음 알람 설정됨");
    long shortTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //알람매니저 가져옴
        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        intentAlarm = new Intent(this, AlarmService.class);

        //데이터 로드 중....
        load();

        //현재시간
        mTime = (TextView)findViewById(R.id.main_time);
        mAmpm = (TextView)findViewById(R.id.main_ampm);

        //시간 리스트
        list = (ListView)findViewById(R.id.listview);

        adapter = new TimeItemAdapter(getLayoutInflater(), M.datas);

        list.setAdapter(adapter);

        ctt = new CurrentTimeThread();
        ctt.start();

        //알람 리스트 눌렀을때 이벤트
        list.setOnItemClickListener(listClickListener);
        list.setOnItemLongClickListener(listLongListener);

        txtMainRest = (TextView)findViewById(R.id.txt_main_rest);

        intentAsa = new Intent(this, AlarmSetActivity.class);
    }

    //어댑터 클릭 했을 경우
    AdapterView.OnItemClickListener listClickListener = new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            if (M.datas.get(position).isGenAlarm()) { //일반알람일경우
                intentAsa.putExtra("Pos", position);
                startActivityForResult(intentAsa, REQ_CODE_MAIN);
            }
            else { //타이머알람일경우
                alarmDeleteDialog(position);
            }
        }
    };

    //어댑터 롱클릭 했을 경우
    AdapterView.OnItemLongClickListener listLongListener = new AdapterView.OnItemLongClickListener(){

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            alarmDeleteDialog(position);
            return true;
    } //onTimeLongClick method
    };

    public void alarmDeleteDialog(int position){
        final int pos = position;

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("알람 삭제");
        builder.setMessage("선택한 알람을 삭제합니까?");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteRepeatRoundTime(pos); //다시울림 PendingIntent 삭제
                deleteAllAlarm();           //알람울림 PendingIntent 삭제
                M.datas.remove(pos);
                Log.i("MyTag", "시간제거 : " + pos + "번째 TimeItem 삭제");
                adapter.notifyDataSetChanged();
                setAlarm();
                save(); //데이터 저장

                dialog.dismiss();
            }
        });
        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }


    @Override
    protected void onDestroy() {
        ctt.stopThread();
        deleteAllAlarm();
        setAlarm();
        save();
        super.onDestroy();
    }

    public void mOnClick(View v){
        switch (v.getId()){

            //(버튼) 타이머 알람 추가 버튼
            case R.id.btn_timer_add:
                TimerSetDialogFragment tsdfrag = TimerSetDialogFragment.newInstance(this);
                tsdfrag.show(getFragmentManager(), "dialog_timerset");
                break;

            //(버튼) 일반 알람 추가
            case R.id.btn_alarm_add:
                intentAsa.putExtra("Pos", -1);
                startActivityForResult(intentAsa, REQ_CODE_MAIN);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case REQ_CODE_MAIN:
                if(resultCode == Activity.RESULT_OK){
                    adapter.notifyDataSetChanged();
                }
                deleteAllAlarm();
                setAlarm();
                save();
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

            while (isRun){

                if(adapter.getChange() == true) {
                    deleteAllAlarm();
                    setAlarm();
                    for(int i=0; i<M.datas.size(); i++) {
                        if (M.datas.get(i).isOn() == false) {
                            deleteRepeatRoundTime(i);
                        }
                    }
                    save();
                    adapter.setChange(false);
                }


                //현재시간표시에 쓰는 변수
                cal.setTimeInMillis(System.currentTimeMillis());
                strAmPm = (cal.get(Calendar.AM_PM) == Calendar.AM)? "오전":"오후";
                hour = cal.get(Calendar.HOUR);
                minute = cal.get(Calendar.MINUTE);

                for(int i=0; i<M.datas.size(); i++){
                    //타이머 알람 중 지난 시간에 울렸던 거는 삭제함
                    if(M.datas.get(i).isGenAlarm() == false){
                        for(int j=0; j<7; j++){
                            if((M.datas.get(i).getWeek()[j]==true) && (M.datas.get(i).getAlarmTimeArr()[j]<System.currentTimeMillis())){
                                  M.datas.remove(i);
                                  Log.i("MyTag", "시간제거 : "+i+"번째 TimeItem 삭제 - 지난알람");
                                  break;
                            }
                        }
                    }
                    //일반 알람 중 반복체크 안되고 지난 시간에 울렸던 거는 요일을 삭제함
                    else {
                        if(M.datas.get(i).isWeekRepeat() == false){
                            for(int j=0; j<7; j++){
                                if((M.datas.get(i).getWeek()[j]==true) && (M.datas.get(i).getAlarmTimeArr()[j]<System.currentTimeMillis())){
                                    M.datas.get(i).getWeek()[j] = false;
                                    Log.i("MyTag", "요일제거 : "+i+"번째 "+j+"요일 제거 - 지난알람");
                                }
                            }
                        }

                    }
                }

                temp = -1;
                //가까운 시간을 계산하는 부분
                for(int i=0; i<M.datas.size(); i++){
                    for(int j=0; j<7; j++){
                        if(M.datas.get(i).getWeek()[j]==true  &&  M.datas.get(i).isOn()){
                            if(temp == -1){
                              //  Log.i("MyTag", sdf.format(new Date(M.datas.get(i).getAlarmTimeArr()[j]))+"   "+sdf.format(new Date(System.currentTimeMillis())));
                                temp = M.datas.get(i).getAlarmTimeArr()[j] - System.currentTimeMillis();
                                shortTime = M.datas.get(i).getAlarmTimeArr()[j];
                            } else {
                                if(temp > M.datas.get(i).getAlarmTimeArr()[j]-System.currentTimeMillis()){
                               //     Log.i("MyTag", sdf.format(new Date(M.datas.get(i).getAlarmTimeArr()[j]))+"   "+sdf.format(new Date(System.currentTimeMillis())));
                                    temp = M.datas.get(i).getAlarmTimeArr()[j]-System.currentTimeMillis();
                                    shortTime = M.datas.get(i).getAlarmTimeArr()[j];
                                }
                            }
                        }
                    }
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String str = String.format("%02d:%02d", hour, minute);
                        mAmpm.setText(strAmPm);
                        mTime.setText(str);

                        if (temp == -1) {
                            txtMainRest.setText("지정된 알람이 없습니다");
                            BootingReceiver.notificationMake(getApplicationContext(), "지정된 알람이 없습니다", R.drawable.ic_alarm_off_small);

                        } else {
                            BootingReceiver.notificationMake(getApplicationContext(), sdf2.format(new Date(shortTime)), R.drawable.ic_alarm_on_small);

                            GregorianCalendar gc = new GregorianCalendar();
                            gc.setTimeInMillis(temp);
                            gc.setTimeZone(TimeZone.getTimeZone("GMT"));
                            int day = gc.get(Calendar.DATE)-1;
                            if(day<0) day = 0;
                            int hour = gc.get(Calendar.HOUR_OF_DAY);
                            int min = gc.get(Calendar.MINUTE);
                            String str3 = String.format("%d일 %02d시 %02d분 남음", day, hour, min);
                            txtMainRest.setText("다음 알람까지 " + str3);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });



                try {
                    Thread.sleep(5000); //5초
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


    public void save(){
        FileOutputStream fos = null;

        try {
            fos = openFileOutput("alarmtime.txt", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(M.datas);

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
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

    @Override
    public void onBackPressed() {
        deleteAllAlarm();
        setAlarm();
        save();
        super.onBackPressed();
    }


    //PendingIntent RequestCode : 데이터인덱스. 요일반복. 요일
    // 데이터인덱스. 요일반복. 요일.          다시울림반복횟수 다시울림반복시간

    public void setAlarm(){

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

                            Log.i("MyTag", "알람등록 : PenReq "+pendingReq+" 현재시간 " + sdf.format(new Date(System.currentTimeMillis()))+" 등록 : "+sdf.format(new Date(M.datas.get(i).getAlarmTimeArr()[j])));
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
                            Log.i("MyTag", "알람등록 : PenReq "+pendingReq+" 현재시간 " + sdf.format(new Date(System.currentTimeMillis()))+" 등록 : "+sdf.format(new Date(M.datas.get(i).getAlarmTimeArr()[j])));
                        }
                    }
                }
            }
        }
    }

    public void deleteAllAlarm(){
        for(int i=0; i<M.datas.size(); i++) {
            for (int j = 0; j < 7; j++) {
                for(int k=0; k <= 1; k++) {
                    pendingReq = "" + i + k + j; //i:데이터인덱스 k:요일반복 j:요일
                    intentAlarm.putExtra("REQ_PENDING", Integer.parseInt(pendingReq));
                    PendingIntent pi = PendingIntent.getService(this, Integer.parseInt(pendingReq), intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);

                    alarmManager.cancel(pi);
                    Log.i("MyTag", "알람삭제 : PenReq "+pendingReq +" 현재시간 "+sdf.format(new Date(System.currentTimeMillis())));
                }
            }
        }
    }

    public void deleteRepeatRoundTime(int index){
        int intWeek[] = {Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY};
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        int i;

        for(i=0; i<7; i++){
            if(intWeek[i] == cal.get(Calendar.DAY_OF_WEEK)){
                break;
            }
        }

        for (int k = 0; k <= 1; k++) { //요일반복
            for (int j=i; j<=i+1; j++) { //요일
                for (int l = 0; l <= 5; l++) { //반복횟수
                    String penReqReround = "" + index + k + j + M.datas.get(index).getReRound() + M.datas.get(index).getReMinute() + l + "8";
                    PendingIntent pi = PendingIntent.getService(this, Integer.parseInt(penReqReround), intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);
                    alarmManager.cancel(pi);
                    Log.i("MyTag", "다시울림삭제 : PenReq " + penReqReround);
                }
            }
        }

        // 이거 보고 PenReqReround 썼음
        // pendingReq = "" + i + 1 + j; //i:데이터인덱스 1:요일반복 j:요일
        // String reqPending2 = ""+ reqPending + ti.getReRound() + ti.getReMinute() + i + "8";   i는 get reround
    }

}

//TODO: 남은 시간 이상한거 : 영국 시간을 한국시간으로 바꿔야 함
//TODO: 이미지 깔끔한걸로 다 바꿈
