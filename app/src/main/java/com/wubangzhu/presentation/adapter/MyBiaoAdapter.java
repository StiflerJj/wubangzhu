package com.wubangzhu.presentation.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllMyBiao;

import java.util.List;

public class MyBiaoAdapter extends BaseQuickAdapter<AllMyBiao.OurGuessesBean, BaseViewHolder> {
    public MyBiaoAdapter(List<AllMyBiao.OurGuessesBean> bean) {
        super(R.layout.item_ingbiao, bean);
    }


    @Override
    protected void convert(BaseViewHolder helper, AllMyBiao.OurGuessesBean item) {
        helper.setText(R.id.ingbiao_text, item.getName());
//                +"    竞猜编号："+item.getId());
        helper.addOnClickListener(R.id.ingbiao_btn);

    }
}
