package com.android.uikit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class UICheckbox extends Button {
    public static interface OnCheckListener {
        public void onCheck(boolean isSelected);
    }

    private OnCheckListener listener;

    public UICheckbox(Context context) {
        super(context);
    }

    public UICheckbox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UICheckbox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onCheck(!isSelected());
                setSelected(!isSelected());
            }
        });
    }

    public void setOnCheckListener(OnCheckListener listener){
        this.listener = listener;
    }
}
