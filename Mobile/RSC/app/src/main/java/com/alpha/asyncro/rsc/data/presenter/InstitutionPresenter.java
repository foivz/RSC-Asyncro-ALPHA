package com.alpha.asyncro.rsc.data.presenter;

import android.view.View;

import com.alpha.asyncro.rsc.data.model.Institution;
import com.lightandroid.ui.presenter.LightRecyclerPresenter;

import butterknife.ButterKnife;

/**
 * Created by dmacan on 23.11.2014..
 */
public class InstitutionPresenter implements LightRecyclerPresenter {

    private Institution institution;

    public InstitutionPresenter(Institution institution) {
        this.institution = institution;
    }

    @Override
    public void initViews(View view) {
        ButterKnife.inject(this, view);
    }

    @Override
    public void display(View view, int position) {

    }
}
