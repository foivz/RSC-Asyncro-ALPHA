package com.alpha.asyncro.rsc.event;

import android.app.Activity;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.presenter.MessageDialog;
import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.data.api.listener.OnErrorListener;

import retrofit.RetrofitError;

/**
 * Created by dmacan on 23.11.2014..
 */
public abstract class OnResponseListener implements OnDataResponseListener, OnErrorListener {

    private Activity activity;
    private MessageDialog dialog;

    public OnResponseListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onError(RetrofitError error) {
        dialog = new MessageDialog(getActivity(), activity.getString(R.string.lbl_error_error), activity.getString(R.string.lbl_err_msg_network));
        dialog.show();
    }

    public Activity getActivity() {
        return activity;
    }
}
