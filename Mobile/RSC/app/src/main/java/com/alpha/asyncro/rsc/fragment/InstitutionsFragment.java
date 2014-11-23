package com.alpha.asyncro.rsc.fragment;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.controller.InstitutionController;
import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.type.LightData;

import org.lucasr.twowayview.widget.TwoWayView;

import butterknife.InjectView;
import retrofit.client.Response;

/**
 * Created by dmacan on 22.11.2014..
 */
public class InstitutionsFragment extends LabeledFragment implements OnDataResponseListener {

    @InjectView(R.id.twoWay)
    TwoWayView twoWayView;

    private InstitutionController institutionController;

    @Override
    public int provideLayoutRes() {
        return R.layout.layout_twoway;
    }

    @Override
    public void main() {
        institutionController = new InstitutionController();
        institutionController.setOnDataResponseListener(this);
    }


    @Override
    public void onResponse(LightData response, Response retrofitResponse) {

    }
}
