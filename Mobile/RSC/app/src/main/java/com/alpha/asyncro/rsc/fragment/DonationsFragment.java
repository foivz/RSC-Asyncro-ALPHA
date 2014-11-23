package com.alpha.asyncro.rsc.fragment;

import android.view.View;
import android.widget.TextView;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.model.Donation;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.data.presenter.DonationPresenter;
import com.alpha.asyncro.rsc.event.OnUserReadListener;
import com.lightandroid.ui.presenter.LightRecyclerViewAdapter;

import org.lucasr.twowayview.widget.TwoWayView;

import butterknife.InjectView;

/**
 * Created by dmacan on 22.11.2014..
 */
public class DonationsFragment extends LabeledFragment implements OnUserReadListener {

    @InjectView(R.id.twoWay)
    TwoWayView twoWayView;
    @InjectView(R.id.txtEmpty)
    TextView txtEmpty;
    @InjectView(R.id.lblEmpty)
    TextView lblEmpty;

    private LightRecyclerViewAdapter donationsAdapter;

    @Override
    public int provideLayoutRes() {
        return R.layout.item_donations;
    }

    @Override
    public void main() {
        donationsAdapter = new LightRecyclerViewAdapter(getLightActivity(), R.layout.item_donation);
        twoWayView.setAdapter(donationsAdapter);
    }

    @Override
    public void onUserRead(User user) {
        Donation[] donations = user.getDonations();
        if (donations != null && donations.length > 0) {
            txtEmpty.setVisibility(View.GONE);
            lblEmpty.setVisibility(View.GONE);
            for (Donation donation : donations)
                donationsAdapter.addItem(new DonationPresenter(donation));
        }
    }
}
