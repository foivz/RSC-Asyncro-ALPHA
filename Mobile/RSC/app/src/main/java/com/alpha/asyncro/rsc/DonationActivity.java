package com.alpha.asyncro.rsc;

import com.alpha.asyncro.rsc.data.controller.InstitutionController;
import com.alpha.asyncro.rsc.data.model.Donation;
import com.alpha.asyncro.rsc.data.model.Institution;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.util.Preferences;
import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.navigation.activity.LightActivity;
import com.lightandroid.type.LightData;
import com.lightandroid.util.LightAPIUtil;

import retrofit.client.Response;

/**
 * Created by dmacan on 23.11.2014..
 */
public class DonationActivity extends LightActivity {

    private Donation donation;
    public static final String KEY_DONATION = "com.asyncro.donation";
    private InstitutionController institutionController;
    private User user;
    private Institution institution;

    @Override
    public int provideLayoutRes() {
        return R.layout.activity_donation;
    }

    @Override
    public void main() {
        user = Preferences.loadUser(this);
        institutionController = new InstitutionController();
        donation = LightAPIUtil.createGson().fromJson(getIntent().getStringExtra(KEY_DONATION), Donation.class);
        institutionController.setOnDataResponseListener(institutionResponse);
        institutionController.getInstitution(String.valueOf(donation.getInstitution()), user.getToken());
    }

    private OnDataResponseListener institutionResponse = new OnDataResponseListener() {
        @Override
        public void onResponse(LightData response, Response retrofitResponse) {
            institution = (Institution) response;
        }
    };

}
