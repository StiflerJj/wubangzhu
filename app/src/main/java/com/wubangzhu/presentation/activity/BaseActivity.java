package com.wubangzhu.presentation.activity;

import android.support.v7.app.AppCompatActivity;

import com.wubangzhu.util.HandleBackUtil;

public class BaseActivity extends BaseInfoActivity {
    @Override
    public void onBackPressed() {
        if (!HandleBackUtil.handleBackPress(this)) {
            super.onBackPressed();
        }
    }
}
