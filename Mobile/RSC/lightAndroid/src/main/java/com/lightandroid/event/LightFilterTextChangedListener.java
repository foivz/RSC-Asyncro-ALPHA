package com.lightandroid.event;

import android.text.Editable;
import android.text.TextWatcher;

import com.lightandroid.ui.presenter.LightFilterableAdapter;

/**
 * Created by David on 8.10.2014..
 */
public class LightFilterTextChangedListener implements TextWatcher {

    private LightFilterableAdapter adapter;

    public LightFilterTextChangedListener(LightFilterableAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        adapter.getFilter().filter(charSequence);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
