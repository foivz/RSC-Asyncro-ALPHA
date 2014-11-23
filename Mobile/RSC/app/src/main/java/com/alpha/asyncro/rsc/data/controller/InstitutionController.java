package com.alpha.asyncro.rsc.data.controller;

import com.alpha.asyncro.rsc.data.RSCAPI;
import com.alpha.asyncro.rsc.data.model.Event;
import com.alpha.asyncro.rsc.data.model.Institution;
import com.alpha.asyncro.rsc.data.model.InstitutionRequest;
import com.lightandroid.data.LightController;
import com.lightandroid.event.LightDataMultipleResponseCallback;
import com.lightandroid.event.LightDataResponseCallback;
import com.lightandroid.util.LightAPIUtil;

/**
 * Created by dmacan on 23.11.2014..
 */
public class InstitutionController extends LightController {

    private LightDataResponseCallback<Institution> onInstitutionReadListener;
    private LightDataResponseCallback<Event> onEventReadListener;
    private LightDataMultipleResponseCallback<Institution[]> institutionsReadListener;
    private LightDataMultipleResponseCallback<Event[]> eventsReadListener;

    public InstitutionController() {
        onInstitutionReadListener = new LightDataResponseCallback<Institution>();
        onEventReadListener = new LightDataResponseCallback<Event>();
        institutionsReadListener = new LightDataMultipleResponseCallback<Institution[]>();
        eventsReadListener = new LightDataMultipleResponseCallback<Event[]>();
    }

    public void getInstitution(String institution, String token) {
        onInstitutionReadListener.setOnDataResponseListener(getOnDataResponseListener());
        onInstitutionReadListener.setOnErrorListener(getOnErrorListener());
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).getInstitution(new InstitutionRequest(String.valueOf(institution), token), onInstitutionReadListener);
    }

    public void getEvent(String event) {
        onEventReadListener.setOnDataResponseListener(getOnDataResponseListener());
        onEventReadListener.setOnErrorListener(getOnErrorListener());
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).getEvent(event, onEventReadListener);
    }

    public void getInstitutions(String token) {
        institutionsReadListener.setOnDataMultipleResponseListener(getOnDataMultipleResponseListener());
        institutionsReadListener.setOnErrorListener(getOnErrorListener());
        LightAPIUtil.getRestAdapter(RSCAPI.API_ENDPOINT).create(RSCAPI.class).getInstitutions(new InstitutionRequest(null, token), institutionsReadListener);
    }

    public void getEvents() {

    }

}
