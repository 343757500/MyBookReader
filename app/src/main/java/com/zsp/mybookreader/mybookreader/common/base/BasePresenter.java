package com.zsp.mybookreader.mybookreader.common.base;

import android.os.Message;



/**
 * @author WJQ
 */
public class BasePresenter {
    // Model层
    public CommonProtocol mProtocol;
    // View层
    public BaseView baseView;

    public BasePresenter(BaseView baseView) {
        this.baseView = baseView;
        mProtocol = new CommonProtocol();
    }

    public BaseProtocol.OnHttpCallback mBaseCallback
            = new BaseProtocol.OnHttpCallback() {
        @Override
        public void onHttpSuccess(int reqType, Message obj) {
            // P层 调用 V层
            baseView.onHttpSuccess(reqType, obj);
        }

        @Override
        public void onHttpError(int reqType, String error) {
            baseView.onHttpError(reqType, error);
        }
    };
}
