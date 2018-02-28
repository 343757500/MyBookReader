package com.zsp.mybookreader.mybookreader.view.recycleview.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.zsp.mybookreader.mybookreader.common.ui.BaseAdapterRV;
import com.zsp.mybookreader.mybookreader.common.ui.BaseHolderRV;
import com.zsp.mybookreader.mybookreader.view.recycleview.adapter.holder.RecommendHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/1/22.
 */

public class RecommendAdapter extends BaseAdapterRV {
    public RecommendAdapter(Context context, List listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV createViewHolder(Context context, ViewGroup parent, int viewType) {
        return new RecommendHolder(context,parent,this,viewType);
    }
}
