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
import com.zsp.mybookreader.mybookreader.bean.RankIdBean;
import com.zsp.mybookreader.mybookreader.common.base.Const;
import com.zsp.mybookreader.mybookreader.common.ui.BaseAdapterRV;
import com.zsp.mybookreader.mybookreader.common.ui.BaseHolderRV;
import com.zsp.mybookreader.mybookreader.ui.fragment.activity.BookDetailActivity;

/**
 * Created by Administrator on 2018/2/2.
 */

public class SubRankFragmentHolder extends BaseHolderRV<RankIdBean.RankingBean.BooksBean> {

    private ImageView ivSubCateCover;
    private TextView tvSubCateShort;
    private TextView tvSubCateMsg;
    private TextView tvSubCateTitle;
    private TextView tvSubCateAuthor;

    public SubRankFragmentHolder(Context context, ViewGroup parent, BaseAdapterRV<RankIdBean.RankingBean.BooksBean> adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_sub_category_list);
    }

    @Override
    public void onFindViews(View itemView) {
        ivSubCateCover = (ImageView) itemView.findViewById(R.id.ivSubCateCover);
        tvSubCateTitle = (TextView) itemView.findViewById(R.id.tvSubCateTitle);
        tvSubCateMsg = (TextView) itemView.findViewById(R.id.tvSubCateMsg);
        tvSubCateShort = (TextView) itemView.findViewById(R.id.tvSubCateShort);
        tvSubCateAuthor = (TextView) itemView.findViewById(R.id.tvSubCateAuthor);

    }

    @Override
    protected void onRefreshView(RankIdBean.RankingBean.BooksBean bean, int position) {
        Glide.with(context).load(Uri.parse(Const.IMG_BASE_URL+bean.getCover())).into(ivSubCateCover);
        tvSubCateShort.setText(bean.getShortIntro());
        tvSubCateTitle.setText(bean.getTitle());
        tvSubCateMsg.setText(bean.getLatelyFollower()+"人在追  |  "+bean.getRetentionRatio()+"%读者留存");
        tvSubCateAuthor.setText(bean.getAuthor());
    }


    @Override
    protected void onItemClick(View itemView, int position, RankIdBean.RankingBean.BooksBean bean) {
        super.onItemClick(itemView, position, bean);
        String id = bean.get_id();
        Intent intent = new Intent(context,BookDetailActivity.class);
        intent.putExtra("IDD",id);
        context.startActivity(intent);
    }
}
