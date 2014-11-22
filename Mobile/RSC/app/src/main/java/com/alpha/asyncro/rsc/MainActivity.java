package com.alpha.asyncro.rsc;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.alpha.asyncro.rsc.fragment.ProfileFragment;
import com.astuetz.PagerSlidingTabStrip;
import com.lightandroid.navigation.activity.LightTabbedActivity;
import com.lightandroid.util.LightFont;

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
        ProfileFragment profileFragment = new ProfileFragment();
        profileFragment.setLabel(getResources().getString(R.string.mic_person));
        return new Fragment[]{profileFragment};
    }

    @Override
    public PagerSlidingTabStrip providePagerSlidingTabStrip() {
        tabs.setTextSize(20);
        tabs.setTypeface(LightFont.getTypeface(getBaseContext(), LightFont.DEFAULT_FONT), Typeface.NORMAL);
        return tabs;
    }


    @Override
    public int provideLayoutRes() {
        return R.layout.activity_main;
    }
}
