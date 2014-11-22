package com.lightandroid.ui.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 16.11.2014..
 */
public class LightRecyclerViewAdapter extends RecyclerView.Adapter<LightViewHolder> {
    private List<LightRecyclerPresenter> lightRecyclerPresenters;
    private Context context;
    private int layoutRes;
    private LightViewHolder.OnLightItemClickListener onLightItemClickListener;

    public LightRecyclerViewAdapter(Context context, List<? extends LightRecyclerPresenter> lightRecyclerPresenters, int layoutRes) {
        this.lightRecyclerPresenters = (List<LightRecyclerPresenter>) lightRecyclerPresenters;
        this.context = context;
        this.layoutRes = layoutRes;
    }

    public LightRecyclerViewAdapter(Context context, int layoutRes) {
        this.lightRecyclerPresenters = new ArrayList<LightRecyclerPresenter>();
        this.context = context;
        this.layoutRes = layoutRes;
    }

    @Override
    public LightViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        LightRecyclerPresenter presenter = lightRecyclerPresenters.get(0);
        View v = LayoutInflater.from(context).inflate(layoutRes, viewGroup, false);
        return new LightViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LightViewHolder lightViewHolder, int i) {
        lightViewHolder.setPresenter(lightRecyclerPresenters.get(i));
        lightViewHolder.getPresenter().display(lightViewHolder.itemView, i);
        lightViewHolder.setPosition(i);
        if (this.onLightItemClickListener != null)
            lightViewHolder.setOnLightItemClickListener(this.onLightItemClickListener);
    }

    @Override
    public int getItemCount() {
        return lightRecyclerPresenters == null ? 0 : lightRecyclerPresenters.size();
    }

    public void addItem(LightRecyclerPresenter presenter) {
        lightRecyclerPresenters.add(presenter);
        notifyDataSetChanged();
    }

    public void addItem(LightRecyclerPresenter presenter, int position) {
        lightRecyclerPresenters.add(position, presenter);
        notifyDataSetChanged();
    }

    public LightViewHolder.OnLightItemClickListener getOnLightItemClickListener() {
        return onLightItemClickListener;
    }

    public void setOnLightItemClickListener(LightViewHolder.OnLightItemClickListener onLightItemClickListener) {
        this.onLightItemClickListener = onLightItemClickListener;
    }

    public LightRecyclerPresenter getItem(int position) {
        return lightRecyclerPresenters.get(position);
    }

    public List<LightRecyclerPresenter> getLightRecyclerPresenters() {
        return lightRecyclerPresenters;
    }

    public void setLightRecyclerPresenters(List<? extends LightRecyclerPresenter> lightRecyclerPresenters) {
        this.lightRecyclerPresenters = (List<LightRecyclerPresenter>) lightRecyclerPresenters;
        notifyDataSetChanged();
    }
}
