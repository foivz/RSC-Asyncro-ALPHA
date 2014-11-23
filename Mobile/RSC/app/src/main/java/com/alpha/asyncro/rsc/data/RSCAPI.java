package com.alpha.asyncro.rsc.data;

import com.alpha.asyncro.rsc.data.model.Event;
import com.alpha.asyncro.rsc.data.model.Institution;
import com.alpha.asyncro.rsc.data.model.InstitutionRequest;
import com.alpha.asyncro.rsc.data.model.Secure;
import com.alpha.asyncro.rsc.data.model.User;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by dmacan on 22.11.2014..
 */
public interface RSCAPI {

    public static final String API_ENDPOINT = "http://178.62.74.13/api";


    @POST("/account/login")
    public void login(@Body User request, Callback<User> response);

    @POST("/account/registration")
    public void register(@Body User request, Callback<User> response);

    @POST("/account/reset")
    public void resetPassword(@Query("email") String mail, Callback<User> response);

    @POST("/account/forgot")
    public void forgotPassword(@Body User user, Callback<Secure> response);

    @POST("/user/fetch")
    public void loadUser(@Query("auth_token") String token, Callback<User[]> response);

    @POST("/account/registration/twitter")
    public void loginTwitter(@Body User request, Callback<User> response);

    @POST("/1/institution")
    public void getInstitution(@Body InstitutionRequest institutionRequest, Callback<Institution> response);

    @POST("/1/institutions/all")
    public void getInstitutions(@Body InstitutionRequest institutionRequest, Callback<Institution[]> response);

    @POST("/1/fetch/event")
    public void getEvent(@Query("donationId") String id, Callback<Event> response);

    @POST("/1/fetch/event")
    public void getEvents(@Query("donationId") String id, Callback<Event[]> events);

    @POST("/account/update")
    public void editUser(@Body User user, Callback<User> response);

}
