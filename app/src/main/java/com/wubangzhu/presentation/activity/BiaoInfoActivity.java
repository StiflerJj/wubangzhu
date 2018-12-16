package com.wubangzhu.presentation.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.Callback3;
import com.wubangzhu.domain.http.api.login.GWClient;
import com.wubangzhu.domain.http.api.login.LoginClient;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.FIndAllGouWu;
import com.wubangzhu.domain.http.response.login.UserInfoResponse;
import com.wubangzhu.presentation.widgets.GlideImageLoader;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;
import com.youth.banner.Banner;

import org.json.JSONException;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class BiaoInfoActivity extends BaseActivity {
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
    @BindView(R.id.jia_gouwuinfo)
    Button btn_jia_gouwuinfo;
    @BindView(R.id.jian_gouwuinfo)
    Button btn_jian_gouwuinfo;
    @BindView(R.id.count_gouwuinfo)
    EditText editcount_gouwuinfo;
    FIndAllGouWu.GwshopmodelsBean goodinfo;
    int myAcount, myBcount;//我有几张AB卷
    int aCount, bCount;//此商品可使用AB卷几张
    int totalGoodCount = 1;//买几件商品
    double singleGoodValue;//单间商品价格
    double allGoodsValue;//所有购物车商品价格
    double allMyTicketsValue;//我所有使用的券的金额
    double totalPayMoney;//需要支付现金多少
    List<String> imgList;


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
        if (goodinfo != null) {
            imgList = new ArrayList<>();
            if (goodinfo.getPicture1() != null && goodinfo.getPicture1().length() > 0)
                imgList.add(goodinfo.getPicture1());
            if (goodinfo.getPicture2() != null && goodinfo.getPicture2().length() > 0)
                imgList.add(goodinfo.getPicture2());
            if (goodinfo.getPicture3() != null && goodinfo.getPicture3().length() > 0)
                imgList.add(goodinfo.getPicture3());
            banner.setImageLoader(new GlideImageLoader());
            banner.setImages(imgList);
            banner.start();
            allGoodsValue = goodinfo.getPirce();
            totalPayMoney = allGoodsValue;
        }
        new LoginClient().postFindUser(ShareData.getShareStringData(ShareKeys.Login_UKEY), ShareData.getShareIntData(ShareKeys.Login_UserId),
                new Callback3<UserInfoResponse>() {
                    @Override
                    public void onFailure(RetrofitError retrofitError) {

                    }

                    @Override
                    public void onSuccess(UserInfoResponse response, Response response2) throws InterruptedException, JSONException {

                        if (response != null && response.getUser() != null) {
                            myAcount = response.getUser().getXa();
                            myBcount = response.getUser().getXb();
                            mytickets_gouwuinfo.setText("A卷剩余 " + myAcount + "张        " + "B卷剩余 " + myBcount + "张");
                        }
                    }
                });
    }

    void initView() {
        setBackArrow();
        if (goodinfo != null) {
            setTitle(goodinfo.getName());
            onTicketAChanged();
            onTicketBChanged();
            title_gouwuinfo.setText(goodinfo.getName());
            info_gouwuinfo.setText(goodinfo.getName());
            price_gouwuinfo.setText("单价 ￥" + goodinfo.getPirce() + "元");
            singleGoodValue = goodinfo.getPirce();
            needToPay(singleGoodValue);
            editcount_gouwuinfo.setText(totalGoodCount + "");
            aCount = goodinfo.getXa();
            bCount = goodinfo.getXb();
            ticketusecount_gouwuinfo.setText("本商品可使用A卷 " + goodinfo.getXa() + "张，可抵现金" + new DecimalFormat("#.0").format(goodinfo.getXa() * 1.1) + "元"
                    + "\r\n本商品可使用B卷 " + goodinfo.getXb() + "张，可抵现金" + new DecimalFormat("#.0").format(goodinfo.getXb() * 1.3) + "元");
            btn_jia_gouwuinfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    totalGoodCount++;
                    allGoodsValue = totalGoodCount*singleGoodValue;
                    editcount_gouwuinfo.setText(totalGoodCount + "");
                    totalPayMoney = totalGoodCount * singleGoodValue-allMyTicketsValue;
                    needToPay(totalPayMoney);

                }
            });
            btn_jian_gouwuinfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (totalGoodCount == 1)
                        return;
                    totalGoodCount--;
                    allGoodsValue = totalGoodCount*singleGoodValue;
                    editcount_gouwuinfo.setText(totalGoodCount + "");
                    totalPayMoney = totalGoodCount * singleGoodValue-allMyTicketsValue;
                    needToPay(totalPayMoney);
                }
            });

            btn_purchase_gouwuinfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int useA,useB;
                    if (ticketacountuse_gouwuinfo.getText().toString().equals(""))
                        useA = 0;
                    else
                        useA = Integer.parseInt(ticketacountuse_gouwuinfo.getText().toString());

                    if (ticketbcountuse_gouwuinfo.getText().toString().equals(""))
                        useB = 0;
                    else
                        useB = Integer.parseInt(ticketbcountuse_gouwuinfo.getText().toString());

                    if (myAcount < useA || myBcount < useB) {
                        LogUtils.e(myAcount+" "+aCount+" "+myBcount+" "+bCount);
                        ToastUtils.showLong(R.string.shopping_ticketnotenough);
                        return;
                    }
                    new GWClient().postgwBuy(ShareData.getShareStringData(ShareKeys.Login_UKEY),ShareData.getShareIntData(ShareKeys.Login_UserId), goodinfo.getId(), totalGoodCount, useA,
                            useB, totalPayMoney, new Callback2<BaseResponse>() {
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
        checkbox_gouwuinfo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ticketacountuse_gouwuinfo.setEnabled(false);
                    ticketbcountuse_gouwuinfo.setEnabled(false);
                    if (myAcount > aCount) {
                        ticketacountuse_gouwuinfo.setText(aCount+"");
                    } else {
                        ticketacountuse_gouwuinfo.setText(myAcount+"");
                    }
                    if (myBcount > bCount) {
                        ticketbcountuse_gouwuinfo.setText(bCount+"");
                    } else {
                        ticketbcountuse_gouwuinfo.setText(myBcount+"");
                    }
                    totalPayMoney = allGoodsValue - (Integer.parseInt(ticketacountuse_gouwuinfo.getText().toString()) * 1.1 +
                            Integer.parseInt(ticketbcountuse_gouwuinfo.getText().toString()) * 1.3);
                    needToPay(totalPayMoney);
                } else {
                    ticketacountuse_gouwuinfo.setEnabled(true);
                    ticketbcountuse_gouwuinfo.setEnabled(true);
                }
            }
        });

    }

    void needToPay(double money) {
        purchase_gouwuinfo.setText("还需支付： " + money + "元");
    }
    void onTicketAChanged(){
        ticketacountuse_gouwuinfo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                double avalue,bvalue;
                if(ticketacountuse_gouwuinfo.getText().toString().equals(""))
                    avalue = 0;
                else
                    avalue = Integer.parseInt(ticketacountuse_gouwuinfo.getText().toString());
                if(ticketbcountuse_gouwuinfo.getText().toString().equals(""))
                    bvalue = 0;
                else
                    bvalue = Integer.parseInt(ticketbcountuse_gouwuinfo.getText().toString());
                allMyTicketsValue = avalue*1.1+bvalue*1.3;
                totalPayMoney = allGoodsValue-allMyTicketsValue;
                needToPay(totalPayMoney);
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
    }
    void onTicketBChanged(){
        ticketbcountuse_gouwuinfo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                double avalue,bvalue;
                if(ticketacountuse_gouwuinfo.getText().toString().equals(""))
                    avalue = 0;
                else
                    avalue = Integer.parseInt(ticketacountuse_gouwuinfo.getText().toString());
                if(ticketbcountuse_gouwuinfo.getText().toString().equals(""))
                    bvalue = 0;
                else
                    bvalue = Integer.parseInt(ticketbcountuse_gouwuinfo.getText().toString());
                allMyTicketsValue = avalue*1.1+bvalue*1.3;
                totalPayMoney = allGoodsValue-allMyTicketsValue;
                needToPay(totalPayMoney);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
