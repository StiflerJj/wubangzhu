package com.wubangzhu.presentation.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.wubangzhu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoneyInfoActivity extends BaseActivity{
    @BindView(R.id.balancevalue)
    TextView balanceValue;
    @BindView(R.id.totalvalue)
    TextView totalvalue;
    @BindView(R.id.tixianvalue)
    EditText tixianvalue;
    @BindView(R.id.txaccount)
    TextView txaccount;
    @BindView(R.id.zfbaccount)
    TextView zfbaccount;
    @BindView(R.id.fanscount)
    TextView fanscount;
    @BindView(R.id.bondacount)
    Button bondacount;
    @BindView(R.id.tx_btn)
    Button tx_btn;
    @BindView(R.id.tx_mx)
    TextView tx_mx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_moneyinfo);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {

    }
    private void initView(){
        setTitle("资金管理");
        setBackArrow();
        GetRightButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.startActivity(ZMLActivity.class);

            }
        });
        tx_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.startActivity(TixianActivity.class);
            }
        });
        tx_mx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.startActivity(TixianHistoryActivity.class);
            }
        });


    }

}
