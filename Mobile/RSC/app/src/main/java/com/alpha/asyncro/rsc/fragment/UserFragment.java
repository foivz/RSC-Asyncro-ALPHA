package com.alpha.asyncro.rsc.fragment;

import android.widget.ListView;

import com.alpha.asyncro.rsc.MainActivity;
import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.data.presenter.ChartPresenter;
import com.alpha.asyncro.rsc.data.presenter.DonorCardPresenter;
import com.alpha.asyncro.rsc.data.presenter.PointPresenter;
import com.alpha.asyncro.rsc.event.OnUserReadListener;
import com.lightandroid.ui.presenter.LightAdapter;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dmacan on 22.11.2014..
 */
public class UserFragment extends LabeledFragment implements OnUserReadListener {

    @InjectView(R.id.list)
    ListView listDonations;

    private MainActivity activity;
    private LightAdapter donationsAdapter;
    private DonorCardPresenter donorCardPresenter;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_user_2;
    }

    @Override
    public void main() {
        activity = (MainActivity) getActivity();
        activity.getActionBar().setTitle(activity.getResources().getString(R.string.lbl_my_profile));
        donationsAdapter = new LightAdapter(getLightActivity());
        listDonations.setAdapter(donationsAdapter);
        if (activity.getUser() != null)
            display(activity.getUser());
    }

    @Override
    public void onUserRead(User user) {
        display(user);
    }

    private void display(User user) {
        donationsAdapter.addItem(new PointPresenter(user));
        donationsAdapter.addItem(new ChartPresenter(user));
    }

    @OnClick(R.id.btnShowDonorCard)
    void showDonorCard() {
        if (donorCardPresenter == null)
            donorCardPresenter = new DonorCardPresenter(activity, activity.getUserController());
        donorCardPresenter.show(activity.getUser());
    }

}
