package com.zsp.mybookreader.mybookreader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zsp.mybookreader.mybookreader.common.base.BaseActivity;
import com.zsp.mybookreader.mybookreader.ui.fragment.RecommendFragment;
import com.zsp.mybookreader.mybookreader.ui.fragment.RecommendFragment1;
import com.zsp.mybookreader.mybookreader.ui.fragment.presenter.RecommendFragment2;
import com.zsp.mybookreader.mybookreader.view.RVPIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @Bind(R.id.common_toolbar)
    Toolbar commonToolbar;
    @Bind(R.id.indicator)
    RVPIndicator indicator;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private List<String> mDatas;
    private List<Fragment> mTabContents;
    private FragmentPagerAdapter mAdapter;


    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        mDatas = Arrays.asList(getResources().getStringArray(R.array.home_tabs));
        mTabContents = new ArrayList<>();
        mTabContents.add(new RecommendFragment());
        mTabContents.add(new RecommendFragment1());
        mTabContents.add(new RecommendFragment2());

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
        viewpager.setAdapter(mAdapter);
        indicator.setViewPager(viewpager, 0);
    }

    @Override
    public void onClick(View v, int id) {

    }

}
