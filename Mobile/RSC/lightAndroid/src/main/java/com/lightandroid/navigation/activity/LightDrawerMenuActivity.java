package com.lightandroid.navigation.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dmacan.lightandroid.R;
import com.lightandroid.ui.drawer.DrawerListener;
import com.lightandroid.ui.drawer.DrawerSettings;
import com.lightandroid.ui.presenter.LightAdapter;
import com.lightandroid.ui.presenter.LightAdapterItem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by David on 16.11.2014..
 */
public abstract class LightDrawerMenuActivity extends LightDrawerActivity implements DrawerListener {

    private ListView drawerList;
    private LightAdapter drawerAdapter;
    private AdapterView.OnItemClickListener drawerListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            onDrawerItemSelected(i);
        }
    };

    @Override
    public DrawerSettings setDrawerSettings() {
        DrawerSettings settings = new DrawerSettings().layoutRes(R.layout.layout_list);
        setDrawerSettings(settings);
        return settings;
    }

    @Override
    public void setupDrawerView(Bundle savedInstanceState, View menuView) {
        drawerList = (ListView) menuView.findViewById(R.id.list);
        drawerAdapter = new LightAdapter(getBaseContext(), new ArrayList<LightAdapterItem>(Arrays.asList(setDrawerItems())));
        drawerList.setAdapter(drawerAdapter);
        drawerList.setOnItemClickListener(drawerListener);
    }

    public abstract void setDrawerSettings(DrawerSettings settings);

    public abstract LightAdapterItem[] setDrawerItems();

    public ListView getDrawerList() {
        return drawerList;
    }

    public LightAdapter getDrawerAdapter() {
        return drawerAdapter;
    }
}
