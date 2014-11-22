package com.alpha.asyncro.rsc;

import com.lightandroid.navigation.activity.LightSplashActivity;


public class SplashActivity extends LightSplashActivity {

    @Override
    public int provideLayoutRes() {
        return R.layout.activity_splash;
    }

    @Override
    public int getSplashTime() {
        return 500;
    }

    @Override
    public Class getNextClassActivity() {
        return MainActivity.class;
    }
}
