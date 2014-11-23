package com.alpha.asyncro.rsc.data.presenter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.alpha.asyncro.rsc.R;
import com.alpha.asyncro.rsc.data.model.User;
import com.lightandroid.ui.presenter.LightAdapterItem;
import com.lightandroid.util.LightFont;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dmacan on 22.11.2014..
 */
public class PointPresenter implements LightAdapterItem {

    @InjectView(R.id.txtRank)
    TextView txtRank;
    @InjectView(R.id.txtPoints)
    TextView txtPoints;

    private User user;

    public PointPresenter(User user) {
        this.user = user;
    }

    @Override
    public void display(View view, int position) {
        ButterKnife.inject(this, view);
        txtRank.setText(user.getRank());
        txtPoints.setText(generatePointDisplay(user, view.getContext()));
        LightFont.setFont("sangrio.ttf", txtPoints);
    }

    @Override
    public int provideItemLayoutRes() {
        return R.layout.item_points;
    }


    private String generatePointDisplay(User user, Context context) {
        int points = user.getPoints();
        int numHearts = points / 3;
        int numDrops = points % 3;
        String hearts = "";
        String drops = "";
        String heart = context.getResources().getString(R.string.ic_heart);
        String drop = context.getResources().getString(R.string.ic_drop);
        for (int i = 0; i < numHearts; i++)
            hearts += heart + " ";
        for (int i = 0; i < numDrops; i++)
            drops += drop + " ";
        return hearts + drops;
    }
}
