package com.zsp.mybookreader.mybookreader.ui.fragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zsp.mybookreader.mybookreader.R;
import com.zsp.mybookreader.mybookreader.common.base.BaseActivity;
import com.zsp.mybookreader.mybookreader.view.DrawableCenterButton;
import com.zsp.mybookreader.mybookreader.view.TagGroup;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/7.
 */

public class BookDetailActivity extends BaseActivity {
    @Bind(R.id.common_toolbar)
    Toolbar commonToolbar;
    @Bind(R.id.ivBookCover)
    ImageView ivBookCover;
    @Bind(R.id.tvBookListTitle)
    TextView tvBookListTitle;
    @Bind(R.id.tvBookListAuthor)
    TextView tvBookListAuthor;
    @Bind(R.id.tvCatgory)
    TextView tvCatgory;
    @Bind(R.id.tvWordCount)
    TextView tvWordCount;
    @Bind(R.id.tvLatelyUpdate)
    TextView tvLatelyUpdate;
    @Bind(R.id.btnJoinCollection)
    DrawableCenterButton btnJoinCollection;
    @Bind(R.id.btnRead)
    DrawableCenterButton btnRead;
    @Bind(R.id.tvLatelyFollower)
    TextView tvLatelyFollower;
    @Bind(R.id.tvRetentionRatio)
    TextView tvRetentionRatio;
    @Bind(R.id.tvSerializeWordCount)
    TextView tvSerializeWordCount;
    @Bind(R.id.tag_group)
    TagGroup tagGroup;
    @Bind(R.id.tvlongIntro)
    TextView tvlongIntro;
    @Bind(R.id.tvMoreReview)
    TextView tvMoreReview;
    @Bind(R.id.rvHotReview)
    RecyclerView rvHotReview;
    @Bind(R.id.tvCommunity)
    TextView tvCommunity;
    @Bind(R.id.tvHelpfulYes)
    TextView tvHelpfulYes;
    @Bind(R.id.rlCommunity)
    RelativeLayout rlCommunity;
    @Bind(R.id.tvRecommendBookList)
    TextView tvRecommendBookList;
    @Bind(R.id.rvRecommendBoookList)
    RecyclerView rvRecommendBoookList;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_book_detail;
    }

    @Override
    public void initView() {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String idd = intent.getStringExtra("IDD");
        Toast.makeText(getBaseContext(),idd,Toast.LENGTH_SHORT).show();
    }
}
