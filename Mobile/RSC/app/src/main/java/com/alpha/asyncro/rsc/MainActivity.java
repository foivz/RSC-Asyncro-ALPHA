package com.alpha.asyncro.rsc;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.fragment.DonorCardFragment;
import com.alpha.asyncro.rsc.fragment.EventsFragment;
import com.alpha.asyncro.rsc.fragment.InstitutionsFragment;
import com.alpha.asyncro.rsc.fragment.UserFragment;
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
    private User user;
    private static Fragment[] fragments;

    @Override
    public ViewPager provideViewPager() {
        return pager;
    }

    @Override
    public Fragment[] provideFragments() {
        if (fragments == null) {
            UserFragment userFragment = new UserFragment();
            userFragment.setLabel(getResources().getString(R.string.mic_person));
            DonorCardFragment donorCardFragment = new DonorCardFragment();
            donorCardFragment.setLabel(getString(R.string.mic_credit_card));
            InstitutionsFragment institutionsFragment = new InstitutionsFragment();
            institutionsFragment.setLabel(getString(R.string.mic_location_city));
            EventsFragment eventsFragment = new EventsFragment();
            eventsFragment.setLabel(getString(R.string.mic_event));
            fragments = new Fragment[]{userFragment, donorCardFragment, institutionsFragment, eventsFragment};
        }
        return fragments;
    }

    @Override
    public PagerSlidingTabStrip providePagerSlidingTabStrip() {
        tabs.setTextSize(50);
        tabs.setTextColor(getResources().getColor(R.color.white));
        tabs.setTypeface(LightFont.getTypeface(getBaseContext(), LightFont.DEFAULT_FONT), Typeface.NORMAL);
        return tabs;
    }


    @Override
    public int provideLayoutRes() {
        return R.layout.activity_main;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
