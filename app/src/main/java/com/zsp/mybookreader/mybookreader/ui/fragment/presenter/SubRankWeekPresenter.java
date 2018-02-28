package com.zsp.mybookreader.mybookreader.ui.fragment.presenter;

import com.zsp.mybookreader.mybookreader.common.base.BasePresenter;
import com.zsp.mybookreader.mybookreader.common.base.BaseView;

/**
 * Created by Administrator on 2018/2/2.
 */

public class SubRankWeekPresenter extends BasePresenter{

    public SubRankWeekPresenter(BaseView baseView) {
        super(baseView);
    }


    public void getSubRankWeekBean(String id){
        mProtocol.getRankWeek(id,mBaseCallback);
    }
}
