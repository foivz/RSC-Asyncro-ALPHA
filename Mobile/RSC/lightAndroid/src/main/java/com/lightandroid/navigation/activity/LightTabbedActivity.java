package com.lightandroid.navigation.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.lightandroid.ui.presenter.LightPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by David on 16.11.2014..
 */
public abstract class LightTabbedActivity extends LightActivity {

    private LightPagerAdapter pagerAdapter;

    @Override
    public void main() {
        this.pagerAdapter = new LightPagerAdapter(getSupportFragmentManager(), new ArrayList<Fragment>(Arrays.asList(provideFragments())));
        this.provideViewPager().setAdapter(pagerAdapter);
        this.providePagerSlidingTabStrip().setViewPager(provideViewPager());
    }

    public abstract ViewPager provideViewPager();

    public abstract Fragment[] provideFragments();

    public abstract PagerSlidingTabStrip providePagerSlidingTabStrip();

    public void setOnTabChangedListener(ViewPager.OnPageChangeListener onTabChangedListener) {
        this.providePagerSlidingTabStrip().setOnPageChangeListener(onTabChangedListener);
    }

    public LightPagerAdapter getPagerAdapter() {
        return pagerAdapter;
    }
}
