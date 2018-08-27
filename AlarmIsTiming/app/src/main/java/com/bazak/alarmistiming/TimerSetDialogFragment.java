package com.bazak.alarmistiming;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by alfo12 on 2016-02-12.
 */

public class TimerSetDialogFragment extends DialogFragment {

    static Context mContext;
    EditText editTimerMemo;
    TimePicker tp;
    String alarmMusic;

    public static TimerSetDialogFragment newInstance(Context context){
        TimerSetDialogFragment frag = new TimerSetDialogFragment();
        mContext = context;
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) { //여기서 Bundle 받음

        //타이머 다이얼로그 생성
        LayoutInflater inf = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View dialog_view = inf.inflate(R.layout.dialog_fragment_timer_set, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setTitle("타이머 알람 설정");
        builder.setView(dialog_view);

        builder.setPositiveButton("확인", clicklistener);
        builder.setNegativeButton("취소", clicklistener);

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);

        tp =  (TimePicker)dialog_view.findViewById(R.id.tp_timer);
        tp.setIs24HourView(true);
        tp.setCurrentHour(0);
        tp.setCurrentMinute(0);

        editTimerMemo = (EditText)dialog_view.findViewById(R.id.edit_timer_memo);

        return dialog;
    }

    DialogInterface.OnClickListener clicklistener = new DialogInterface.OnClickListener(){

        @Override
        public void onClick(DialogInterface dialog, int which) {

            switch (which){
                case AlertDialog.BUTTON_POSITIVE:
                    int hour = tp.getCurrentHour();
                    int minute = tp.getCurrentMinute();
                    String memo = editTimerMemo.getText().toString();
                    if(memo.equals("")){
                        memo = "메모없음";
                    }
                    if(hour==0 && minute==0){
                            Toast.makeText(getActivity(), "0시 0분 이후는 추가할 수 없습니다", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    alarmMusic = (RingtoneManager.getActualDefaultRingtoneUri(getActivity(), RingtoneManager.TYPE_ALARM)).toString();

                    M.datas.add(new TimeItem(hour, minute, memo, alarmMusic));
                    ((MainActivity)getActivity()).adapter.notifyDataSetChanged();
                    ((MainActivity)getActivity()).save();
                    dialog.dismiss();

                    break;

                case AlertDialog.BUTTON_NEGATIVE:
                    dialog.dismiss();
                    break;
            }
        }
    };
}