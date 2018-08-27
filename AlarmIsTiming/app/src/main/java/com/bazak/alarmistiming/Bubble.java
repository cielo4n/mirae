package com.bazak.alarmistiming;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Random;

/**
 * Created by 윤수민 on 2016-02-18.
 */
public class Bubble {
    int Width, Height;
    Bitmap img, temp;
    int x, y, rad;
    int dx, dy; //변위. 이동 속도와 방향의 변화량
    boolean isDead = false;

    public Bubble(Context c, int width, int height, int x, int y) {
        Width = width;
        Height = height;
        this.x = x;
        this.y = y;

        Random rnd = new Random();

        rad = rnd.nextInt(Width/8 - Width/16 + 1) + Width/16;

        int k;
        k = (rnd.nextBoolean()) ? 1 : -1; //양수 음수 랜덤
        dx = (rnd.nextInt(8 - 2 + 1) + 2) * k;
        k = (rnd.nextBoolean()) ? 1 : -1;
        dy = (rnd.nextInt(8 - 2 + 1) + 2) * k;

        Resources res = c.getResources();
        temp = BitmapFactory.decodeResource(res, R.drawable.bubble);
        img = Bitmap.createScaledBitmap(temp, rad * 2, rad * 2, true);
        temp.recycle();
        temp = null;
    }
    void move(){
        //이동
        x += dx;
        y += dy;

        //왼쪽벽
        if(x<=rad){
            dx = -dx; //방향전환
            x = rad;
        }
        //오른쪽벽
        if(Width-rad<=x){
            dx = -dx;
            x = Width-rad;
        }
        //위쪽벽
        if(y<=rad){
            dy = -dy;
            y = rad;
        }
        //아래쪽벽
        if(Height-rad<=y){
            dy = -dy;
            y = Height-rad;
        }

    }

}