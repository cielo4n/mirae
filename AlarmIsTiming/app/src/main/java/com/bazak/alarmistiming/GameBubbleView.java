package com.bazak.alarmistiming;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 윤수민 on 2016-02-18.
 */
public class GameBubbleView extends View {

    int Width, Height;
    ArrayList<Bubble> mBubbles = new ArrayList<>();
    Context mContext;
    Bitmap temp, imgBack;
    int cnt=0;


    public GameBubbleView(Context context, AttributeSet attrs){
        super(context, attrs);
        mContext = context;

        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display dis = wm.getDefaultDisplay();
        Width = dis.getWidth();
        Height = dis.getHeight();

        temp = BitmapFactory.decodeResource(context.getResources(), R.drawable.back_bub);
        imgBack = temp.createScaledBitmap(temp, Width, Height, true);
        temp.recycle();
        temp = null;

        Random rnd = new Random();

        //버블 15개 생성
        for(int i=0; i<15; i++) {
            int x = rnd.nextInt(Width);
            int y = rnd.nextInt(Height);
            mBubbles.add(new Bubble(mContext, Width, Height, x, y));
        }

        handler.sendEmptyMessageDelayed(0, 10);

   }

    void moveBubbles(){

        //뒤에서부터 어레이리스트 확인하며 삭제
        for(int i=mBubbles.size()-1; i>=0; i--){
            Bubble t = mBubbles.get(i);
            t.move();       //버블 움직이고
            if(t.isDead){   //죽었으면 제거

                t.img.recycle();
                t.img = null;
                mBubbles.remove(i);
                cnt++;

            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //버블들 움직이기
        moveBubbles();

        //배경 그리기
        canvas.drawBitmap(imgBack, 0, 0, null);

        //Bubbles 그리기
        for(Bubble t : mBubbles){
            canvas.drawBitmap(t.img, t.x-t.rad, t.y-t.rad, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int)event.getX();
        int y = (int)event.getY();

        switch (action){
            case MotionEvent.ACTION_DOWN:

                for(Bubble t : mBubbles){
                    //터치한 곳이 버블의 안이 맞는지 확인
                    if(Math.pow(x-t.x, 2) + Math.pow(y-t.y, 2) <= Math.pow(t.rad, 2)){
                        t.isDead = true; //터치하면 풍선제거
                        return true;
                    }
                }
                break;
        }
        return true;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            invalidate();

            handler.sendEmptyMessageDelayed(0, 10); //화면 갱신

            if(cnt>=15){
                //15개 다 맞춤
                ((GameBubbleActivity)mContext).btnConfirm.setVisibility(View.VISIBLE);
            }
            ((GameBubbleActivity)mContext).bubbleCount.setText(cnt+"/15");
        }
    };
}
