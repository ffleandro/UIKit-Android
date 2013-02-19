package com.android.uikit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class UINavigationBar extends RelativeLayout {
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

    public void showLeftView(){
        if(leftView != null)
            leftView.setVisibility(View.VISIBLE);
    }

    public void showCenterView(){
        if(centerView != null)
            centerView.setVisibility(View.VISIBLE);
    }

    public void showRightView(){
        if(rightView != null)
            rightView.setVisibility(View.VISIBLE);
    }

    public void hideLeftView(){
        if(leftView != null)
            leftView.setVisibility(View.GONE);
    }

    public void hideCenterView(){
        if(centerView != null)
            centerView.setVisibility(View.GONE);
    }

    public void hideRightView(){
        if(rightView != null)
            rightView.setVisibility(View.GONE);
    }

    public void setLeftView(View view){
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 1);
        params.addRule(RelativeLayout.CENTER_VERTICAL, 1);
        view.setLayoutParams(params);

        if(leftView != null) removeView(leftView);
        addView(view);
        leftView = view;
    }

    public void setCenterView(View view){
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
        params.addRule(RelativeLayout.CENTER_VERTICAL, 1);
        view.setLayoutParams(params);

        if(centerView != null) removeView(centerView);
        addView(view);
        centerView = view;
    }

    public void setRightView(View view){
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 1);
        params.addRule(RelativeLayout.CENTER_VERTICAL, 1);
        view.setLayoutParams(params);

        if(rightView != null) removeView(rightView);
        addView(view);
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
