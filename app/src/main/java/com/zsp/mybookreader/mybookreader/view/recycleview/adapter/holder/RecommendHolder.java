package com.zsp.mybookreader.mybookreader.view.recycleview.adapter.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.bean.RecommendBean;
import com.zsp.mybookreader.mybookreader.common.ui.BaseAdapterRV;
import com.zsp.mybookreader.mybookreader.common.ui.BaseHolderRV;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/22.
 */

public class RecommendHolder extends BaseHolderRV {

    private TextView tv;

    public RecommendHolder(Context context, ViewGroup parent, BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.fragment_holder);
    }

    @Override
    public void onFindViews(View itemView) {
        tv = (TextView) itemView.findViewById(R.id.tv);
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        RecommendBean.BooksBean s= ( RecommendBean.BooksBean) bean;
        tv.setText(s.getTitle());
    }
}
