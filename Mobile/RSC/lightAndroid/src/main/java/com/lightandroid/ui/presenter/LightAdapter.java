package com.lightandroid.ui.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 16.9.2014..
 */
public class LightAdapter extends BaseAdapter {

    private List<LightAdapterItem> items;
    private Context context;
    private LayoutInflater inflater;

    public LightAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<LightAdapterItem>();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public LightAdapter(Context context, List<? extends LightAdapterItem> items) {
        this.context = context;
        this.items = (List<LightAdapterItem>) items;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return (items == null) ? 0 : items.size();
    }

    @Override
    public LightAdapterItem getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public List<LightAdapterItem> getItems() {
        return items;
    }

    public void setItems(List<? extends LightAdapterItem> items) {
        this.items = (List<LightAdapterItem>) items;
    }

    public boolean addItem(LightAdapterItem item) {
        boolean success = this.items.add(item);
        notifyDataSetChanged();
        notifyDataSetInvalidated();
        return success;
    }

    public void addAfter(int itemPosition, LightAdapterItem item) {
        this.items.add(itemPosition + 1, item);
        notifyDataSetChanged();
        notifyDataSetInvalidated();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(items.get(i).provideItemLayoutRes(), viewGroup, false);
        items.get(i).display(view, i);
        return view;
    }

    public void clear() {
        this.items.clear();
        notifyDataSetChanged();
        notifyDataSetInvalidated();
    }

}
