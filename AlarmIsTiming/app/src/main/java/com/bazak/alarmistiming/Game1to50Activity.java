package com.bazak.alarmistiming;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game1to50Activity extends AppCompatActivity {

    ImageView btnImg[] = new ImageView[25];
    int rndNum[] = new int[50];
    int orderNum[] = new int[25];

    Random rnd = new Random();
    int cnt = 0;
    Button btnconfirm;
    TextView curNum;
    TextView curRecord;
    TextView bestRecord;
    RecodeTimeThread rtt;

    int min,sec;
    int bestMin, bestSec;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1to50);

        pref = getSharedPreferences("Game1to50_BestData", Context.MODE_PRIVATE);
        bestMin = pref.getInt("Game1to50_Min", 0);
        bestSec = pref.getInt("Game1to50_Sec", 0);

        btnconfirm = (Button)findViewById(R.id.btn_game_1to50_complete);
        curNum = (TextView)findViewById(R.id.cur_num);
        curRecord = (TextView)findViewById(R.id.cur_record);
        bestRecord = (TextView)findViewById(R.id.game_1to50_bestrecord);

        String str = String.format("%02d:%02d", bestMin, bestSec);
        bestRecord.setText(str);

        int temp1, temp2;

        //버튼 가져옴
        for(int i=0; i<25; i++){
            btnImg[i] = (ImageView)findViewById(R.id.img_btn01+i);
        }

        //숫자 섞음
        for(int i=0; i<50; i++){
            rndNum[i] = i+1; //1~50까지 넣음
        }
        for(int i=0; i<1000; i++){
            temp1 = rnd.nextInt(49)+1; //1~49까지 나옴
            temp2 = rndNum[0];
            rndNum[0] = rndNum[temp1];
            rndNum[temp1] = temp2;
        } //(카드셔플 알고리즘)

        //50개 중 앞에 25개의 숫자카드만 사용함
        for(int i=0; i<25; i++){
            btnImg[i].setImageResource(R.drawable.num_01 + (rndNum[i] - 1));
            btnImg[i].setTag(rndNum[i]); //태그 저장
        }

        //선택 정렬
        for(int i=0; i<orderNum.length-1; i++){
            for(int j=i+1; j<orderNum.length; j++){
                if(rndNum[i]>rndNum[j]){
                    temp1 = rndNum[i];
                    rndNum[i] = rndNum[j];
                    rndNum[j] = temp1;
                }
            }
        }

        //정렬된 숫자카드
        for(int i=0; i<25; i++){
            Log.i("MyTag", rndNum[i]+"");
        }

        rtt = new RecodeTimeThread();
        rtt.start();
    }

    public void gameOnClick(View v){

        if((Integer)v.getTag() == rndNum[cnt]){
            cnt++;
            v.setAlpha(0.2f);
            v.setClickable(false);
            curNum.setText(v.getTag()+"");
        }

        if(cnt == 25){
            //다 맞춘 경우
            btnconfirm.setVisibility(View.VISIBLE);
            rtt.stopThread();

            SharedPreferences.Editor editor = pref.edit();
            if(bestMin == 0 && bestSec == 0){
                editor.putInt("Game1to50_Min", min);
                editor.putInt("Game1to50_Sec", sec);
                Toast.makeText(this, "최단시간을 갱신했습니다", Toast.LENGTH_SHORT).show();
                editor.commit();//꼭 중요!!

            }
            else {
                if(bestMin*60+bestSec > min*60+sec){
                    Toast.makeText(this, "최단시간을 갱신했습니다", Toast.LENGTH_SHORT).show();
                    editor.putInt("Game1to50_Min", min);
                    editor.putInt("Game1to50_Sec", sec);
                    editor.commit();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rtt.stopThread();
        rtt = null;
    }

    class RecodeTimeThread extends Thread{
        boolean isRun=true, isWait=false;

        @Override
        public void run() {
            min=0;
            sec=0;

            while(isRun){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                sec++;

                if(sec >= 60){
                    sec = sec-60;
                    min++;
                }

                if(min > 99){
                    stopThread();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String str = String.format("%02d:%02d", min, sec);
                        curRecord.setText(str);
                    }
                });


                synchronized (this){
                    if(isWait){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

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
    }


    public void mOnClick(View v){
        switch(v.getId()){
            case R.id.btn_game_1to50_complete:
                Intent intent1 = new Intent(this, RingActivity.class);
                intent1.putExtra("BUNDLE", getIntent().getBundleExtra("BUNDLE"));
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent1);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
