package com.zsp.mybookreader.mybookreader.ui.fragment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.bean.TopRankBean;
import com.zsp.mybookreader.mybookreader.common.base.BaseActivity;
import com.zsp.mybookreader.mybookreader.common.base.Const;
import com.zsp.mybookreader.mybookreader.common.base.IHttpService;
import com.zsp.mybookreader.mybookreader.ui.fragment.presenter.TopRankPresenter;
import com.zsp.mybookreader.mybookreader.utils.Utility;
import com.zsp.mybookreader.mybookreader.view.CustomExpandableListView;
import com.zsp.mybookreader.mybookreader.view.SupportDividerItemDecoration;
import com.zsp.mybookreader.mybookreader.view.listview.ElvFeMaleTrueAdapter;
import com.zsp.mybookreader.mybookreader.view.listview.ElvMaleTrueAdapter;
import com.zsp.mybookreader.mybookreader.view.recycleview.adapter.ElvFeMaleAdapter;
import com.zsp.mybookreader.mybookreader.view.recycleview.adapter.ElvMaleAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.zsp.mybookreader.mybookreader.common.base.Global.mContext;

/**
 * Created by Administrator on 2018/1/29.
 */

public class TopRankActivity extends BaseActivity {
    private RecyclerView elvMale;
    private RecyclerView elvFeMale;
    private TopRankPresenter topRankPresenter;
    private CustomExpandableListView elvMaleTrue;
    private CustomExpandableListView elvFeMaleTrue;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_top_rank;
    }

    @Override
    public void initView() {
        elvMale = findView(R.id.elvMale);
        elvFeMale = findView(R.id.elvFeMale);
        elvMaleTrue = findView(R.id.elvMaleTrue);
        elvFeMaleTrue = findView(R.id.elvFeMaleTrue);
        topRankPresenter = new TopRankPresenter(this);
        topRankPresenter.getTopRankBean();
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
        if (reqType== IHttpService.TYPE_TOPRANK){
            TopRankBean topRankBean = (TopRankBean) obj.obj;
            List<TopRankBean.EpubBean> epub = topRankBean.getEpub();
            List<TopRankBean.MaleBean> male = topRankBean.getMale();
            List<TopRankBean.FemaleBean> female = topRankBean.getFemale();
            List<TopRankBean.FemaleBean> femaleFalse = new ArrayList<>();
            List<TopRankBean.FemaleBean> femaleTrue = new ArrayList<>();

            List<TopRankBean.MaleBean> maleFalse = new ArrayList<>();
             List<TopRankBean.MaleBean> maleTrue = new ArrayList<>();

            for (int i = 0; i <male.size() ; i++) {
                if (male.get(i).isCollapse()){  //折叠
                    maleTrue.add(male.get(i));
                }else{
                    maleFalse.add(male.get(i));
                }
            }


            for (int i = 0; i < female.size(); i++) {
                if (female.get(i).isCollapse()){
                    femaleTrue.add(female.get(i));
                }else{
                    femaleFalse.add(female.get(i));
                }
            }






            final ElvMaleAdapter elvMaleAdapter=new ElvMaleAdapter(this,null);
            elvMale.setLayoutManager(new LinearLayoutManager(this));
            elvMale.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL, true));
            elvMale.setAdapter(elvMaleAdapter);
            elvMaleAdapter.setDatas(maleFalse);


            final ElvMaleTrueAdapter elvMaleTrueAdapter=new ElvMaleTrueAdapter(maleTrue,TopRankActivity.this);
            elvMaleTrue.setAdapter(elvMaleTrueAdapter);
            elvMaleTrue.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    List<TopRankBean.MaleBean> list = elvMaleTrueAdapter.getList();

                    if (list.get(childPosition).getMonthRank()==null){
                        Intent intent=new Intent(TopRankActivity.this,SubOtherHomeRankActivity.class);
                        TopRankActivity.this.startActivity(intent);
                    }else{
                        Intent intent=new Intent(TopRankActivity.this,SubRankActivity.class);
                        intent.putExtra("ID",list.get(childPosition).get_id());
                        intent.putExtra("MONTH",list.get(childPosition).getMonthRank());
                        intent.putExtra("ALL",list.get(childPosition).getTotalRank());
                        TopRankActivity.this.startActivity(intent);
                    }
                    return false;
                }
            });








            ElvFeMaleAdapter elvFeMaleAdapter=new ElvFeMaleAdapter(this,null);
            elvFeMale.setLayoutManager(new LinearLayoutManager(this));
            elvFeMale.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL, true));
            elvFeMale.setAdapter(elvFeMaleAdapter);
            elvFeMaleAdapter.setDatas(femaleFalse);



            final ElvFeMaleTrueAdapter elvFeMaleTrueAdapter=new ElvFeMaleTrueAdapter(femaleTrue,TopRankActivity.this);
            elvFeMaleTrue.setAdapter(elvFeMaleTrueAdapter);
            elvFeMaleTrue.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    List<TopRankBean.FemaleBean> list = elvFeMaleTrueAdapter.getList();
                    if (list.get(childPosition).getMonthRank()==null){
                        Intent intent=new Intent(TopRankActivity.this,SubOtherHomeRankActivity.class);
                        TopRankActivity.this.startActivity(intent);
                    }else{
                        Intent intent=new Intent(TopRankActivity.this,SubRankActivity.class);
                        intent.putExtra("ID",list.get(childPosition).get_id());
                        intent.putExtra("MONTH",list.get(childPosition).getMonthRank());
                        intent.putExtra("ALL",list.get(childPosition).getTotalRank());
                        TopRankActivity.this.startActivity(intent);
                    }
                    return false;
                }
            });

        }
    }

    @Override
    public void onHttpError(int reqType, String error) {
        super.onHttpError(reqType, error);
    }














}
