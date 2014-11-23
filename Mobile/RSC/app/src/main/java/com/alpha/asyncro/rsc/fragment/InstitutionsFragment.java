package com.alpha.asyncro.rsc.fragment;

import com.alpha.asyncro.rsc.MainActivity;
import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.controller.InstitutionController;
import com.alpha.asyncro.rsc.data.model.Institution;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.data.presenter.InstitutionPresenter;
import com.alpha.asyncro.rsc.event.OnUserReadListener;
import com.alpha.asyncro.rsc.util.Const;
import com.alpha.asyncro.rsc.util.Preferences;
import com.lightandroid.data.api.listener.OnDataMultipleResponseListener;
import com.lightandroid.type.LightData;
import com.lightandroid.ui.presenter.LightRecyclerViewAdapter;
import com.lightandroid.util.LightAPIUtil;

import org.lucasr.twowayview.widget.TwoWayView;

import butterknife.InjectView;
import retrofit.client.Response;

/**
 * Created by dmacan on 22.11.2014..
 */
public class InstitutionsFragment extends LabeledFragment implements OnDataMultipleResponseListener, OnUserReadListener {

    @InjectView(R.id.twoWay)
    TwoWayView twoWayView;

    private LightRecyclerViewAdapter institutionsAdapter;
    private static Institution[] institutions;
    private MainActivity activity;

    private InstitutionController institutionController;

    @Override
    public int provideLayoutRes() {
        return R.layout.layout_twoway;
    }

    @Override
    public void main() {
        activity = (MainActivity) getActivity();
        institutionsAdapter = new LightRecyclerViewAdapter(getLightActivity(), R.layout.item_institution);
        twoWayView.setAdapter(institutionsAdapter);
        institutionController = new InstitutionController();
        institutionController.setOnDataMultipleResponseListener(this);
        User stored = Preferences.loadUser(getLightActivity());
        if (institutions == null) {
//            institutions = LightAPIUtil.createGson().fromJson(Const.JSON, Institution[].class);
            institutionController.getInstitutions(stored.getToken());
//            display(institutions);
        }
    }


    @Override
    public void onMultipleResponse(LightData[] response, Response retrofitResponse) {
        institutions = (Institution[]) response;
        display(institutions);
    }

    private void display(Institution[] institutions) {
        if (institutions != null)
            for (Institution institution : institutions)
                institutionsAdapter.addItem(new InstitutionPresenter(institution));
    }

    @Override
    public void onUserRead(User user) {

    }
}
