package com.alpha.asyncro.rsc.fragment;

import com.lightandroid.navigation.fragment.LightFragment;
import com.lightandroid.type.property.Labeled;

/**
 * Created by dmacan on 22.11.2014..
 */
public abstract class LabeledFragment extends LightFragment implements Labeled {

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String provideLabel() {
        return getLabel();
    }
}
