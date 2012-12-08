package com.android.uikit.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public abstract class UISearchBar extends RelativeLayout {
    protected EditText editText;
    protected Button btnClear;
    protected OnSearchListener searchListener;

    public static interface OnSearchListener {
        public void onSearch(String query);
    }

    public UISearchBar(Context context) {
        super(context);
    }

    public UISearchBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UISearchBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /*
     * Override this method to cache and initialize the editText and btnClear view containers
     * WARNING: Only btnClear is optional
     * WARNING: Don't forget to call super.onFinishInflate() only on the end of your onFinishInflate implementation
     */
    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        if(editText == null) throw new NullPointerException("Did you forget to set editText or are you calling super.onFinishInflate() on the beginning of your onFinishInflate() implementation?");

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (searchListener != null) searchListener.onSearch(s.toString());
            }
        });

        if(btnClear != null){
            editText.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean hasFocus) {
                    if (hasFocus) {
                        btnClear.setVisibility(View.VISIBLE);
                    } else {
                        btnClear.setVisibility(View.GONE);
                    }
                }
            });

            btnClear.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    editText.setText(new String(""));
                }
            });
        }
    }

    public void setOnSearchListener(OnSearchListener listener){
        this.searchListener = listener;
    }

    public EditText getEditText(){
        return editText;
    }

    public void setSearchQuery(String query){
        editText.setText(query);
    }

    public String getSearchQuery(){
        return editText.getText().toString();
    }
}
