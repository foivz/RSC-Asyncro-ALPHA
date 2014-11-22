package com.lightandroid.ui.presenter;

import android.view.View;

/**
 * Created by David on 16.9.2014..
 */
public interface LightAdapterItem {

    /**
     * After inflating the View, displays data in the provided layout
     *
     * @param view     View that is inflated
     * @param position Position of the displaying item
     */
    public void display(View view, int position);

    /**
     * Provides layout resource Id for the displaying item
     *
     * @return layout resource Id
     */
    public int provideItemLayoutRes();

}
