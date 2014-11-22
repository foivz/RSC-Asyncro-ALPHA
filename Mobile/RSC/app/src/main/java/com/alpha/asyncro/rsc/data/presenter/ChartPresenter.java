package com.alpha.asyncro.rsc.data.presenter;

import android.view.View;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.model.User;
import com.lightandroid.ui.presenter.LightAdapterItem;

/**
 * Created by dmacan on 22.11.2014..
 */
public class ChartPresenter implements LightAdapterItem {

    private User user;

    public ChartPresenter(User user) {
        this.user = user;
    }

    @Override
    public void display(View view, int position) {

    }

    @Override
    public int provideItemLayoutRes() {
        return R.layout.item_chart;
    }
}
