package com.huangasys.scrollimg;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * @author huangasys
 * @date 2018/8/31
 * Created by huangasys on 2018/8/31.17:15
 * @Describe:
 */

public class ScollLinearLayoutManager extends LinearLayoutManager {

    //修改可以改变数据,越大速度越慢
    private float MILLISECONDS_PER_INCH = 30f;
    private Context context;

    public ScollLinearLayoutManager(Context context) {
        super(context);
        this.context = context;
    }


  /*  @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller =
                new LinearSmoothScroller(recyclerView.getContext()) {
            //计算位置的滚动向量
                    @Override
                    public PointF computeScrollVectorForPosition(int targetPosition) {
                        return ScollLinearLayoutManager.this
                                .computeScrollVectorForPosition(targetPosition);
                    }

              *//*      @Nullable
                    @Override
                    public PointF computeScrollVectorForPosition(int targetPosition) {
                        return super.computeScrollVectorForPosition(targetPosition);
                    }*//*

                    //每像素计算速度
                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return MILLISECONDS_PER_INCH / displayMetrics.density;
                        //返回滑动一个pixel需要多少毫秒
                    }

                };
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }*/


    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {

        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()){
            @Nullable
            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {
                Log.d("print", "computeScrollVectorForPosition: ");
                return ScollLinearLayoutManager.this.computeScrollVectorForPosition(targetPosition);
            }

            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                Log.d("print", "calculateSpeedPerPixel: ");
                return MILLISECONDS_PER_INCH/displayMetrics.density;
            }
        };
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    //可以用来设置速度
     void setSpeedSlow(float x) {
        //自己在这里用density去乘，希望不同分辨率设备上滑动速度相同
        //0.3f是自己估摸的一个值，可以根据不同需求自己修改
        MILLISECONDS_PER_INCH = context.getResources().getDisplayMetrics().density * 0.3f + (x);

    }
}
