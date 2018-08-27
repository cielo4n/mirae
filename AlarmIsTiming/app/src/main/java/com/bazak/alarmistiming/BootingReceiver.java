package com.bazak.alarmistiming;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by 윤수민 on 2016-02-21.
 */
public class BootingReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if(action.equals(Intent.ACTION_BOOT_COMPLETED)){
            Intent in1 = new Intent(context, BootingService.class);
            in1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            context.startService(in1);

            notificationMake(context ,"알람이 설정되었습니다.", R.drawable.ic_alarm_on_small);
        }
    }

    public static void notificationMake(Context context, String contentText, int smallIcon){
        Intent in2 =  new Intent(context, MainActivity.class);
        in2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        // 상태표시줄 한줄 표시
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(smallIcon); //상단바에 뜨는 엄청작은 아이콘
        builder.setTicker("알람은 타이밍 - 알람 설정 완료");

        //확장된 상태표시줄 표시
//        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_alarm_on);
//        builder.setLargeIcon(bm);
        builder.setContentTitle("알람은타이밍");
        builder.setContentText(contentText);
        //builder.setSubText("클릭하면 알람은타이밍이 실행됩니다.");

        //당장 실행되지 않을 인텐트는 PendingIntent로 줌
        PendingIntent pending = PendingIntent.getActivity(context, 99999, in2, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pending);
        builder.setAutoCancel(false);

        //알림 객체 생성  빌더한테 빌드시킴
        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_NO_CLEAR; //or연산자. 안지워지게함

        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(99999, notification);

    }
}
