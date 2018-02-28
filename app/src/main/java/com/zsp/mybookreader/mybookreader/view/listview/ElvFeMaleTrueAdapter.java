package com.zsp.mybookreader.mybookreader.view.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.bean.TopRankBean;
import com.zsp.mybookreader.mybookreader.common.base.Const;

import java.util.List;

/**
 * Created by Administrator on 2018/2/1.
 */

public class ElvFeMaleTrueAdapter extends BaseExpandableListAdapter {

    private  List<TopRankBean.FemaleBean> maleTrue;
    private Activity context;



    public ElvFeMaleTrueAdapter(List<TopRankBean.FemaleBean> maleTrue, Activity context){
        this.maleTrue=maleTrue;
        this.context=context;
    }


    public List<TopRankBean.FemaleBean> getList(){
        return maleTrue;
    }


    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return maleTrue.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return maleTrue.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = context.getLayoutInflater().inflate(R.layout.item_top_rank_group, null);

        } else {

        }
        TextView tvRankGroupName = (TextView) convertView.findViewById(R.id.tvRankGroupName);
        tvRankGroupName.setText("别人家的榜单");
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            convertView =  LayoutInflater.from(context).inflate(R.layout.item_top_rank_group, parent,false);
            TextView tvRankGroupName = (TextView) convertView.findViewById(R.id.tvRankGroupName);
            ImageView ivRankCover = (ImageView) convertView.findViewById(R.id.ivRankCover);
            tvRankGroupName.setText(maleTrue.get(childPosition).getTitle());
            Glide.with(context).load(Const.IMG_BASE_URL + maleTrue.get(childPosition).getCover()).placeholder(R.drawable.avatar_default).into(ivRankCover);

              return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
