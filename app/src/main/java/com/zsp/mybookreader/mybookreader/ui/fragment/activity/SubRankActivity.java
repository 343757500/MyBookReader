package com.zsp.mybookreader.mybookreader.ui.fragment.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.common.base.BaseActivity;
import com.zsp.mybookreader.mybookreader.ui.fragment.RecommendFragment;
import com.zsp.mybookreader.mybookreader.ui.fragment.RecommendFragment1;
import com.zsp.mybookreader.mybookreader.ui.fragment.SubRankFragmentAll;
import com.zsp.mybookreader.mybookreader.ui.fragment.SubRankFragmentMonth;
import com.zsp.mybookreader.mybookreader.ui.fragment.SubRankFragmentWeek;
import com.zsp.mybookreader.mybookreader.ui.fragment.presenter.RecommendFragment2;
import com.zsp.mybookreader.mybookreader.view.RVPIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */

public class SubRankActivity extends BaseActivity{

    private ViewPager viewpagerSubRank;
    private List<String> mDatas;
    private List<Fragment> mTabContents;
    private FragmentPagerAdapter mAdapter;
    private RVPIndicator indicator;
    private String id;
    private String month;
    private String all;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_sub_rank;
    }

    @Override
    public void initView() {
        id = getIntent().getStringExtra("ID");
        month = getIntent().getStringExtra("MONTH");
        all = getIntent().getStringExtra("ALL");
        viewpagerSubRank = findView(R.id.viewpagerSubRank);
        indicator = findView(R.id.indicatorSubRank);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mDatas = Arrays.asList(getResources().getStringArray(R.array.sub_rank_tabs));
        mTabContents = new ArrayList<>();
        mTabContents.add(new SubRankFragmentWeek(id));
        mTabContents.add(new SubRankFragmentMonth(month));
        mTabContents.add(new SubRankFragmentAll(all));

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTabContents.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }
        };

        indicator.setTabItemTitles(mDatas);
        viewpagerSubRank.setAdapter(mAdapter);
        indicator.setViewPager(viewpagerSubRank, 0);
    }

    @Override
    public void onClick(View v, int id) {

    }
}
