package com.zsp.mybookreader.mybookreader.ui.fragment.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.bean.FindBean;
import com.zsp.mybookreader.mybookreader.common.base.BaseFragment;
import com.zsp.mybookreader.mybookreader.view.SupportDividerItemDecoration;
import com.zsp.mybookreader.mybookreader.view.recycleview.adapter.FindAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.zsp.mybookreader.mybookreader.common.base.Global.mContext;

/**
 * Created by Administrator on 2018/1/22.
 */

public class RecommendFragment2 extends BaseFragment {

    private RecyclerView mRecyclerView;
    private List<FindBean> mList = new ArrayList<>();
    private FindAdapter mAdapter;
    @Override
    public int getLayoutRes() {
        return  R.layout.fragment_recommend2;
    }

    @Override
    public void initView() {
        mRecyclerView = findView(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL, true));

        mAdapter = new FindAdapter(mContext,null);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setDatas(mList);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mList.clear();
        mList.add(new FindBean("排行榜", R.drawable.home_find_rank));
        mList.add(new FindBean("主题书单", R.drawable.home_find_topic));
        mList.add(new FindBean("分类", R.drawable.home_find_category));
    }

    @Override
    public void onClick(View v, int id) {

    }
}
