package com.wubangzhu.presentation.activity;

import android.os.Bundle;

import com.wubangzhu.R;
import com.wubangzhu.util.CommonUtil;

import butterknife.OnClick;

public class RegistActivity extends BaseInfoActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_regist);
        setBackArrow();

    }
    @OnClick(R.id.btn_regist) void setTryit(){
        CommonUtil.showToast(this,"try it");
    }
}
