package com.wubangzhu.presentation.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.response.login.AllMyBiao;
import com.wubangzhu.domain.http.response.login.AllMyHistoryBiao;

import java.util.List;

public class MyHistoryBiaoAdapter extends BaseQuickAdapter<AllMyHistoryBiao.GuessjposBean, BaseViewHolder> {
    public MyHistoryBiaoAdapter(List<AllMyHistoryBiao.GuessjposBean> bean) {
        super(R.layout.item_historybiao, bean);
    }


    @Override
    protected void convert(BaseViewHolder helper, AllMyHistoryBiao.GuessjposBean item) {
        helper.setText(R.id.historybiao_text, item.getName()+"    竞猜编号："+item.getId());

    }
}
