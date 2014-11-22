package com.lightandroid.navigation.activity;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * Created by David on 16.9.2014..
 */
public abstract class LightActivity extends FragmentActivity {

    private int layoutRes;
    private int fragmentContainer;
    private Bundle savedInstanceState;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        this.layoutRes = provideLayoutRes();
        setContentView(this.layoutRes);
        ButterKnife.inject(this);
        main();
    }

    /**
     * Takes given fragment and displays it within the activity. If another fragment is focused, it replaces it
     *
     * @param container Resource ID of the container layout for the fragment
     * @param fragment  Fragment that is to be displayed
     */
    public void setupFragment(int container, Fragment fragment) {
        if (this.savedInstanceState == null) {
            this.currentFragment = fragment;
            this.fragmentContainer = container;
            getSupportFragmentManager().beginTransaction().replace(container, fragment).commit();
        }
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void setupFragmentNoSupport(int container, android.app.Fragment fragment) {
        if (this.savedInstanceState == null) {
            this.fragmentContainer = container;
            getFragmentManager().beginTransaction().replace(container, fragment).commit();
        }
    }

    /**
     * Activity that extends this class returns layout resource id for the layout that it is using
     *
     * @return layout resource id for the desired layout
     */
    public abstract int provideLayoutRes();

    /**
     * This method is called after the activity has been created and some configurations were made
     */
    public abstract void main();

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // Getters
    public int getLayoutRes() {
        return layoutRes;
    }

    public int getFragmentContainer() {
        return fragmentContainer;
    }

    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}
