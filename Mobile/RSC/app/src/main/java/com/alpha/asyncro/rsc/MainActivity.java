package com.alpha.asyncro.rsc;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.lightandroid.navigation.activity.LightActivity;
import com.lightandroid.navigation.activity.LightTabbedActivity;

/**
 * Created by dmacan on 22.11.2014..
 */
public class MainActivity extends LightTabbedActivity {

    @Override
    public ViewPager provideViewPager() {
        return null;
    }

    @Override
    public Fragment[] provideFragments() {
        return new Fragment[0];
    }

    @Override
    public PagerSlidingTabStrip providePagerSlidingTabStrip() {
        return null;
    }

    @Override
    public int provideLayoutRes() {
        return 0;
    }
}
