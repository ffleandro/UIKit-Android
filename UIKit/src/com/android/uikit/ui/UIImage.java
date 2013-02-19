package com.android.uikit.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.loopj.android.image.SmartImageView;

public class UIImage extends SmartImageView {
    private ScaleType scaleType;
    public enum ScaleType{
        FIT_WIDTH
    }

    public UIImage(Context context) {
        super(context);
    }

    public UIImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UIImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setScaleType(ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        Drawable d = getDrawable();

        if(d != null && scaleType == ScaleType.FIT_WIDTH){
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = Math.round((float) width * (float) d.getIntrinsicHeight() / (float) d.getIntrinsicWidth());
            setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
