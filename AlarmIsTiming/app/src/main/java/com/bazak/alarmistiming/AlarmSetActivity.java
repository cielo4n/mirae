package com.bazak.alarmistiming;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;

import java.util.Calendar;

/**
 * Created by alfo12 on 2016-02-05.
 */
public class AlarmSetActivity extends AppCompatActivity {

    FragmentTabHost tabHost;
    ViewPager pager;
    PageAdapter adapter;

    long alarmMilli=-1;             //알람 시간
    boolean week[] = new boolean[7];//요일
    boolean weekRepeat=false;      //요일 반복
    String alarmMusic = null;          //알람음
    boolean vibration=true;         //진동유무
    int volume=-1;                  //볼륨
    int reMinute=0;                //다시울림 분
    int reRound=0;                 //다시울림 횟수
    String memo="";                 //메모
    boolean isOn=true;              //알람 켜진상태, 꺼진상태

    boolean isWeather=false;        //날씨알림
    boolean isShake=false;          //흔들기
    int gameChoice=0;               //게임 선택 : 0일경우 게임선택없음

    int intWeek[] = {Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY};

    AlarmSetGeneralFragment generalFragment;
    AlarmSetPlusFragment plusFragment;

    Intent intent;
    int selectPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_set);

        //탭호스트 준비
        tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        //탭스펙 추가
        tabHost.addTab(tabHost.newTabSpec("alarmset_general").setIndicator("기본설정"), DummyFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("alarmset_plus").setIndicator("기타설정"), DummyFragment.class, null);

        //페이저어댑터
        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new PageAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        tabHost.setOnTabChangedListener(tabChangeListener); //탭 바뀌면 페이지 바뀜
        pager.addOnPageChangeListener(pageChangeListener); //페이지 바뀌면 탭 바뀜

        //프레그먼트 가져옴(메소드 만듦)
        generalFragment = (AlarmSetGeneralFragment)adapter.getFragment(0);
        plusFragment = (AlarmSetPlusFragment)adapter.getFragment(1);

        intent = getIntent();
        selectPos = intent.getIntExtra("Pos", -10);

        if(selectPos == -1){ //일반알람추가눌러서들어옴
        }
        else { //어댑터 눌러서 들어옴
            alarmMilli = M.datas.get(selectPos).getAlarmMilli();
            week = M.datas.get(selectPos).getWeek();
            weekRepeat = M.datas.get(selectPos).isWeekRepeat();
            alarmMusic = M.datas.get(selectPos).getAlarmMusic();
            vibration = M.datas.get(selectPos).isVibration();
            volume = M.datas.get(selectPos).getVolume();
            reMinute = M.datas.get(selectPos).getReMinute();
            reRound = M.datas.get(selectPos).getReRound();
            memo = M.datas.get(selectPos).getMemo();
            isWeather = M.datas.get(selectPos).isWeather();
            isShake = M.datas.get(selectPos).isShake();
            gameChoice = M.datas.get(selectPos).getGameChoice();
        }
    }

    TabHost.OnTabChangeListener tabChangeListener = new TabHost.OnTabChangeListener(){

        @Override
        public void onTabChanged(String tabId) {

            if(tabId.equals("alarmset_general")){
                pager.setCurrentItem(0, true);

            } else if(tabId.equals("alarmset_plus")){
                pager.setCurrentItem(1, true);

            }
        }
    };

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            tabHost.setCurrentTab(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void mOnClick(View v){
        switch(v.getId()){
            //(버튼)기본알람확인
            case R.id.btn_alarm_confirm:

                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(System.currentTimeMillis());
                cal.set(Calendar.HOUR_OF_DAY, generalFragment.tpAlarm.getCurrentHour());
                cal.set(Calendar.MINUTE, generalFragment.tpAlarm.getCurrentMinute());
                cal.set(Calendar.SECOND, 0);
                alarmMilli = cal.getTimeInMillis();

                //요일 가져옴
                for(int i=0; i<week.length; i++) {
                    week[i] = generalFragment.tbWeek[i].isChecked();
                }

                for(int i=0; i<week.length; i++){
                    if(week[i]){
                        break;
                    }
                    if(i == week.length-1){ //요일이 아무것도 선택 안된 경우
                        for(int j=0; j<week.length; j++){
                            if(cal.get(Calendar.DAY_OF_WEEK) == intWeek[j]){
                                week[j] = true; //현재 요일 넣음
                                break;
                            }
                        }
                    }
                }

                //요일 반복 가져옴
                weekRepeat = generalFragment.chkRepeatWeek.isChecked();
                //알람음악 가져옴
                alarmMusic = generalFragment.alarmMusicUri.toString();
                //진동여부 가져옴
                vibration = generalFragment.chkVibration.isChecked();
                //볼륨 가져옴
                volume = generalFragment.sbVolume.getProgress();
                //다시울림 가져옴
                reMinute = generalFragment.reMinute;
                reRound = generalFragment.reRound;
                //메모 가져옴
                memo = generalFragment.editMemo.getText().toString();
                if(memo.equals("")) memo = "메모없음"; //메모가 없을경우 "메모없음"으로 설정

                isWeather = plusFragment.chkWeather.isChecked();
                isShake = plusFragment.chkShake.isChecked();
                gameChoice = plusFragment.gameChoice;


                if(selectPos == -1){ //일반알람추가눌러서들어옴
                    M.datas.add(new TimeItem(alarmMilli, week, weekRepeat, alarmMusic, vibration, volume, reMinute, reRound, memo, isOn, isWeather, isShake, gameChoice));
                }
                else { //어댑터 눌러서 들어옴
                    M.datas.get(selectPos).setTimeItem(alarmMilli, week, weekRepeat, alarmMusic, vibration, volume, reMinute, reRound, memo, isOn, isWeather, isShake, gameChoice);
                }

                setResult(Activity.RESULT_OK, intent);
                finish();
                break;

            case R.id.btn_alarm_cancel:
                finish();
                break;
        }
    }


}
