package com.lightandroid.navigation.fragment;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.lightandroid.navigation.activity.LightActivity;
import com.lightandroid.type.LightIconDrawable;

import butterknife.ButterKnife;

/**
 * Created by David on 16.9.2014..
 */
public abstract class LightFragment extends Fragment {

    private Menu menu;
    private Activity parentActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.setHasOptionsMenu(true);
        View view = inflater.inflate(provideLayoutRes(), container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        main();
    }

    public LightActivity getLightActivity() {
        if (getActivity() != null)
            return (LightActivity) getActivity();
        return (LightActivity) parentActivity;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.parentActivity = activity;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public abstract int provideLayoutRes();

    public abstract void main();

    public void supplyMenuIcons(Drawable... icons) {
        for (int i = 0; i < menu.size(); i++) {
            if (i < icons.length)
                menu.getItem(i).setIcon(icons[i]);
        }
    }

    public void supplyMenuIcons(int color, int... icons) {
        LightIconDrawable[] iconDrawables = new LightIconDrawable[icons.length];
        for (int i = 0; i < icons.length; i++) {
            LightIconDrawable drawable = new LightIconDrawable(getLightActivity(), getResources().getString(icons[i]));
            drawable.sizeDp(24);
            drawable.colorRes(color);
            iconDrawables[i] = drawable;
        }
        supplyMenuIcons(iconDrawables);
    }

}
