package com.bazak.alarmistiming;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by alfo12 on 2016-02-04.
 */

public class TimeItemAdapter extends BaseAdapter{

    ArrayList<TimeItem> datas = null;
    LayoutInflater inf;

    String amPm;
    String time;
    StringBuffer week;
    String memo;

    Calendar cal = Calendar.getInstance();
    String strArrWeek[] = {"월", "화", "수", "목", "금", "토", "일"};

    boolean change = false;

    public TimeItemAdapter(LayoutInflater inflater, ArrayList<TimeItem> timeItemArrayList){
        this.inf = inflater;
        this.datas = timeItemArrayList;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TimeItem item = datas.get(position);
        week = new StringBuffer();

        if (convertView == null) {
            convertView = inf.inflate(R.layout.list_alarm_row, null);
        }

        cal.setTimeInMillis(item.getAlarmMilli());
        amPm = (cal.get(Calendar.AM_PM) == Calendar.AM) ? "오전" : "오후";
        time = String.format("%02d:%02d", cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));

        for (int i = 0; i < item.getWeek().length; i++) {
            if (item.getWeek()[i] == true) {
                week.append(strArrWeek[i]);
            }
        }

        memo = item.getMemo();

        if (item.isWeather()) {
            ((ImageView) convertView.findViewById(R.id.row_icon0)).setImageResource(R.drawable.icon_weather);
        } else {
            ((ImageView)convertView.findViewById(R.id.row_icon0)).setImageResource(R.drawable.icon_weather_off);
        }

        if (item.isShake()) {
            ((ImageView) convertView.findViewById(R.id.row_icon1)).setImageResource(R.drawable.icon_shake);
        } else {
            ((ImageView)convertView.findViewById(R.id.row_icon1)).setImageResource(R.drawable.icon_shake_off);
        }

        if (item.getGameChoice() != 0) {
            ((ImageView) convertView.findViewById(R.id.row_icon2)).setImageResource(R.drawable.icon_game);
        } else {
            ((ImageView)convertView.findViewById(R.id.row_icon2)).setImageResource(R.drawable.icon_game_off);
        }

        final ImageView imgview = (ImageView) convertView.findViewById(R.id.row_onoff_icon_btn);

        Switch switcher = (Switch)convertView.findViewById(R.id.row_onoff_switch);
        switcher.setChecked(M.datas.get(position).isOn());


        switcher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                change = true;
                M.datas.get(position).setIsOn(isChecked);

                if (isChecked) {
                    imgview.setImageResource(R.drawable.icon_alarm_on);
                } else {
                    imgview.setImageResource(R.drawable.icon_alarm_off);
                }
            }
        });

        if(!datas.get(position).isGenAlarm()){
            switcher.setVisibility(View.GONE);
        } else {
            switcher.setVisibility(View.VISIBLE);
        }

        if (item.isOn()) {
            imgview.setImageResource(R.drawable.icon_alarm_on);
            switcher.setChecked(true);
        } else {
            imgview.setImageResource(R.drawable.icon_alarm_off);
            switcher.setChecked(false);
        }

        ((TextView) convertView.findViewById(R.id.row_ampm)).setText(amPm);
        ((TextView) convertView.findViewById(R.id.row_time)).setText(time);
        ((TextView) convertView.findViewById(R.id.row_week)).setText(week);
        ((TextView) convertView.findViewById(R.id.row_memo)).setText(memo);

        return convertView;
    }

    public void setChange(boolean b){
        change = b;
    }
    public boolean getChange(){
        return change;
    }
}
