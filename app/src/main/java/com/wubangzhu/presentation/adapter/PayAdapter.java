package com.wubangzhu.presentation.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllPayGoods;

import java.util.List;

public class PayAdapter extends BaseQuickAdapter<AllPayGoods.OurGuessesBean, BaseViewHolder> {

    public PayAdapter(List<AllPayGoods.OurGuessesBean> bean) {
        super(R.layout.item_free, bean);
    }


    @Override
    protected void convert(BaseViewHolder helper, AllPayGoods.OurGuessesBean item) {
        helper.setText(R.id.free_goodname, item.getName());
        helper.addOnClickListener(R.id.free_biao);

    }
}
