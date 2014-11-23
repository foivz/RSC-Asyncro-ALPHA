package com.alpha.asyncro.rsc;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.alpha.asyncro.rsc.data.controller.UserController;
import com.alpha.asyncro.rsc.data.model.User;
import com.alpha.asyncro.rsc.event.OnUserReadListener;
import com.alpha.asyncro.rsc.fragment.DonationsFragment;
import com.alpha.asyncro.rsc.fragment.InstitutionsFragment;
import com.alpha.asyncro.rsc.fragment.LoginFragment;
import com.alpha.asyncro.rsc.fragment.UserFragment;
import com.alpha.asyncro.rsc.util.Preferences;
import com.astuetz.PagerSlidingTabStrip;
import com.lightandroid.data.api.listener.OnDataMultipleResponseListener;
import com.lightandroid.data.api.listener.OnErrorListener;
import com.lightandroid.navigation.activity.LightTabbedActivity;
import com.lightandroid.type.LightData;
import com.lightandroid.util.LightFont;

import butterknife.InjectView;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by dmacan on 22.11.2014..
 */
public class MainActivity extends LightTabbedActivity implements OnDataMultipleResponseListener, OnErrorListener {


    @InjectView(R.id.pager)
    ViewPager pager;
    @InjectView(R.id.tabs)
    PagerSlidingTabStrip tabs;
    private User user;
    private static Fragment[] fragments;
    private UserController userController;

    @Override
    public ViewPager provideViewPager() {
        return pager;
    }

    @Override
    public Fragment[] provideFragments() {
        if (fragments == null) {
            userController = new UserController(this);
            userController.setOnDataMultipleResponseListener(this);
            userController.setOnErrorListener(this);
            User storedUser = Preferences.loadUser(this);
            UserFragment userFragment = new UserFragment();
            userFragment.setLabel(getResources().getString(R.string.mic_person));
            DonationsFragment donationsFragment = new DonationsFragment();
            donationsFragment.setLabel(getString(R.string.mic_favorite));
            InstitutionsFragment institutionsFragment = new InstitutionsFragment();
            institutionsFragment.setLabel(getString(R.string.mic_location_city));
            fragments = new Fragment[]{userFragment, donationsFragment, institutionsFragment};
            userController.loadUser(storedUser.getToken());
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

    @Override
    public void onError(RetrofitError error) {
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
        Log.i("DAM", error.getMessage());
    }

    @Override
    public void onMultipleResponse(LightData[] response, Response retrofitResponse) {
        User user = (User) response[0];
        setUser(user);
        for (Fragment fragment : fragments)
            if (fragment instanceof OnUserReadListener)
                ((OnUserReadListener) fragment).onUserRead(user);

    }

    public UserController getUserController() {
        return userController;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                userController.logoutUser(getBaseContext());
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                intent.putExtra(LoginFragment.KEY_AUTO_LOGIN, false);
                startActivity(intent);
                this.finish();
                break;

            case R.id.action_settings:
                Intent intentSettings = new Intent(getBaseContext(), SettingsActivity.class);
                startActivity(intentSettings);
                this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public static void setFragments(Fragment[] fragments) {
        MainActivity.fragments = fragments;
    }
}
