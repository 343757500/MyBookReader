package com.zsp.mybookreader.mybookreader.view.recycleview.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;

import com.zsp.mybookreader.mybookreader.common.ui.BaseAdapterRV;
import com.zsp.mybookreader.mybookreader.common.ui.BaseHolderRV;
import com.zsp.mybookreader.mybookreader.view.recycleview.adapter.holder.ElvMaleHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/1/29.
 */

public class ElvMaleAdapter extends BaseAdapterRV {
    public ElvMaleAdapter(Context context, List listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV createViewHolder(Context context, ViewGroup parent, int viewType) {
        return new ElvMaleHolder(context,parent,this,viewType);
    }
}
