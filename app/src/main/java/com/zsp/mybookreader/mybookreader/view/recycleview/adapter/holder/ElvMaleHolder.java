package com.zsp.mybookreader.mybookreader.view.recycleview.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
 * Created by Administrator on 2018/1/29.
 */

public class ElvMaleHolder extends BaseHolderRV {

    private TextView tvRankGroupName;
    private ImageView ivRankCover;

    public ElvMaleHolder(Context context, ViewGroup parent, BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_top_rank_group);
    }

    @Override
    public void onFindViews(View itemView) {
        tvRankGroupName = (TextView) itemView.findViewById(R.id.tvRankGroupName);
        ivRankCover = (ImageView) itemView.findViewById(R.id.ivRankCover);

    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        TopRankBean.MaleBean maleBean = (TopRankBean.MaleBean) bean;
        tvRankGroupName.setText(maleBean.getTitle());
        Glide.with(context).load(Const.IMG_BASE_URL+maleBean.getCover()).placeholder(R.drawable.avatar_default).into(ivRankCover);

    }

    @Override
    protected void onItemClick(View itemView, int position, Object bean) {
        super.onItemClick(itemView, position, bean);
        TopRankBean.MaleBean maleBean = (TopRankBean.MaleBean) bean;
        if (maleBean.getMonthRank()==null){
            Intent intent=new Intent(context,SubOtherHomeRankActivity.class);
            context.startActivity(intent);
        }else{
            Intent intent=new Intent(context,SubRankActivity.class);
            intent.putExtra("ID",maleBean.get_id());
            intent.putExtra("MONTH",maleBean.getMonthRank());
            intent.putExtra("ALL",maleBean.getTotalRank());
            context.startActivity(intent);
        }
    }
}
