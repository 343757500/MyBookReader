package com.zsp.mybookreader.mybookreader.view.recycleview.adapter.holder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.bean.FindBean;
import com.zsp.mybookreader.mybookreader.common.ui.BaseAdapterRV;
import com.zsp.mybookreader.mybookreader.common.ui.BaseHolderRV;
import com.zsp.mybookreader.mybookreader.ui.fragment.activity.SubjectBookListActivity;
import com.zsp.mybookreader.mybookreader.ui.fragment.activity.TopCategoryListActivity;
import com.zsp.mybookreader.mybookreader.ui.fragment.activity.TopRankActivity;

/**
 * Created by Administrator on 2018/1/29.
 */

public class FindHolder extends BaseHolderRV {

    private TextView tvTitle;
    private ImageView ivIcon;
    private RelativeLayout relativeLayout;

    public FindHolder(Context context, ViewGroup parent, BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_find);
    }

    @Override
    public void onFindViews(View itemView) {
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        ivIcon = (ImageView) itemView.findViewById(R.id.ivIcon);
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        FindBean findBean = (FindBean) bean;

        tvTitle.setText(findBean.getTitle());
        ivIcon.setImageResource(findBean.getIconResId());

    }

    @Override
    protected void onItemClick(View itemView, int position, Object bean) {
        super.onItemClick(itemView, position, bean);
        if (position==0){
            Intent intent=new Intent(context,TopRankActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            context.startActivity(intent);
        }else if (position==1){
            Intent intent=new Intent(context,TopCategoryListActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            context.startActivity(intent);
        }else{
            Intent intent=new Intent(context,SubjectBookListActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            context.startActivity(intent);
        }

    }
}
