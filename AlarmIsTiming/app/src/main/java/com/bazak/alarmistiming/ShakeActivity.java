package com.bazak.alarmistiming;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ShakeActivity extends AppCompatActivity implements SensorEventListener{
    //1. SensorEventListener 상속받음

    private long lastTime;
    private float speed;
    private float lastX;
    private float lastY;
    private float lastZ;
    private float x, y, z;

    private static final int SHAKE_THRESHOLD = 800;
    private static final int DATA_X = SensorManager.DATA_X;
    private static final int DATA_Y = SensorManager.DATA_Y;
    private static final int DATA_Z = SensorManager.DATA_Z;

    private SensorManager sensorManager;
    private Sensor accelerormeterSensor;

    int shakeNum;
    TextView txtShakeNum;
    ProgressBar progressBar;
    ProgressThread progressThread;
    Button btnShakeComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        txtShakeNum = (TextView)findViewById(R.id.txt_shake_num);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        btnShakeComplete = (Button)findViewById(R.id.btn_shake_complete);

        //시스템 서비스에서 센서매니저가져오고, 센서매니저로 센서 가져옴
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerormeterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        progressThread = new ProgressThread();
        progressThread.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(accelerormeterSensor != null){
            sensorManager.registerListener(this, accelerormeterSensor, SensorManager.SENSOR_DELAY_GAME);
            //2. SensorManager를 이용해서 센서를 사용할 수 있도록 등록시킴
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        progressThread.stopThread();
        progressThread = null;
        if(sensorManager!=null){
            sensorManager.unregisterListener(this);
        }
    }

    @Override //정확도 변함
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override //센서 정보 변함. 흔드는 거 감지
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){ //센서 종류는 가속도센서

            long currentTime = System.currentTimeMillis();
            long gabOfTime = (currentTime - lastTime);

            if(gabOfTime>100){ //0.1초 이상 시간 지남
                lastTime = currentTime;

                //현재 값 가져옴
                x = event.values[SensorManager.DATA_X];
                y = event.values[SensorManager.DATA_Y];
                z = event.values[SensorManager.DATA_Z];
                speed = Math.abs(x+y+z -lastX-lastY-lastZ) / gabOfTime*10000; //속도 측정

                //속도가 얼마 이상일 때 흔듦을 감지하겠다고 설정하는 부분
                if(speed > SHAKE_THRESHOLD){
                    //이벤트 발생!!

                    shakeNum++;
                    if(shakeNum >= 100){
                        shakeNum = 100;
                        btnShakeComplete.setVisibility(View.VISIBLE);
                    }
                    txtShakeNum.setText(shakeNum+"/100");

                }

                lastX = event.values[DATA_X];
                lastY = event.values[DATA_Y];
                lastZ = event.values[DATA_Z];
            }
        }
    } //end onSensorChanged


    @Override
    protected void onPause() {
        progressThread.pauseThread(true);
        super.onPause();
    }

    class ProgressThread extends Thread{
        boolean isRun = true;
        boolean isWait = false;

        @Override
        public void run() {
            while(isRun){
                progressBar.setProgress(shakeNum);

                if(shakeNum == 100) stopThread();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (this){
                    if(isWait) {
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
            case R.id.btn_shake_complete:

                Bundle bundle = getIntent().getBundleExtra("BUNDLE");
                TimeItem ti = (TimeItem)bundle.getSerializable("TIME_ITEM");
                Intent intent1 = null;

                if(ti.getGameChoice()!=0){

                    if(ti.getGameChoice() == 1){
                        //1 to50 게임
                        intent1 = new Intent(this, Game1to50Activity.class);
                    }else if(ti.getGameChoice() == 2){
                        //버블 터뜨리기
                        intent1 = new Intent(this, GameBubbleActivity.class);
                    }

                } else {
                    //기본 알람울림 화면
                    intent1 = new Intent(this, RingActivity.class);
                }

                intent1.putExtra("BUNDLE", bundle);
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
