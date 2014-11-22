package com.lightandroid.data;

import android.util.Log;
import android.widget.Filter;

import com.lightandroid.ui.presenter.LightAdapterItem;
import com.lightandroid.ui.presenter.LightAdapterItemFilterable;
import com.lightandroid.ui.presenter.LightFilterableAdapter;
import com.lightandroid.util.LightUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 8.10.2014..
 */
public class LightFilter extends Filter {

    private static final String TAG = "LightFilter";

    private boolean allWords;
    private LightFilterableAdapter adapter;
    private List<LightAdapterItemFilterable> originalItems;


    public LightFilter(LightFilterableAdapter adapter, boolean allWords) {
        this.allWords = allWords;
        this.adapter = adapter;
        this.originalItems = new ArrayList<LightAdapterItemFilterable>((List<LightAdapterItemFilterable>) (List<?>) adapter.getItems());
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();
        Log.d(TAG, "" + charSequence.toString().trim().equals(""));
        if (charSequence != null && charSequence.length() > 0 && !charSequence.toString().equals("")) {
            ArrayList<LightAdapterItemFilterable> filterList = new ArrayList<LightAdapterItemFilterable>();
            for (LightAdapterItemFilterable item : originalItems) {
                for (String data : item.getFilterableData()) {
                    Log.d(TAG, "Data: " + LightUtil.safeUppercase(data));
                    Log.d(TAG, "Charseq: " + LightUtil.safeUppercase(charSequence.toString()));
                    if (LightUtil.isStringContained(data, charSequence.toString(), true)) {
                        Log.d(TAG, "Data: " + LightUtil.safeUppercase(data));
                        Log.d(TAG, "Charseq: " + LightUtil.safeUppercase(charSequence.toString()));
                        filterList.add(item);
                    }
                }
            }
            results.count = filterList.size();
            results.values = filterList;
        } else {
            results.count = this.originalItems.size();
            results.values = this.originalItems;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        adapter.setItems((List<LightAdapterItem>) filterResults.values);
        adapter.notifyDataSetChanged();
    }
}
