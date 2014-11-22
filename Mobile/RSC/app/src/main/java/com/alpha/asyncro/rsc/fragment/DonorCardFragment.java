package com.alpha.asyncro.rsc.fragment;

import android.widget.TextView;

import com.alpha.asyncro.rsc.MainActivity;
import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.event.OnUserReadListener;

import butterknife.InjectView;

/**
 * Created by dmacan on 22.11.2014..
 */
public class DonorCardFragment extends LabeledFragment implements OnUserReadListener {

    @InjectView(R.id.txtFirstName)
    TextView txtFirstName;
    @InjectView(R.id.txtLastName)
    TextView txtLastName;
    @InjectView(R.id.txtPoints)
    TextView txtPoints;
    @InjectView(R.id.txtEmail)
    TextView txtEmail;

    private MainActivity activity;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_donor_card;
    }

    @Override
    public void main() {
        activity = (MainActivity) getActivity();
        if (activity.getUser() != null)
            display(activity.getUser());
    }

    private void display(User user) {
        txtFirstName.setText(user.getName());
        txtLastName.setText(user.getSurname());
        txtPoints.setText(String.valueOf(user.getPoints()));
        txtEmail.setText(user.getEmail());
    }

    @Override
    public void onUserRead(User user) {
        display(user);
    }
}
