package com.zsp.mybookreader.mybookreader.view.recycleview.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.zsp.mybookreader.mybookreader.common.ui.BaseAdapterRV;
import com.zsp.mybookreader.mybookreader.common.ui.BaseHolderRV;
import com.zsp.mybookreader.mybookreader.view.recycleview.adapter.holder.FindHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/1/29.
 */

public class FindAdapter extends BaseAdapterRV{

    public FindAdapter(Context context, List listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV createViewHolder(Context context, ViewGroup parent, int viewType) {
        return new FindHolder(context,parent,this,viewType);
    }
}
