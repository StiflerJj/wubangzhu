package com.wubangzhu.presentation.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.FIndAllGouWu;

import java.util.List;

public class BuyAdapter extends BaseQuickAdapter<FIndAllGouWu.GwshopmodelsBean, BaseViewHolder> {
    Context mCon;
    public BuyAdapter(Context context,List<FIndAllGouWu.GwshopmodelsBean> bean) {
        super(R.layout.item_gouwu, bean);
        mCon = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, FIndAllGouWu.GwshopmodelsBean item) {
        helper.setText(R.id.title_gouwu, item.getName());
        helper.setText(R.id.price_gouwu, "￥ "+item.getPirce());
        helper.setText(R.id.info_gouwu, item.getName());
        helper.setText(R.id.info_ticketcount, "1.1代金券"+item.getXa()+"张,1.3代金券"+item.getXb()+"张  可省");
        helper.setText(R.id.info_cheapmoney, "￥"+(item.getXa()*1.1+item.getXb()*1.3));
        Glide.with(mContext).load(item.getPicture()).into((ImageView) helper.itemView.findViewById(R.id.img_gouwu));

        helper.addOnClickListener(R.id.btnbuy_gouwu);

    }

}
