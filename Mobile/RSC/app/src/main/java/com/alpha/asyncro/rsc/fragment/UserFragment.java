package com.alpha.asyncro.rsc.fragment;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.alpha.asyncro.rsc.MainActivity;
import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.DonationPresenter;
import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.Donation;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.util.Preferences;
import com.lightandroid.data.api.listener.OnDataMultipleResponseListener;
import com.lightandroid.data.api.listener.OnErrorListener;
import com.lightandroid.type.LightData;
import com.lightandroid.ui.presenter.LightRecyclerViewAdapter;
import com.lightandroid.util.LightFont;

import org.lucasr.twowayview.widget.TwoWayView;

import butterknife.InjectView;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by dmacan on 22.11.2014..
 */
public class UserFragment extends LabeledFragment implements OnDataMultipleResponseListener, OnErrorListener {

    @InjectView(R.id.txtPoints)
    TextView txtPoints;
    @InjectView(R.id.txtRank)
    TextView txtRank;
    @InjectView(R.id.twoWay)
    TwoWayView listDonations;

    private UserController userController;
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
        userController = new UserController(getLightActivity());
        userController.setOnDataMultipleResponseListener(this);
        userController.setOnErrorListener(this);
        User user = Preferences.loadUser(getLightActivity());
        listDonations.setAdapter(donationsAdapter);
        LightFont.setFont("sangrio.ttf", txtPoints);
        if (activity.getUser() != null)
            display();
        else
            userController.loadUser(user.getToken());
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

    @Override
    public void onError(RetrofitError error) {
        Toast.makeText(getLightActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
        Log.i("DAM", error.getMessage());
    }

    @Override
    public void onMultipleResponse(LightData[] response, Response retrofitResponse) {
        User user = (User) response[0];
        activity.setUser(user);
        display();
    }

    private void display() {
        txtRank.setText(activity.getUser().getRank());
        txtPoints.setText(generatePointDisplay(activity.getUser()));
        Donation[] donations = activity.getUser().getDonations();
        if (donations != null)
            for (Donation donation : donations)
                donationsAdapter.addItem(new DonationPresenter(donation));
    }
}
