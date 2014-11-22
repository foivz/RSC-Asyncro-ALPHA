package com.alpha.asyncro.rsc.data;

import android.view.View;
import android.widget.TextView;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.model.Donation;
import com.lightandroid.ui.presenter.LightRecyclerPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dmacan on 22.11.2014..
 */
public class DonationPresenter implements LightRecyclerPresenter {

    @InjectView(R.id.txtDonationDate)
    TextView txtDonationDate;
    @InjectView(R.id.txtDonationQuantity)
    TextView txtDonationQuantity;

    private Donation donation;

    public DonationPresenter(Donation donation) {
        this.donation = donation;
    }

    @Override
    public void initViews(View view) {
        ButterKnife.inject(this, view);
    }

    @Override
    public void display(View view, int position) {
        txtDonationDate.setText(donation.getDate());
        txtDonationQuantity.setText(donation.getQuantity());
    }
}
