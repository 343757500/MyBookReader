package com.zsp.mybookreader.mybookreader.bean;

/**
 * Created by Administrator on 2018/1/29.
 */

public class FindBean {
    private String title;
    private int iconResId;

    public FindBean(String title, int home_find_rank) {
        this.title=title;
        this.iconResId=home_find_rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }
}
