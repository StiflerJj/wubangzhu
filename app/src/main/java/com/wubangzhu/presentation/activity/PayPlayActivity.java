package com.wubangzhu.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.YLClient;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllPayGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.presentation.widgets.CompletedBarView;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.NonNull;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PayPlayActivity extends AppCompatActivity {
    @BindView(R.id.img_payrulescroll)
    ScrollView imgPay;
    @BindView(R.id.goodname_pay)
    TextView goodname_pay;
    @BindView(R.id.goodinfo_pay)
    TextView goodinfo_pay;
    @BindView(R.id.yuanjiapay)
    TextView yuanjiapay;
    @BindView(R.id.goodprice_pay)
    TextView goodprice_pay;
    @BindView(R.id.jindupay)
    TextView jindupay;
    @BindView(R.id.jindubar)
    CompletedBarView barview;
    AllPayGoods.OurGuessesBean bean;
    MaterialDialog dialog;
    View inputView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payplay);
        ButterKnife.bind(this);
        bean = (AllPayGoods.OurGuessesBean) getIntent().getSerializableExtra("paygood");
        goodname_pay.setText(bean.getName());
        goodinfo_pay.setText(bean.getName());
        yuanjiapay.setText("原价:");
        goodprice_pay.setText("￥"+bean.getPrice());
        inputView = LayoutInflater.from(this).inflate(R.layout.view_guessinput, null);

//        barview.setProgressBar(50);
        jindupay.setText(bean.getBmrs()+"/"+bean.getTotal());
    }

    @Override
    protected void onResume() {
        super.onResume();
        barview.setProgressBar((int)(bean.getBmrs()*100/bean.getTotal()));
    }

    @OnClick({R.id.payrule,R.id.img_payrule,R.id.back_pay,R.id.payplay_btn}) void onclick(View v){
        switch (v.getId()){
            case R.id.payrule:
                imgPay.setVisibility(View.VISIBLE);
                break;
            case R.id.img_payrule:
                imgPay.setVisibility(View.GONE);
                break;
            case R.id.back_pay:
                finish();
                break;
            case R.id.payplay_btn:
                if (bean.getState()==1) {
                                    dialog = new MaterialDialog.Builder(this)
                                            .customView(inputView, false)
                                            .positiveText("确定")
                                            .negativeText("取消")
                                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                                @Override
                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                                    String initNumber = ((EditText) dialog.getCustomView().findViewById(R.id.input_guess)).getText().toString();
                                                    if(initNumber.length()==0){
                                                        ToastUtils.showShort(R.string.gameinfo_biao_content_null);
                                                        return;
                                                    }
                                                    new YLClient().postbaomingPay(ShareData.getShareStringData(ShareKeys.Login_UKEY),
                                                            ShareData.getShareIntData(ShareKeys.Login_UserId), bean.getId(), Integer.parseInt(initNumber),
                                                            new Callback2<BaseResponse>() {
                                                                @Override
                                                                public void onFailure(RetrofitError retrofitError) {

                                                                }

                                                                @Override
                                                                public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {

                                                                }
                                                            }


                                                    );
                                                }
                                            })
                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
                                                @Override
                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                                                }
                                            })
                                            .show();

                                } else {

                                }
                break;
            default:
                break;
        }

    }
}
