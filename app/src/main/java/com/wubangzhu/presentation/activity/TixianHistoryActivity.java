package com.wubangzhu.presentation.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wubangzhu.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TixianHistoryActivity extends BaseActivity {
    @BindView(R.id.tx_list)
    RecyclerView tx_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_tixianhistory);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData() {

    }
    private void initView(){
        setTitle("提现明细");
        setBackArrow();

    }
}
