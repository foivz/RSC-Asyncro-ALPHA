package com.lightandroid.ui.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by David on 16.11.2014..
 */
public class LightViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private LightRecyclerPresenter presenter;
    private int position;
    private OnLightItemClickListener onLightItemClickListener;

    public LightViewHolder(View itemView) {
        super(itemView);
    }

    public LightViewHolder(LightRecyclerPresenter recyclerPresenter, View view) {
        super(view);
        this.presenter = recyclerPresenter;
        this.presenter.initViews(itemView);
    }

    public LightRecyclerPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(LightRecyclerPresenter presenter) {
        this.presenter = presenter;
        this.presenter.initViews(itemView);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setOnLightItemClickListener(OnLightItemClickListener onLightItemClickListener) {
        itemView.setOnClickListener(this);
        this.onLightItemClickListener = onLightItemClickListener;
    }

    @Override
    public void onClick(View view) {
        this.onLightItemClickListener.onLightItemClick(view, position);
    }

    public interface OnLightItemClickListener {
        public void onLightItemClick(View view, int position);
    }

}
