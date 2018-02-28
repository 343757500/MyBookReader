package com.zsp.mybookreader.mybookreader.view.recycleview.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.zsp.mybookreader.mybookreader.common.ui.BaseAdapterRV;
import com.zsp.mybookreader.mybookreader.common.ui.BaseHolderRV;
import com.zsp.mybookreader.mybookreader.view.recycleview.adapter.holder.ElvFeMaleHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/2/1.
 */

public class ElvFeMaleAdapter extends BaseAdapterRV{
    public ElvFeMaleAdapter(Context context, List listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV createViewHolder(Context context, ViewGroup parent, int viewType) {
        return new ElvFeMaleHolder(context,parent,this,viewType);
    }
}
