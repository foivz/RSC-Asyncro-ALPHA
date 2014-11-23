package com.alpha.asyncro.rsc.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.alpha.asyncro.rsc.MainActivity;
import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.util.Preferences;
import com.gc.materialdesign.views.Switch;
import com.lightandroid.navigation.fragment.LightFragment;

import java.util.Locale;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by lovro on 23/11/14.
 */
public class SettingsFragment extends LightFragment {

    private Locale locale = Locale.ENGLISH;


    @InjectView(R.id.spLanguageType)
    Spinner spLanguageType;
    @InjectView(R.id.swNotifications)
    Switch swNotifications;

    private String languageToLoad;

    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_settings;
    }

    @Override
    public void main() {
        String[] languages = getLightActivity().getResources().getStringArray(R.array.arr_language);
        spLanguageType.setAdapter(new ArrayAdapter<String>(getLightActivity(), android.R.layout.simple_list_item_1, languages));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (locale != null) {
            Locale.setDefault(locale);
            Configuration config = new Configuration(newConfig);
            config.locale = locale;
            getLightActivity().getResources().updateConfiguration(config, getLightActivity().getResources().getDisplayMetrics());
        }
    }

    public void changeLang(String lang) {
        Configuration config = getLightActivity().getResources().getConfiguration();
        if (!"".equals(lang) && !config.locale.getLanguage().equals(lang)) {
            Preferences.storeLanguage(lang, getLightActivity());
            locale = new Locale(lang);
            Locale.setDefault(locale);
            Configuration conf = new Configuration(config);
            conf.locale = locale;
            getLightActivity().getResources().updateConfiguration(conf, getLightActivity().getResources().getDisplayMetrics());
        }
    }

    private void language(int i) {
        switch (i) {
            case 0:
                languageToLoad = "en";
                break;
            case 1:
                languageToLoad = "hr";
                break;
        }
    }


    @OnClick(R.id.btnSave)
    void save() {
        language(spLanguageType.getSelectedItemPosition());
        changeLang(languageToLoad);
        Preferences.storeNotificationPref(getLightActivity(), swNotifications.isCheck());
        startActivity(new Intent(getLightActivity(), MainActivity.class));
        MainActivity.setFragments(null);
        getActivity().finish();
    }


}
