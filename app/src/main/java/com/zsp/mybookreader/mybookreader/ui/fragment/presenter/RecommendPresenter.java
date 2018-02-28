package com.zsp.mybookreader.mybookreader.ui.fragment.presenter;

import com.zsp.mybookreader.mybookreader.common.base.BasePresenter;
import com.zsp.mybookreader.mybookreader.common.base.BaseView;

/**
 * Created by Administrator on 2018/1/22.
 */

public class RecommendPresenter extends BasePresenter{
    public RecommendPresenter(BaseView baseView) {
        super(baseView);
    }


    public void getRecommend(String sex){
        mProtocol.getRecommend(sex,mBaseCallback);
    }
}
