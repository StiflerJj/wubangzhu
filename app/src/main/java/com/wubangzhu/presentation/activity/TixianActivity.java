package com.wubangzhu.presentation.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wubangzhu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TixianActivity extends BaseActivity {
    @BindView(R.id.tx_zfb)
    EditText tx_zfb;
    @BindView(R.id.tx_phone)
    EditText tx_phone;
    @BindView(R.id.tx_yzm)
    EditText tx_yzm;
    @BindView(R.id.txbtn_verifycode)
    Button txbtn_verifycode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_tixian);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {

    }
    private void initView(){
        setTitle("提现");
        setBackArrow();
        txbtn_verifycode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
