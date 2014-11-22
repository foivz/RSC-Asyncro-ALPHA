package com.alpha.asyncro.rsc.fragment;

import android.widget.TextView;

import com.alpha.asyncro.rsc.MainActivity;
import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.presenter.DonationPresenter;
import com.alpha.asyncro.rsc.data.model.Donation;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.event.OnUserReadListener;
import com.lightandroid.ui.presenter.LightRecyclerViewAdapter;
import com.lightandroid.util.LightFont;

import org.lucasr.twowayview.widget.TwoWayView;

import butterknife.InjectView;

/**
 * Created by dmacan on 22.11.2014..
 */
public class UserFragment extends LabeledFragment implements OnUserReadListener {

    @InjectView(R.id.txtPoints)
    TextView txtPoints;
    @InjectView(R.id.txtRank)
    TextView txtRank;
    @InjectView(R.id.twoWay)
    TwoWayView listDonations;

    private MainActivity activity;
    private LightRecyclerViewAdapter donationsAdapter;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_user;
    }

    @Override
    public void main() {
        activity = (MainActivity) getActivity();
        donationsAdapter = new LightRecyclerViewAdapter(getLightActivity(), R.layout.item_donation);
        listDonations.setAdapter(donationsAdapter);
        LightFont.setFont("sangrio.ttf", txtPoints);
        if (activity.getUser() != null)
            display(activity.getUser());
    }

    @Override
    public void onUserRead(User user) {
        display(user);
    }

    private void display(User user) {
        txtRank.setText(user.getRank());
        txtPoints.setText(generatePointDisplay(user));
        Donation[] donations = user.getDonations();
        if (donations != null)
            for (Donation donation : donations)
                donationsAdapter.addItem(new DonationPresenter(donation));
    }

    private String generatePointDisplay(User user) {
        int points = user.getPoints();
        int numHearts = points / 3;
        int numDrops = points % 3;
        String hearts = "";
        String drops = "";
        String heart = getResources().getString(R.string.ic_heart);
        String drop = getResources().getString(R.string.ic_drop);
        for (int i = 0; i < numHearts; i++)
            hearts += heart;
        for (int i = 0; i < numDrops; i++)
            drops += drop;
        return hearts + drops;
    }
}
