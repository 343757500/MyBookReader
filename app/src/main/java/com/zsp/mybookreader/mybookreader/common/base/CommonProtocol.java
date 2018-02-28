package com.zsp.mybookreader.mybookreader.common.base;


import com.zsp.mybookreader.mybookreader.bean.RankIdBean;
import com.zsp.mybookreader.mybookreader.bean.RecommendBean;
import com.zsp.mybookreader.mybookreader.bean.TopRankBean;

/**
 * 网络请求
 *
 * @author WJQ
 */
public class CommonProtocol extends BaseProtocol {

 /** 创建订单 */
    public void getRecommend(String sex,final OnHttpCallback callback) {
        super.execute(super.getHttpService().getRecommend(sex),
                callback, IHttpService.TYPE_RECOMMEND, RecommendBean.class);
    }


    public void getTopRankBean(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getTopRank(),
                callback, IHttpService.TYPE_TOPRANK, TopRankBean.class);
    }

    public void getRankWeek(String id,final OnHttpCallback callback) {
        super.execute(super.getHttpService().getRankWeek(id),
                callback, IHttpService.TYPE_RANKID, RankIdBean.class);
    }


    public void getBookDetialId(String id,final OnHttpCallback callback) {
        super.execute(super.getHttpService().getBookDetialId(id),
                callback, IHttpService.TYPE_FRAGMENT2, RankIdBean.class);
    }



}
