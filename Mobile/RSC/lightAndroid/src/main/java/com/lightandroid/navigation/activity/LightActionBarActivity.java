package com.lightandroid.navigation.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import butterknife.ButterKnife;

/**
 * Created by David on 9.11.2014..
 */
public abstract class LightActionBarActivity extends ActionBarActivity {

    public static final String DEFAULT_FRAGMENT_TAG = "com.dmacan.tags.defaultfragment";
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private String currentFragmentTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutRes = provideLayoutRes();
        if (layoutRes != 0)
            setContentView(layoutRes);
        ButterKnife.inject(this);
        fragmentManager = getLightFragmentManager();
        currentFragmentTag = DEFAULT_FRAGMENT_TAG;
        main(savedInstanceState);
    }

    public abstract void main(Bundle savedInstanceState);

    public abstract int provideLayoutRes();

    public void setupFragment(int container, Fragment fragment) {
        attachFragment(container, fragment, DEFAULT_FRAGMENT_TAG);
        commitTransactions();
    }

    public void setupFragment(int container, Fragment fragment, String tag) {
        attachFragment(container, fragment, tag);
        commitTransactions();
    }

    public FragmentTransaction ensureTransaction() {
        if (fragmentTransaction == null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
        return fragmentTransaction;
    }

    public void attachFragment(int layout, Fragment fragment, String tag) {
        if (fragment != null) {
            if (fragment.isDetached()) {
                ensureTransaction();
                fragmentTransaction.attach(fragment);
            } else if (!fragment.isAdded()) {
                ensureTransaction();
                fragmentTransaction.replace(layout, fragment, tag);
            }
        }
    }

    public void detachFragment(Fragment fragment) {
        if (fragment != null && !fragment.isDetached()) {
            ensureTransaction();
            if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
                fragmentTransaction.commit();
                fragmentTransaction = null;
            }
        }
    }

    public void commitTransactions() {
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();
            fragmentTransaction = null;
        }
    }

    public String getCurrentFragmentTag() {
        return currentFragmentTag;
    }

    public void setCurrentFragmentTag(String currentFragmentTag) {
        this.currentFragmentTag = currentFragmentTag;
    }

    public FragmentManager getLightFragmentManager() {
        if (fragmentManager == null)
            fragmentManager = getSupportFragmentManager();
        return fragmentManager;
    }

    public void setLightFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void refreshFragment(String tag) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        refreshFragment(fragment);
    }

    public void refreshFragment(Fragment fragment) {
        detachFragment(fragment);
        attachFragment(0, fragment, fragment.getTag());
        commitTransactions();
    }


    public Fragment loadFragment(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

}
