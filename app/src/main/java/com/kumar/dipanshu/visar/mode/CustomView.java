package com.kumar.dipanshu.visar.mode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;



/**
 * TODO: document your custom view class.
 */
@SuppressLint("AppCompatCustomView")
public class CustomView extends ImageView {
    private final int circleColor = Color.WHITE;
    private final String tag = "CustomView";
    private int width, height;
    private int x=75,y=75;
    private int indent = 10;
    private int circleradius = 30;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = 150;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = 150;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(circleColor);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x,y, circleradius, paint);
    }

    public void right() {
        x += indent;
        invalidate();
    }

    public void left() {
        x -= indent;
        invalidate();
    }

    public void down() {
        y += indent;
        invalidate();
    }

    public void up() {
        y -= indent;
        invalidate();
    }
}
