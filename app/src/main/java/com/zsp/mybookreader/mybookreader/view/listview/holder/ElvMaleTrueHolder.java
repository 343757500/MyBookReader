package com.zsp.mybookreader.mybookreader.view.listview.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.bean.TopRankBean;
import com.zsp.mybookreader.mybookreader.common.base.Const;
import com.zsp.mybookreader.mybookreader.common.base.Global;
import com.zsp.mybookreader.mybookreader.common.ui.BaseAdapterLV;
import com.zsp.mybookreader.mybookreader.common.ui.BaseHolderLV;

/**
 *
 * @author Administrator
 * @date 2018/2/1
 */

public class ElvMaleTrueHolder extends BaseHolderLV<TopRankBean.MaleBean> {
    private TextView tvRankGroupName;
    private ImageView ivRankCover;

    public ElvMaleTrueHolder(Context context, ViewGroup parent, BaseAdapterLV adapter, int position, TopRankBean.MaleBean bean) {
        super(context, parent, adapter, position, bean);
    }

    @Override
    public View onCreateView(Context context, ViewGroup parent) {
        View item = Global.inflate(R.layout.item_top_rank_group, parent);
        tvRankGroupName = (TextView) item.findViewById(R.id.tvRankGroupName);
        ivRankCover = (ImageView) item.findViewById(R.id.ivRankCover);
        return item;
    }

    @Override
    protected void onRefreshView(TopRankBean.MaleBean bean, int position) {
        tvRankGroupName.setText(bean.getTitle());
        Glide.with(context).load(Const.IMG_BASE_URL+bean.getCover()).placeholder(R.drawable.avatar_default).into(ivRankCover);
    }

}
