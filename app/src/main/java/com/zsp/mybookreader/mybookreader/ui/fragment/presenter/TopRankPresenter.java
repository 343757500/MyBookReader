package com.zsp.mybookreader.mybookreader.ui.fragment.presenter;

import com.zsp.mybookreader.mybookreader.common.base.BasePresenter;
import com.zsp.mybookreader.mybookreader.common.base.BaseView;

/**
 * Created by Administrator on 2018/1/29.
 */

public class TopRankPresenter extends BasePresenter {

    public TopRankPresenter(BaseView baseView) {
        super(baseView);
    }


    public void getTopRankBean(){
        mProtocol.getTopRankBean(mBaseCallback);
    }
}
