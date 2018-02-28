package com.zsp.mybookreader.mybookreader.common.base;

import android.app.Application;


import org.xutils.x;

/**
 * 应用程序上下文对象，常作一些初始化操作
 *
 * @author WJQ
 */
public class MyApp extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		Global.init(this);


		//初始化xutils3框架
		x.Ext.init(this);
	}
}
