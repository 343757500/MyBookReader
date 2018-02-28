package com.zsp.mybookreader.mybookreader.ui.fragment;

import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.bean.RankIdBean;
import com.zsp.mybookreader.mybookreader.common.base.BaseFragment;
import com.zsp.mybookreader.mybookreader.common.base.IHttpService;
import com.zsp.mybookreader.mybookreader.ui.fragment.presenter.SubRankWeekPresenter;
import com.zsp.mybookreader.mybookreader.view.recycleview.adapter.SubRankFragmentAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public class SubRankFragmentMonth extends BaseFragment{
    private SubRankWeekPresenter subRankWeekPresenter;
    private SubRankFragmentAdapter subRankFragmentAdapter;
    private String mooth;
    private RecyclerView recyclerview;
    private SmartRefreshLayout refreshLayout;
    public SubRankFragmentMonth(String mooth){
        this.mooth=mooth;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    public void initView() {
        recyclerview = findView(R.id.recyclerview);
        refreshLayout = findView(R.id.refreshLayout);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                subRankWeekPresenter.getSubRankWeekBean(mooth);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        subRankWeekPresenter=new SubRankWeekPresenter(this);
        subRankWeekPresenter.getSubRankWeekBean(mooth);
    }

    @Override
    public void onClick(View v, int id) {

    }


    @Override
    public void onHttpSuccess(int reqType, Message obj) {
        super.onHttpSuccess(reqType, obj);
        if (reqType== IHttpService.TYPE_RANKID){
            RankIdBean rankIdBean = (RankIdBean) obj.obj;
            List<RankIdBean.RankingBean.BooksBean> books = rankIdBean.getRanking().getBooks();

            subRankFragmentAdapter = new SubRankFragmentAdapter(getActivity(),null);
            recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerview.setAdapter(subRankFragmentAdapter);
            subRankFragmentAdapter.setDatas(books);

            refreshLayout.finishRefresh(true);//传入false表示刷新失败
        }
    }

    @Override
    public void onHttpError(int reqType, String error) {
        super.onHttpError(reqType, error);
        refreshLayout.finishLoadmore(false);//传入false表示加载失败
    }
}
