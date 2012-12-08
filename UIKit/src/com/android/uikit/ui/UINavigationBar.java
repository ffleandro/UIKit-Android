package com.android.uikit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public abstract class UINavigationBar extends RelativeLayout {
    protected View leftView;
    protected View centerView;
    protected View rightView;

    public UINavigationBar(Context context) {
        super(context);
    }

    public UINavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UINavigationBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /* Override this method to inflate the layout and cache view pointers to left, center and right views */
    @Override
    protected abstract void onFinishInflate();

    public void showLeftView(){
        leftView.setVisibility(View.VISIBLE);
    }

    public void showCenterView(){
        centerView.setVisibility(View.VISIBLE);
    }

    public void showRightView(){
        rightView.setVisibility(View.VISIBLE);
    }

    public void hideLeftView(){
        leftView.setVisibility(View.GONE);
    }

    public void hideCenterView(){
        leftView.setVisibility(View.GONE);
    }

    public void hideRightView(){
        leftView.setVisibility(View.GONE);
    }

    public void setLeftView(View view){
        leftView = view;
    }

    public void setCenterView(View view){
        centerView = view;
    }

    public void setRightView(View view){
        rightView = view;
    }

    public View getLeftView(){
        return leftView;
    }

    public View getCenterView(){
        return centerView;
    }

    public View getRightView(){
        return rightView;
    }
}
