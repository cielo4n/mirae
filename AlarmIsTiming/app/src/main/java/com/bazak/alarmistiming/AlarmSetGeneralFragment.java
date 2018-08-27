package com.bazak.alarmistiming;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class AlarmSetGeneralFragment extends Fragment {


    TimePicker tpAlarm;
    int idWeek[] = {R.id.tb_week_mon, R.id.tb_week_tues, R.id.tb_week_wednes, R.id.tb_week_thurs, R.id.tb_week_fri, R.id.tb_week_satur, R.id.tb_week_sun};
    ToggleButton[] tbWeek = new ToggleButton[7];
    CheckBox chkRepeatWeek;
    CheckBox chkSound;
    CheckBox chkVibration;
    SeekBar sbVolume;
    EditText editMemo;
    TextView btnChoiceAlarm;
    TextView btnReRing;

    final int REQ_CODE_RINGTONE = 10;
    AudioManager adoManager;
    AlarmSetActivity asActivity;
    Uri alarmMusicUri;

    int reMinute;
    int reRound;

    int preVolume;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        asActivity = (AlarmSetActivity)getActivity();

        View view = inflater.inflate(R.layout.fragment_alarm_set_general, null);

        //레이아웃에 있는거 가져옴
        tpAlarm = (TimePicker)view.findViewById(R.id.tp_alarm);

        for(int i=0; i<tbWeek.length; i++){
            tbWeek[i] = (ToggleButton)view.findViewById(idWeek[i]);
        }

        chkRepeatWeek = (CheckBox)view.findViewById(R.id.chk_repeat_week);
        chkSound = (CheckBox)view.findViewById(R.id.chk_sound);
        chkVibration = (CheckBox)view.findViewById(R.id.chk_vibration);
        sbVolume = (SeekBar)view.findViewById(R.id.seek_volume);
        editMemo = (EditText)view.findViewById(R.id.edit_alarm_memo);
        btnChoiceAlarm = (TextView)view.findViewById(R.id.btn_choice_alarm);
        btnReRing = (TextView)view.findViewById(R.id.btn_rering);

        //타임피커 초기화
        Calendar cal = Calendar.getInstance();
        if(asActivity.alarmMilli != -1){
            cal.setTimeInMillis(asActivity.alarmMilli);
        }
        tpAlarm.setCurrentHour(cal.get(Calendar.HOUR_OF_DAY));
        tpAlarm.setCurrentMinute(cal.get(Calendar.MINUTE));

        //요일 초기화
        for(int i=0; i<asActivity.week.length; i++){
            tbWeek[i].setChecked(asActivity.week[i]);
            tbWeek[i].setOnCheckedChangeListener(checkListner);
        }

        //주 반복 초기화
        chkRepeatWeek.setChecked(asActivity.weekRepeat);

        //알람음악 초기화
        try{
            alarmMusicUri = Uri.parse(asActivity.alarmMusic);
            btnChoiceAlarm.setText(RingtoneManager.getRingtone(asActivity, alarmMusicUri).getTitle(asActivity));

        }catch(NullPointerException ne){
            //사운드 설정이 안되었을 때 기본음악으로 설정
            alarmMusicUri = RingtoneManager.getActualDefaultRingtoneUri(asActivity, RingtoneManager.TYPE_ALARM);
            btnChoiceAlarm.setText(RingtoneManager.getRingtone(asActivity, alarmMusicUri).getTitle(asActivity));
            asActivity.alarmMusic = alarmMusicUri.toString();
        }

        //진동 초기화
        chkVibration.setChecked(asActivity.vibration);

        //알람 볼륨 초기화
        adoManager = (AudioManager)(asActivity.getSystemService(Context.AUDIO_SERVICE));
        preVolume = adoManager.getStreamVolume(AudioManager.STREAM_ALARM);
        sbVolume.setMax(adoManager.getStreamMaxVolume(AudioManager.STREAM_ALARM)); //시크바 최대크기 설정
        sbVolume.setKeyProgressIncrement(1); //증가폭

        if(asActivity.volume == -1) {
            sbVolume.setProgress(adoManager.getStreamVolume(AudioManager.STREAM_ALARM)); //값 설정
            asActivity.volume = sbVolume.getProgress();
        } else {
            sbVolume.setProgress(asActivity.volume);
        }

        //다시울림 초기화
        reMinute = asActivity.reMinute;
        reRound = asActivity.reRound;
        if(reMinute==0 && reRound==0){
            btnReRing.setText("다시울림없음");
        }else {
            btnReRing.setText(reMinute+"분 간격  "+reRound+"회 울림");
        }

        //메모 초기화
        editMemo.setText(asActivity.memo);

        //onOff 초기화
        asActivity.isOn = true;

        //리스너 연결
        btnChoiceAlarm.setOnClickListener(generalListener);
        btnReRing.setOnClickListener(generalListener);
        sbVolume.setOnSeekBarChangeListener(seekListener);
        chkSound.setOnCheckedChangeListener(checkListner);

        return view;
    }

    @Override
    public void onDestroy() {
        adoManager.setStreamVolume(AudioManager.STREAM_ALARM, preVolume, AudioManager.FLAG_ALLOW_RINGER_MODES);
        preVolume = adoManager.getStreamVolume(AudioManager.STREAM_ALARM); //시스템에 있던 값 복원
        super.onDestroy();

    }

    CompoundButton.OnCheckedChangeListener checkListner = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch(buttonView.getId()){
                case R.id.chk_sound:
                    if(isChecked == false){
                        sbVolume.setProgress(0);
                    }

                    break;
            }
        }
    };


    SeekBar.OnSeekBarChangeListener seekListener = new SeekBar.OnSeekBarChangeListener(){
        int progressChanged = 1;

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            progressChanged = progress;
            adoManager.setStreamVolume(AudioManager.STREAM_ALARM, progress, AudioManager.FLAG_PLAY_SOUND);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) { }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if(progressChanged == 0){
                chkSound.setChecked(false);
            }else {
                chkSound.setChecked(true);
            }
        }
    };



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        //벨소리 받아오는 부분
        if(requestCode == REQ_CODE_RINGTONE){
            if(resultCode == Activity.RESULT_OK){
                //선택한 알람음을 받아온다
                alarmMusicUri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);

                if(alarmMusicUri == null){
                    alarmMusicUri = RingtoneManager.getActualDefaultRingtoneUri(asActivity, RingtoneManager.TYPE_ALARM);
                }

                //알람음 이름 얻음
                btnChoiceAlarm.setText(RingtoneManager.getRingtone(asActivity, alarmMusicUri).getTitle(asActivity));
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    View.OnClickListener generalListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                //(버튼) 알람음 선택
                case R.id.btn_choice_alarm:
                    Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
                    intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "알람음을 선택하세요"); //제목
                    intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, false); //무음을 선택리스트에서 제외
                    intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_RINGTONE|RingtoneManager.TYPE_ALARM);
                    startActivityForResult(intent, REQ_CODE_RINGTONE);

                    break;


                //(버튼) 다시울림 선택
                case R.id.btn_rering:
                    LayoutInflater inflater = asActivity.getLayoutInflater();
                    final View viewReRing = inflater.inflate(R.layout.dialog_rering, null);
                    AlertDialog.Builder builder = new AlertDialog.Builder(asActivity);

                    builder.setTitle("다시울림 선택");
                    builder.setView(viewReRing);

                    //이전에 눌린 다시울림선택 위치 기억
                    switch (reMinute){
                        case 0:
                        case 5:
                            ((RadioButton)viewReRing.findViewById(R.id.rb_re_minute_5)).setChecked(true);
                            break;
                        case 10:
                            ((RadioButton)viewReRing.findViewById(R.id.rb_re_minute_10)).setChecked(true);
                            break;
                        case 15:
                            ((RadioButton)viewReRing.findViewById(R.id.rb_re_minute_15)).setChecked(true);
                            break;
                    }
                    switch (reRound){
                        case 0:
                        case 1:
                            ((RadioButton)viewReRing.findViewById(R.id.rb_re_round_1)).setChecked(true);
                            break;
                        case 2:
                            ((RadioButton)viewReRing.findViewById(R.id.rb_re_round_2)).setChecked(true);
                            break;
                        case 3:
                            ((RadioButton)viewReRing.findViewById(R.id.rb_re_round_3)).setChecked(true);
                            break;
                        case 5:
                            ((RadioButton)viewReRing.findViewById(R.id.rb_re_round_5)).setChecked(true);
                            break;
                    }

                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            RadioGroup rgReMinute = (RadioGroup) viewReRing.findViewById(R.id.rg_re_minute);
                            RadioGroup rgReRound = (RadioGroup) viewReRing.findViewById(R.id.rg_re_ring);

                            switch (rgReMinute.getCheckedRadioButtonId()) {
                                case R.id.rb_re_minute_5:
                                    reMinute = 5;
                                    break;

                                case R.id.rb_re_minute_10:
                                    reMinute = 10;
                                    break;

                                case R.id.rb_re_minute_15:
                                    reMinute = 15;
                                    break;
                            }

                            switch (rgReRound.getCheckedRadioButtonId()) {
                                case R.id.rb_re_round_1:
                                    reRound = 1;
                                    break;

                                case R.id.rb_re_round_2:
                                    reRound = 2;
                                    break;

                                case R.id.rb_re_round_3:
                                    reRound = 3;
                                    break;

                                case R.id.rb_re_round_5:
                                    reRound = 5;
                                    break;
                            }

                            btnReRing.setText(reMinute+"분 간격  "+reRound+"회 울림");

                            dialog.dismiss();
                        }
                    });

                    builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    builder.setNeutralButton("다시울림없음", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            reMinute = 0;
                            reRound = 0;

                            btnReRing.setText("다시울림 없음");

                            dialog.dismiss();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                    break;
            }
        }
    };
}
