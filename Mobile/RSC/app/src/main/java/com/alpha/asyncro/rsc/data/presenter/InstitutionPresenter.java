package com.alpha.asyncro.rsc.data.presenter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.model.Institution;
import com.lightandroid.ui.presenter.LightRecyclerPresenter;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dmacan on 23.11.2014..
 */
public class InstitutionPresenter implements LightRecyclerPresenter {

    private Institution institution;
    @InjectView(R.id.imgInstitutionPicture)
    ImageView imgPicture;
    @InjectView(R.id.imgInstitutionLogo)
    ImageView imgLogo;
    @InjectView(R.id.txtInstitutionLabel)
    TextView txtInstitutionLabel;

    public InstitutionPresenter(Institution institution) {
        this.institution = institution;
    }

    @Override
    public void initViews(View view) {
        ButterKnife.inject(this, view);
    }

    @Override
    public void display(View view, int position) {
        Picasso.with(view.getContext()).load(institution.getPicture()).into(imgPicture);
        Picasso.with(view.getContext()).load(institution.getLogo()).into(imgLogo);
        txtInstitutionLabel.setText(institution.getName());
    }
}
