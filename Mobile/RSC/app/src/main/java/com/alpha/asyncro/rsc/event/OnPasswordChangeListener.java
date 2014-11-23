package com.alpha.asyncro.rsc.event;

import android.app.Activity;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.presenter.MessageDialog;
import com.lightandroid.type.LightData;

import retrofit.client.Response;

/**
 * Created by dmacan on 23.11.2014..
 */
public class OnPasswordChangeListener extends OnResponseListener {
    public OnPasswordChangeListener(Activity activity) {
        super(activity);
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        MessageDialog dialog = new MessageDialog(getActivity(), getActivity().getString(R.string.lbl_tajtl), getActivity().getString(R.string.lbl_pass_reset_confirm));
        dialog.show();
    }
}
