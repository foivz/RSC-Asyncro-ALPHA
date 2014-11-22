package com.lightandroid.navigation.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lightandroid.ui.drawer.DrawerSettings;

import net.simonvt.menudrawer.MenuDrawer;

/**
 * Created by David on 9.11.2014..
 */
public abstract class LightDrawerActivity extends LightActionBarActivity {

    private static final String TAG_PREFIX = "com.dmacan.ahuskano.drawerfragment.";
    protected MenuDrawer menuDrawer;
    private DrawerSettings drawerSettings;
    private MenuDrawer.OnDrawerStateChangeListener stateChangeListener = new MenuDrawer.OnDrawerStateChangeListener() {
        @Override
        public void onDrawerStateChange(int oldState, int newState) {
            if (newState == MenuDrawer.STATE_CLOSED)
                commitTransactions();
        }

        @Override
        public void onDrawerSlide(float v, int i) {
        }
    };
    private View.OnClickListener drawerToggleListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            menuDrawer.openMenu();
        }
    };

    @Override
    public void main(Bundle savedInstanceState) {
        this.drawerSettings = setDrawerSettings();
        menuDrawer = MenuDrawer.attach(this, drawerSettings.getType(), drawerSettings.getPosition(), drawerSettings.getDragMode());
        if (this.drawerSettings.getDrawerSize() > 0)
            menuDrawer.setMenuSize(this.drawerSettings.getDrawerSize());
        if (drawerSettings.getDropShadowRes() != 0)
            menuDrawer.setDropShadow(drawerSettings.getDropShadowRes());
        menuDrawer.setOnDrawerStateChangeListener(stateChangeListener);
        menuDrawer.setMenuView(drawerSettings.getLayoutRes());
        if (!drawerSettings.getType().equals(MenuDrawer.Type.STATIC))
            menuDrawer.setContentView(provideLayoutRes());
        setupDrawerView(savedInstanceState, menuDrawer.getMenuView());
        init(savedInstanceState);
    }

    public void setupContentFragment(Fragment fragment) {
        setupFragment(menuDrawer.getContentContainer().getId(), fragment);
    }

    public void setupContentFragment(Fragment fragment, String tag) {
        setupFragment(menuDrawer.getContentContainer().getId(), fragment, TAG_PREFIX + tag);
    }

    public void setupDrawerFragment(Fragment fragment) {
        setupFragment(menuDrawer.getMenuContainer().getId(), fragment);
    }

    public void setupDrawerFragment(Fragment fragment, String tag) {
        setupFragment(menuDrawer.getMenuContainer().getId(), fragment, TAG_PREFIX + tag);
    }

    public abstract DrawerSettings setDrawerSettings();

    public abstract void init(Bundle savedInstanceState);

    public abstract void setupDrawerView(Bundle savedInstanceState, View menuView);

    public MenuDrawer getMenuDrawer() {
        return menuDrawer;
    }

    public View.OnClickListener getDrawerToggleListener() {
        return drawerToggleListener;
    }
}
