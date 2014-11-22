package com.alpha.asyncro.rsc;

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
public class MainActivity extends LightTabbedActivity {

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
        return new Fragment[]{new LoginFragment(), new RegisterFragment()};
    }

    @Override
    public PagerSlidingTabStrip providePagerSlidingTabStrip() {
        tabs.setTextColorResource(R.color.white);
        return tabs;
    }

    @Override
    public int provideLayoutRes() {
        return R.layout.activity_main;
    }

}
