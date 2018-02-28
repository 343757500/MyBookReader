package com.zsp.mybookreader.mybookreader.ui.fragment;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuyh.easyadapter.recyclerview.EasyRVAdapter;
import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.bean.RecommendBean;
import com.zsp.mybookreader.mybookreader.common.base.BaseFragment;
import com.zsp.mybookreader.mybookreader.common.base.IHttpService;
import com.zsp.mybookreader.mybookreader.ui.fragment.presenter.RecommendPresenter;
import com.zsp.mybookreader.mybookreader.view.recycleview.adapter.RecommendAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/1/22.
 */

public class RecommendFragment extends BaseFragment {
    @Bind(R.id.llBatchManagement)
    LinearLayout llBatchManagement;
    private ArrayList<RecommendBean> list;
    private RecyclerView recycleview;
    private TextView tvSelectAll;
    private TextView tvDelete;
    private LinearLayout llBatchManagement1;
    private RecommendPresenter recommendPresenter;
    private RecommendBean recommendBean;


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initView() {
        recycleview = findView(R.id.recycleview);
        tvSelectAll = findView(R.id.tvSelectAll);
        tvDelete = findView(R.id.tvDelete);
        llBatchManagement1 = findView(R.id.llBatchManagement);

        recommendPresenter = new RecommendPresenter(this);
        recommendPresenter.getRecommend("male");

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {

    }

    @Override
    public void onHttpSuccess(int reqType, Message obj) {
        super.onHttpSuccess(reqType, obj);
        if (reqType== IHttpService.TYPE_RECOMMEND){
            recommendBean = (RecommendBean) obj.obj;
            List<RecommendBean.BooksBean> books = recommendBean.getBooks();



            recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
            RecommendAdapter recommendAdapter = new RecommendAdapter(getContext(),null);

            recycleview.setAdapter(recommendAdapter);
            recommendAdapter.setDatas(books);
        }

    }

    @Override
    public void onHttpError(int reqType, String error) {
        super.onHttpError(reqType, error);
    }
}
