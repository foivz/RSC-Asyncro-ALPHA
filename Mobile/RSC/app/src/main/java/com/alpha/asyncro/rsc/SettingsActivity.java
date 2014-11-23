package com.alpha.asyncro.rsc;

import android.content.res.Configuration;

import com.alpha.asyncro.rsc.fragment.SettingsFragment;
import com.lightandroid.navigation.activity.LightActivity;

/**
 * Created by dmacan on 22.11.2014..
 */
public class SettingsActivity extends LightActivity {
    @Override
    public int provideLayoutRes() {
        return R.layout.activity_container;
    }

    @Override
    public void main() {
        setupFragment(R.id.container,new SettingsFragment());
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
