package com.alpha.asyncro.rsc;

import android.content.Intent;
import android.content.res.Configuration;

import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.util.Preferences;
import com.lightandroid.data.api.listener.OnDataResponseListener;
import com.lightandroid.navigation.activity.LightSplashActivity;
import com.lightandroid.type.LightData;

import java.util.Locale;

import retrofit.client.Response;


public class SplashActivity extends LightSplashActivity implements OnDataResponseListener {

    private UserController userController;
    private Locale locale;

    @Override
    public int provideLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    public int getSplashTime() {
        return 700;
    }

    @Override
    public Class getNextClassActivity() {
        changeLang(Preferences.loadLanguage(getBaseContext()));
        userController = new UserController(this);
        if (userController.isUserLoggedIn()) {
            userController.setOnDataResponseListener(this);
            userController.login(Preferences.loadUser(this));
            return null;
        }
        return LoginActivity.class;
    }

    @Override
    public void onResponse(LightData response, Response retrofitResponse) {
        User userResponse = (User) response;
        User user = Preferences.loadUser(getBaseContext());
        if (userResponse.isStatusOk()) {
            user.setToken(userResponse.getToken());
            Preferences.storeUser(user, this);
            startActivity(new Intent(this, MainActivity.class));
        } else
            startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void changeLang(String lang) {
        Configuration config = getResources().getConfiguration();
        if (!"".equals(lang) && !config.locale.getLanguage().equals(lang)) {
            Preferences.storeLanguage(lang, this);
            locale = new Locale(lang);
            Locale.setDefault(locale);
            Configuration conf = new Configuration(config);
            conf.locale = locale;
            this.getResources().updateConfiguration(conf, this.getResources().getDisplayMetrics());
        }
    }
}
