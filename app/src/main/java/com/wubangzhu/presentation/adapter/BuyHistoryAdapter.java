package com.wubangzhu.presentation.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.response.login.GoodHistoryLIst;

import java.util.List;

public class BuyHistoryAdapter extends BaseQuickAdapter<GoodHistoryLIst.GwhistorysBean, BaseViewHolder> {
    Context mCon;
    public BuyHistoryAdapter(Context context, List<GoodHistoryLIst.GwhistorysBean> bean) {
        super(R.layout.item_gouwulishi, bean);
        mCon = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, GoodHistoryLIst.GwhistorysBean item) {
        helper.setText(R.id.title_gouwu, item.getName());
        helper.setText(R.id.price_gouwu, "￥ "+item.getPrice());
        helper.setText(R.id.info_gouwu, item.getPaytime()+"");
        Glide.with(mContext).load(item.getPicture()).into((ImageView) helper.itemView.findViewById(R.id.img_gouwu));

    }

}
