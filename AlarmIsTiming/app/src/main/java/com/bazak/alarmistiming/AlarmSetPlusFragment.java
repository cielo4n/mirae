package com.bazak.alarmistiming;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by alfo12 on 2016-02-05.
 */
public class AlarmSetPlusFragment extends Fragment{

    CheckBox chkWeather;
    CheckBox chkShake;
    RadioGroup rgGame;
    RadioButton rbNoGame;
    RadioButton rb1to50;
    RadioButton rbBubble;

    AlarmSetActivity asActivity;
    int gameChoice=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alarm_set_plus, null);
        asActivity = (AlarmSetActivity)getActivity();

        chkWeather = (CheckBox)view.findViewById(R.id.chk_etc_weather);
        chkShake = (CheckBox)view.findViewById(R.id.chk_etc_shake);
        rgGame = (RadioGroup)view.findViewById(R.id.rg_game);
        rbNoGame = (RadioButton)view.findViewById(R.id.rb_game_no);
        rb1to50 = (RadioButton)view.findViewById(R.id.rb_game_1to50);
        rbBubble = (RadioButton)view.findViewById(R.id.rb_game_bubble_touch);

        //초기화
        chkWeather.setChecked(asActivity.isWeather);
        chkShake.setChecked(asActivity.isShake);

        gameChoice = asActivity.gameChoice;
        switch(asActivity.gameChoice){
            case 0: rbNoGame.setChecked(true); break;
            case 1: rb1to50.setChecked(true); break;
            case 2: rbBubble.setChecked(true); break;
        }

        rgGame.setOnCheckedChangeListener(radioListener);

        return view;
    }

    RadioGroup.OnCheckedChangeListener radioListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch(checkedId) {
                case R.id.rb_game_no:
                    gameChoice = 0;
                    break;

                case R.id.rb_game_1to50:
                    gameChoice = 1;
                    break;

                case R.id.rb_game_bubble_touch:
                    gameChoice = 2;
                    break;
            }
        }

    };
}
