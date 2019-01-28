package com.wubangzhu.presentation.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllPayGoods;

import java.util.List;

public class PayAdapter extends BaseQuickAdapter<AllPayGoods.OurGuessesBean, BaseViewHolder> {

    public PayAdapter(List<AllPayGoods.OurGuessesBean> bean) {
        super(R.layout.item_grid, bean);
    }


    @Override
    protected void convert(BaseViewHolder helper, AllPayGoods.OurGuessesBean item) {
        helper.setText(R.id.txt_good, item.getName());
        Glide.with(mContext).load(item.getPicture()).into((ImageView) helper.itemView.findViewById(R.id.img_good));
        helper.addOnClickListener(R.id.btn_good);
    }
}
