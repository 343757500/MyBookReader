package com.zsp.mybookreader.mybookreader.view.recycleview.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.zsp.mybookreader.mybookreader.bean.RankIdBean;
import com.zsp.mybookreader.mybookreader.common.ui.BaseAdapterRV;
import com.zsp.mybookreader.mybookreader.common.ui.BaseHolderRV;
import com.zsp.mybookreader.mybookreader.view.recycleview.adapter.holder.SubRankFragmentHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public class SubRankFragmentAdapter extends BaseAdapterRV<RankIdBean.RankingBean.BooksBean>{
    public SubRankFragmentAdapter(Context context, List<RankIdBean.RankingBean.BooksBean> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<RankIdBean.RankingBean.BooksBean> createViewHolder(Context context, ViewGroup parent, int viewType) {
        return new SubRankFragmentHolder(context,parent,this,viewType);
    }
}
