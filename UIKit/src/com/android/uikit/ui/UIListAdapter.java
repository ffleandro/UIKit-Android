package com.android.uikit.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class UIListAdapter<T> extends BaseAdapter {
    protected LayoutInflater layoutInflater;
    protected List<T> items;
    protected int layoutId;

    public UIListAdapter(Context context, int layoutId, List<T> items){
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public T getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UIListCell<T> view;
        if (convertView == null) {
            view = (UIListCell<T>)layoutInflater.inflate(layoutId, null);
        } else {
            view = (UIListCell<T>)convertView;
        }

        T t = getItem(position);
        view.init(t);
        return view;
    }
}