package com.wubangzhu.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.response.login.AllGoods;

import java.util.List;

public class FreeAdapter extends BaseQuickAdapter<AllGoods.ShopmodelsBean, BaseViewHolder> {

    public FreeAdapter(List<AllGoods.ShopmodelsBean> bean) {
        super(R.layout.item_free, bean);
    }


    @Override
    protected void convert(BaseViewHolder helper, AllGoods.ShopmodelsBean item) {
        helper.setText(R.id.free_goodname, item.getName());
        helper.addOnClickListener(R.id.free_biao);

    }
}
