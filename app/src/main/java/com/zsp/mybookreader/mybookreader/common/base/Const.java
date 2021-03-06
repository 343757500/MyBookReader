package com.zsp.mybookreader.mybookreader.common.base;

public class Const {

	public static final String HOST_IP = "api.zhuishushenqi.com/";

    public static final String IMG_BASE_URL = "http://statics.zhuishushenqi.com";
//	public static final String HOST_IP = "45.78.29.236";
    public static final String KEY_BEAN =  "data";
    public static final String KEY_FRAGMENT2 =  "data2";
    public static final String KEY_CART_GOODS =  "cart_goods";

    /** 请求码：主界面 */
    public static final int REQUEST_CODE_MAIN_UI = 0;
    public static final int REQUEST_CODE_MINE = 1;
    public static final int REQUEST_CODE_SHOP_DETAIL = 2;
    public static final int REQUEST_CODE_CONFIRM_ORDER = 3;
    public static final int REQUEST_CODE_ADDRESS_LIST = 4;

    public static final String SP_TOKEN =  "token";
    public static final String SP_USER_NAME = "username";
    public static final String SP_DEFAULT_ADDRESS = "address";


    /** 下拉刷新 */
    public static int TYPE_REFRESH = 1;
    /** 加载更多 */
    public static final int TYPE_LOAD_MORE = 0;

    public static int TYPE_UPDATE_ORDER_STATUS = 100;
    public static int TYPE_UPDATE_RIDER_POSITION = 101;
}
