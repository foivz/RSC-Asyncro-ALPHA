package com.alpha.asyncro.rsc;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.alpha.asyncro.rsc.fragment.LoginFragment;
import com.alpha.asyncro.rsc.fragment.RegisterFragment;
import com.astuetz.PagerSlidingTabStrip;
import com.lightandroid.navigation.activity.LightTabbedActivity;

import butterknife.InjectView;

/**
 * Created by dmacan on 22.11.2014..
 */
public class LoginActivity extends LightTabbedActivity {

    @InjectView(R.id.pager)
    ViewPager pager;
    @InjectView(R.id.tabs)
    PagerSlidingTabStrip tabs;


    @Override
    public ViewPager provideViewPager() {
        return pager;
    }

    @Override
    public Fragment[] provideFragments() {
        RegisterFragment registerFragment = new RegisterFragment();
        registerFragment.setLabel(getResources().getString(R.string.lbl_register));
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setLabel(getResources().getString(R.string.lbl_login));
        return new Fragment[]{loginFragment, registerFragment};
    }

    @Override
    public PagerSlidingTabStrip providePagerSlidingTabStrip() {
        tabs.setTextColorResource(R.color.white);
        tabs.setIndicatorColorResource(R.color.gray);
        return tabs;
    }

    @Override
    public int provideLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Fragment fragment = getSupportFragmentManager().findFragmentByTag(LoginFragment.SOCIAL_NETWORK_TAG);
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

}
