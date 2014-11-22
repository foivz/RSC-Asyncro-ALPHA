package com.lightandroid.ui.presenter;

import android.view.View;

/**
 * Created by David on 16.11.2014..
 */
public interface LightRecyclerPresenter {

    public void initViews(View view);

    public void display(View view, int position);

}
