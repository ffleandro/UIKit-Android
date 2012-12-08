package com.android.uikit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class UIListCell<T> extends LinearLayout {
    public UIListCell(Context context) {
        super(context);
    }

    public UIListCell(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UIListCell(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs); //TODO: No defStyle in LinearLayour?
    }

    /*
     * Override this method to cache and initialize the view containers
     */
    @Override
    protected abstract void onFinishInflate();

    /*
     * Override this method to populate the list item
     */
    public abstract void init(T t);
}
