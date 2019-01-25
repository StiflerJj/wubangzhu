package com.wubangzhu.presentation.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wubangzhu.R;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZMLActivity extends BaseActivity{
    @BindView(R.id.zml_username)
    TextView zmlUsername;
    @BindView(R.id.fenxiang_txt)
    TextView fenxiang_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_zhaomuling);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {
    }
    private void initView() {
        setTitle("招募令");
        setBackArrow();
        zmlUsername.setText(ShareData.getShareIntData(ShareKeys.Login_UserId)+"");
        fenxiang_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
