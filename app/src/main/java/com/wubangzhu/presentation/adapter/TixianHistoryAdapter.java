package com.wubangzhu.presentation.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.response.login.GoodHistoryLIst;

import java.util.List;

public class TixianHistoryAdapter extends BaseQuickAdapter<GoodHistoryLIst.GwhistorysBean, BaseViewHolder> {
    Context mCon;
    public TixianHistoryAdapter(Context context, List<GoodHistoryLIst.GwhistorysBean> bean) {
        super(R.layout.item_txhistory, bean);
        mCon = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, GoodHistoryLIst.GwhistorysBean item) {
        helper.setText(R.id.tx_time, item.getName());
        helper.setText(R.id.tx_value, "￥ "+item.getPrice());
        helper.setText(R.id.tx_state, item.getPaytime()+"");
        helper.setText(R.id.tx_ordernum, item.getPaytime()+"");

    }

}
