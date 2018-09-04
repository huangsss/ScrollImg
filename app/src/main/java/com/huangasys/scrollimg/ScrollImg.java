package com.huangasys.scrollimg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author huangasys
 * @date 2018/8/31
 * Created by huangasys on 2018/8/31.16:11
 * @Describe:
 */

public class ScrollImg extends ImageView {

    public ScrollImg(Context context) {
        this(context,null);
    }

    public ScrollImg(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScrollImg(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();

        if (drawable != null) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = (int) Math.ceil((float) width * (float) drawable.getIntrinsicHeight() / (float) drawable.getIntrinsicWidth());
//            int height = MeasureSpec.getSize(heightMeasureSpec);
            setMeasuredDimension(width,height);
        }else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

    }
}
