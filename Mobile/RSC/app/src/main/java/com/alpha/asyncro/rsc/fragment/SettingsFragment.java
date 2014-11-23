package com.alpha.asyncro.rsc.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.util.Preferences;
import com.lightandroid.navigation.fragment.LightFragment;

import java.util.Locale;

import butterknife.InjectView;

/**
 * Created by lovro on 23/11/14.
 */
public class SettingsFragment  extends LightFragment implements AdapterView.OnItemSelectedListener{

    private Locale locale = Locale.ENGLISH;


    @InjectView(R.id.spLanguageType)
    Spinner spLanguageType;
    @Override
    public int provideLayoutRes() {
        return R.layout.fragment_settings;
    }
    @Override
    public void main() {
        String[] languages = getLightActivity().getResources().getStringArray(R.array.arr_language);
        spLanguageType.setAdapter(new ArrayAdapter<String>(getLightActivity(), android.R.layout.simple_list_item_1, languages));
        spLanguageType.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getActivity(),"Odabran je element na poziciji "+ i,Toast.LENGTH_LONG).show();

        switch (i){
            case 0:
                String languageToLoad  = "en";
                changeLang(languageToLoad);
                Toast.makeText(getActivity(),"Language changed to english", Toast.LENGTH_LONG).show();
                break;

            case 1:
                String languageToLoad_1  = "hr";
                changeLang(languageToLoad_1);
                Toast.makeText(getActivity(),"Jezik promjenjen u hrvatski", Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //do nothing
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
        Log.d("Konfiguracija se mjenja","Konfiguracija nesto");


        Configuration config = getLightActivity().getResources().getConfiguration();
        if (!"".equals(lang) && !config.locale.getLanguage().equals(lang)) {
            Preferences.storeLanguage(lang, getLightActivity());

            locale = new Locale(lang);
            Locale.setDefault(locale);
            Configuration conf = new Configuration(config);
            conf.locale = locale;
            getLightActivity().getResources().updateConfiguration(conf, getLightActivity().getResources().getDisplayMetrics());

            Log.d("Konfiguracija promjenjea","Konfiguracija promjenjea");

        }
    }

    public static String getLang(Context context){
        return Preferences.loadLanguage(context);
    }



}
