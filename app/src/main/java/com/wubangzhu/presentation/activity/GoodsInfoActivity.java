package com.wubangzhu.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.Callback3;
import com.wubangzhu.domain.http.api.login.GWClient;
import com.wubangzhu.domain.http.api.login.LoginClient;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.FIndAllGouWu;
import com.wubangzhu.domain.http.response.login.UserInfoResponse;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;
import com.youth.banner.Banner;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class GoodsInfoActivity extends BaseActivity {
    @BindView(R.id.banber_goodinfo)
    Banner banner;
    @BindView(R.id.title_gouwuinfo)
    TextView title_gouwuinfo;
    @BindView(R.id.info_gouwuinfo)
    TextView info_gouwuinfo;
    @BindView(R.id.price_gouwuinfo)
    TextView price_gouwuinfo;
    @BindView(R.id.ticketusecount_gouwuinfo)
    TextView ticketusecount_gouwuinfo;
    @BindView(R.id.ticketacountuse_gouwuinfo)
    EditText ticketacountuse_gouwuinfo;
    @BindView(R.id.ticketbcountuse_gouwuinfo)
    EditText ticketbcountuse_gouwuinfo;
    @BindView(R.id.checkbox_gouwuinfo)
    CheckBox checkbox_gouwuinfo;
    @BindView(R.id.mytickets_gouwuinfo)
    TextView mytickets_gouwuinfo;
    @BindView(R.id.purchase_gouwuinfo)
    TextView purchase_gouwuinfo;
    @BindView(R.id.btn_purchase_gouwuinfo)
    Button btn_purchase_gouwuinfo;
    FIndAllGouWu.GwshopmodelsBean goodinfo;
    int mAcount, mBcount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_goodsinfo);
        ButterKnife.bind(this);
        goodinfo = (FIndAllGouWu.GwshopmodelsBean) getIntent().getSerializableExtra("good");
        initData();
        initView();
    }

    private void initData() {
//        new GWClient
        new LoginClient().postFindUser(ShareData.getShareStringData(ShareKeys.Login_UKEY), ShareData.getShareIntData(ShareKeys.Login_UserId),
                new Callback3<UserInfoResponse>() {
                    @Override
                    public void onFailure(RetrofitError retrofitError) {

                    }

                    @Override
                    public void onSuccess(UserInfoResponse response, Response response2) throws InterruptedException, JSONException {

                        if (response != null && response.getUser() != null) {
                            mAcount = response.getUser().getXa();
                            mBcount = response.getUser().getXb();
                        }
                    }
                });
    }

    void initView() {
        setBackArrow();
        if (goodinfo != null) {
            setTitle(goodinfo.getName());
            title_gouwuinfo.setText(goodinfo.getName());
            info_gouwuinfo.setText(goodinfo.getName());
            price_gouwuinfo.setText("￥" + goodinfo.getPirce() + "");
            ticketusecount_gouwuinfo.setText("本商品可使用A卷 " + goodinfo.getXa() + "张，可抵现金" + goodinfo.getXa() * 1.1 + "元"
                    + "\r\n本商品可使用B卷 " + goodinfo.getXb() + "张，可抵现金" + goodinfo.getXb() * 1.3 + "元");
            mytickets_gouwuinfo.setText("A卷剩余 " + goodinfo.getXa() + "张        " + "B卷剩余 " + goodinfo.getXb() + "张");
            purchase_gouwuinfo.setText("还需支付： " + 2222 + "元");

            btn_purchase_gouwuinfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int aCount, bCount;
                    if (ticketacountuse_gouwuinfo.getText().toString().equals(""))
                        aCount = 0;
                    else
                        aCount = Integer.parseInt(ticketacountuse_gouwuinfo.getText().toString());

                    if (ticketbcountuse_gouwuinfo.getText().toString().equals(""))
                        bCount = 0;
                    else
                        bCount = Integer.parseInt(ticketbcountuse_gouwuinfo.getText().toString());

                    if (mAcount < aCount || mBcount < bCount) {
                        ToastUtils.showLong(R.string.shopping_ticketnotenough);
                        return;
                    }
                    new GWClient().postgwBuy(ShareData.getShareStringData(ShareKeys.Login_UKEY), goodinfo.getId(), 2222, aCount,
                            bCount, 2222.22, new Callback2<BaseResponse>() {
                                @Override
                                public void onFailure(RetrofitError retrofitError) {

                                }

                                @Override
                                public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {

                                }
                            });
                }
            });

        }

    }
}
