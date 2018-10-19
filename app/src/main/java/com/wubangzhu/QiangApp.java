package com.wubangzhu;

import android.app.Application;

import com.wubangzhu.util.ShareData;

public class QiangApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ShareData.init(this);
    }
}
