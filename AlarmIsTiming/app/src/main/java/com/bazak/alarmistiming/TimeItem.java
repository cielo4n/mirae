package com.bazak.alarmistiming;

import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by alfo12 on 2016-02-04.
 */
public class TimeItem implements Serializable{

    private long alarmMilli;             //알람 시간
    private boolean week[] = new boolean[7];    //요일
    private boolean weekRepeat;        //요일 반복
    private String alarmMusic;             //알람음
    private boolean vibration;          //진동유무
    private int volume;                 //볼륨
    private int reMinute;              //다시울림 분
    private int reRound;               //다시울림 횟수
    private String memo;                //메모
    private boolean isOn;               //알람 켜진상태, 꺼진상태

    private boolean isWeather;          //날씨알림
    private boolean isShake;            //흔들기
    private int gameChoice;             //게임 선택 : 0일경우 게임선택없음

    private boolean isGenAlarm; //알람 종류 true:일반알람. false:타이머알람
    private long alarmTimeArr[] = new long[7];     //알람시간 저장해두는 변수 [요일]

    int intWeek[] = {Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY};

    Intent intent;
    PendingIntent pendingIntent;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(EEE) HH:mm:ss");

    //타이머 알람 추가
    public TimeItem(int hour, int minute, String memo, String alarmMusic){

        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.add(Calendar.HOUR_OF_DAY, hour);
        cal.add(Calendar.MINUTE, minute);

        //오늘날짜로 요일 설정
        for(int i=0; i<week.length; i++){
            if(cal.get(Calendar.DAY_OF_WEEK) == intWeek[i]){
                week[i] = true;
                alarmMilli = cal.getTimeInMillis();
                alarmTimeArr[i] = alarmMilli;
            } else {
                week[i] = false;
            }
        }


        weekRepeat = false;
        this.alarmMusic = alarmMusic;
        vibration = true;

        volume = 7;

        reMinute = 0;
        reRound = 0;
        this.memo = memo;
        isOn = true;
        isWeather = false;
        isShake = false;
        gameChoice = 0;
        isGenAlarm = false;



        for(int i=0; i<week.length; i++){
            if(week[i]){ //선택한 요일 (월~일)

                //로그찍어서 알람시간 확인하는 부분
                Log.i("MyTag", "시간생성 : " + sdf.format(new Date(alarmTimeArr[i])));

            }
        }
    }

    //일반 알람 추가
    public TimeItem(long alarmMilli, boolean week[], boolean weekRepeat,
                    String alarmMusic, boolean vibration,
                    int volume, int reMinute, int reRound, String memo,
                    boolean isOn, boolean isWeather,
                    boolean isShake, int gameChoice){
        this.alarmMilli = alarmMilli;
        this.week = week;
        this.weekRepeat = weekRepeat;
        this.alarmMusic = alarmMusic;
        this.vibration = vibration;
        this.volume = volume;
        this.reMinute = reMinute;
        this.reRound = reRound;
        this.memo = memo;
        this.isOn = isOn;
        this.isWeather = isWeather;
        this.isShake = isShake;
        this.gameChoice = gameChoice;
        isGenAlarm = true;


        Calendar calCur = Calendar.getInstance(); calCur.setTimeInMillis(System.currentTimeMillis()); //현재시간
        Calendar calTp = Calendar.getInstance(); calTp.setTimeInMillis(alarmMilli); //타임피커에서가져온시간

        int todayWeek = calCur.get(Calendar.DAY_OF_WEEK); //오늘 요일 가져옴
        int addDay;

        for(int i=0; i<week.length; i++){
            if(week[i]){ //선택한 요일 (월~일)

                if(intWeek[i] < todayWeek) {
                    addDay = 7+intWeek[i]-todayWeek;

                } else if(intWeek[i] > todayWeek) {
                    addDay = intWeek[i]-todayWeek;

                } else {
                    //현재요일인 경우 현재시간과 비교
                    if(   (calCur.get(Calendar.HOUR_OF_DAY) > calTp.get(Calendar.HOUR_OF_DAY))
                          ||((calCur.get(Calendar.HOUR_OF_DAY)==calTp.get(Calendar.HOUR_OF_DAY))
                            && calCur.get(Calendar.MINUTE) >= calTp.get(Calendar.MINUTE))   ){
                        addDay = 7; //지난시간
                    } else {
                        addDay = 0; //이후시간
                    }
                }

                alarmTimeArr[i] = alarmMilli + (1000*60*60*24*addDay);

                //로그찍어서 알람시간 확인하는 부분
                Log.i("MyTag", "시간생성 : " + sdf.format(new Date(alarmTimeArr[i])));

            }
        }
    }

    public void setTimeItem(long alarmMilli, boolean week[], boolean weekRepeat,
                    String alarmMusic, boolean vibration,
                    int volume, int reMinute, int reRound, String memo,
                    boolean isOn, boolean isWeather,
                    boolean isShake, int gameChoice){
        this.alarmMilli = alarmMilli;
        this.week = week;
        this.weekRepeat = weekRepeat;
        this.alarmMusic = alarmMusic;
        this.vibration = vibration;
        this.volume = volume;
        this.reMinute = reMinute;
        this.reRound = reRound;
        this.memo = memo;
        this.isOn = isOn;
        this.isWeather = isWeather;
        this.isShake = isShake;
        this.gameChoice = gameChoice;

        Calendar calCur = Calendar.getInstance(); calCur.setTimeInMillis(System.currentTimeMillis()); //현재시간
        Calendar calTp = Calendar.getInstance(); calTp.setTimeInMillis(alarmMilli); //타임피커에서가져온시간

        int todayWeek = calCur.get(Calendar.DAY_OF_WEEK); //오늘 요일 가져옴
        int addDay;

        for(int i=0; i<week.length; i++){
            if(week[i]){ //선택한 요일 (월~일)

                if(intWeek[i] < todayWeek) {
                    addDay = 7+intWeek[i]-todayWeek;

                } else if(intWeek[i] > todayWeek) {
                    addDay = intWeek[i]-todayWeek;

                } else {
                    //현재요일인 경우 현재시간과 비교
                    if(   (calCur.get(Calendar.HOUR_OF_DAY) > calTp.get(Calendar.HOUR_OF_DAY))
                            ||((calCur.get(Calendar.HOUR_OF_DAY)==calTp.get(Calendar.HOUR_OF_DAY))
                            && calCur.get(Calendar.MINUTE) >= calTp.get(Calendar.MINUTE))   ){
                        addDay = 7; //지난시간
                    } else {
                        addDay = 0; //이후시간
                    }
                }

                alarmTimeArr[i] = alarmMilli + (1000*60*60*24*addDay);
            }
        }
    }


    public long getAlarmMilli() {
        return alarmMilli;
    }

    public void setAlarmMilli(long alarmMilli) {
        this.alarmMilli = alarmMilli;
    }

    public boolean[] getWeek() {
        return week;
    }

    public void setWeek(boolean[] week) {
        this.week = week;
    }

    public boolean isWeekRepeat() {
        return weekRepeat;
    }

    public void setWeekRepeat(boolean weekRepeat) {
        this.weekRepeat = weekRepeat;
    }

    public String getAlarmMusic() {
        return alarmMusic;
    }

    public void setAlarmMusic(String alarmMusic) {
        this.alarmMusic = alarmMusic;
    }

    public boolean isVibration() {
        return vibration;
    }

    public void setVibration(boolean vibration) {
        this.vibration = vibration;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getReMinute() {
        return reMinute;
    }

    public void setReMinute(int reMinute) {
        this.reMinute = reMinute;
    }

    public int getReRound() {
        return reRound;
    }

    public void setReRound(int reRound) {
        this.reRound = reRound;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public boolean isWeather() {
        return isWeather;
    }

    public void setIsWeather(boolean isWeather) {
        this.isWeather = isWeather;
    }

    public boolean isShake() {
        return isShake;
    }

    public void setIsShake(boolean isShake) {
        this.isShake = isShake;
    }

    public int getGameChoice() {
        return gameChoice;
    }

    public void setGameChoice(int gameChoice) {
        this.gameChoice = gameChoice;
    }

    public boolean isGenAlarm() {
        return isGenAlarm;
    }

    public void setIsGenAlarm(boolean isGenAlarm) {
        this.isGenAlarm = isGenAlarm;
    }

    public long[] getAlarmTimeArr() {
        return alarmTimeArr;
    }

    public void setAlarmTimeArr(long[] alarmTimeArr) {
        this.alarmTimeArr = alarmTimeArr;
    }

}
