package com.lightandroid.ui.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lightandroid.type.property.Labeled;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 16.11.2014..
 */
public class LightPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public LightPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<Fragment>();
    }

    public LightPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public List<Fragment> getAllFragmentItems() {
        return this.fragments;
    }

    public void addFragment(Fragment fragment) {
        this.fragments.add(fragment);
        this.notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Fragment fragment = fragments.get(position);
        if (fragment instanceof Labeled)
            return ((Labeled) fragment).provideLabel();
        return "";
    }
}
