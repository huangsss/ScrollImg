package com.huangasys.customimg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.huangasys.scrollimg.R;


/**
 * Created by Ken on 2016/10/31.14:32
 */
public class BackgroundView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    private Bitmap bitmap1, bitmap2;
    private SurfaceHolder surfaceHolder;
    private boolean flag = true;

    private int by1, by2;
    private int speed = 9;//背景滚动速度

    public BackgroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_login_bg);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_login_bg);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        by1 = 0;
        by2 = bitmap1.getHeight();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        flag = true;
        new Thread(this).start();
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false;
    }

    private void draw() {
        Canvas canvas = surfaceHolder.lockCanvas();
        if(canvas != null) {
            canvas.drawColor(Color.BLACK);
            Rect rect1 = new Rect(0, 0, bitmap1.getWidth(), bitmap1.getHeight());

            Rect rect2 = new Rect(0, by1, getWidth(), by1 + bitmap1.getHeight());
            canvas.drawBitmap(bitmap1, rect1, rect2, null);

            Rect rect3 = new Rect(0, by2, getWidth(), by2 + bitmap1.getHeight());
            canvas.drawBitmap(bitmap2, rect1, rect3, null);

            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public void run() {
        while(flag){
            by1 -= speed;
            by2 -= speed;

            //超出屏幕
            if(Math.abs(by1) > bitmap1.getHeight()){
                by1 = by2 + bitmap1.getHeight();
            }

            if(Math.abs(by2) > bitmap1.getHeight()){
                by2 = by1 + bitmap1.getHeight();
            }

            draw();

           /* try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}