package com.wubangzhu;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.wubangzhu.util.ShareData;

public class QiangApp extends Application{
    public static final long GAME_DURATION = 30*1000;
    @Override
    public void onCreate() {
        super.onCreate();
        ShareData.init(this);
        Utils.init(this);

    }
}
