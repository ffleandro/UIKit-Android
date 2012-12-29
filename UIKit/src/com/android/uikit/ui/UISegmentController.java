package com.android.uikit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class UISegmentController extends LinearLayout {
    private OnSegmentClickListener segmentClickListener;
    private int selected = -1;

    public static interface OnSegmentClickListener {
        public void onSegmentClick(int index, View view);
    }

    public UISegmentController(Context context) {
        super(context);
    }

    public UISegmentController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UISegmentController(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /*
     * Override this method to cache and initialize the view containers
     */
    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        setOrientation(LinearLayout.HORIZONTAL);
        setOnSegmentClickListener(null);

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        for(int i = 0; i < getChildCount(); i++){
            getChildAt(i).setLayoutParams(params);
        }
    }

    public void setOnSegmentClickListener(OnSegmentClickListener listener){
        this.segmentClickListener = listener;

        for(int i = 0; i < getChildCount(); i++){
            View view = getChildAt(i);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getChildIndex(v);
                    if(index != selected){
                        if(selected != -1) getChildAt(selected).setSelected(false);
                        selected = index;
                        v.setSelected(true);

                        if(segmentClickListener != null) segmentClickListener.onSegmentClick(index, v);
                    }
                }
            });
         }
    }

    public int getChildIndex(View v){
        for(int i = 0; i < getChildCount(); i++){
            if(getChildAt(i) == v) return i;
        }

        return -1;
    }

    public void select(int index){
        getChildAt(index).performClick();
    }

    public int getSelected(){
        return selected;
    }
}
