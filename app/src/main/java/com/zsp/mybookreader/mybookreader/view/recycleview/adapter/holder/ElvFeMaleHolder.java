package com.zsp.mybookreader.mybookreader.view.recycleview.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.bean.TopRankBean;
import com.zsp.mybookreader.mybookreader.common.base.Const;
import com.zsp.mybookreader.mybookreader.common.ui.BaseAdapterRV;
import com.zsp.mybookreader.mybookreader.common.ui.BaseHolderRV;
import com.zsp.mybookreader.mybookreader.ui.fragment.activity.SubOtherHomeRankActivity;
import com.zsp.mybookreader.mybookreader.ui.fragment.activity.SubRankActivity;

/**
 * Created by Administrator on 2018/2/1.
 */

public class ElvFeMaleHolder extends BaseHolderRV {

    private TextView tvRankGroupName;
    private ImageView ivRankCover;

    public ElvFeMaleHolder(Context context, ViewGroup parent, BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_top_rank_group);
    }

    @Override
    public void onFindViews(View itemView) {
        tvRankGroupName = (TextView) itemView.findViewById(R.id.tvRankGroupName);
        ivRankCover = (ImageView) itemView.findViewById(R.id.ivRankCover);
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        TopRankBean.FemaleBean maleBean = (TopRankBean.FemaleBean) bean;
        tvRankGroupName.setText(maleBean.getTitle());
        Glide.with(context).load(Const.IMG_BASE_URL+maleBean.getCover()).placeholder(R.drawable.avatar_default).into(ivRankCover);
    }

    @Override
    protected void onItemClick(View itemView, int position, Object bean) {
        super.onItemClick(itemView, position, bean);
        TopRankBean.FemaleBean maleBean = (TopRankBean.FemaleBean) bean;
        if (maleBean.getMonthRank()==null){
            Intent intent=new Intent(context,SubOtherHomeRankActivity.class);
            context.startActivity(intent);
        }else{
            Intent intent=new Intent(context,SubRankActivity.class);
            context.startActivity(intent);
        }
    }
}
