package com.lightandroid.navigation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by ahuskano on 9/18/2014.
 */
public abstract class LightSplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutRes());
        main();
    }

    public void main() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(getBaseContext(), getNextClassActivity()));
                finish();
            }
        }, getSplashTime());

    }

    public abstract int provideLayoutRes();

    public abstract int getSplashTime();

    public abstract Class getNextClassActivity();
}
