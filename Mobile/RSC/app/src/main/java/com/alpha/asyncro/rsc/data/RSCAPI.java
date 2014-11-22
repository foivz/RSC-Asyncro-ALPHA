package com.alpha.asyncro.rsc.data;

import com.alpha.asyncro.rsc.data.model.User;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

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
    public void resetPassword(@Body User request, Callback<User> response);

}
