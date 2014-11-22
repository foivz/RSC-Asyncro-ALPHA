package com.alpha.asyncro.rsc.fragment;

import com.alpha.asyncro.rsc.MainActivity;
import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.event.OnUserReadListener;

/**
 * Created by dmacan on 22.11.2014..
 */
public class DonorCardFragment extends LabeledFragment implements OnUserReadListener {


    private MainActivity activity;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_donor_card;
    }

    @Override
    public void main() {
        activity = (MainActivity) getActivity();
    }


    @Override
    public void onUserRead(User user) {

    }
}
