package com.lightandroid.ui.presenter;

import android.content.Context;
import android.widget.Filterable;

import com.lightandroid.data.LightFilter;

import java.util.List;

/**
 * Created by David on 8.10.2014..
 */
public class LightFilterableAdapter extends LightAdapter implements Filterable {

    private LightFilter filter;

    public LightFilterableAdapter(Context context) {
        super(context);
        this.filter = new LightFilter(this, true);
    }

    public LightFilterableAdapter(Context context, List<? extends LightAdapterItemFilterable> items) {
        super(context, items);
        this.filter = new LightFilter(this, true);
    }

    @Override
    public LightFilter getFilter() {
        return filter;
    }

}