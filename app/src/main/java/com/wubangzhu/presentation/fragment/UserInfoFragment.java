package com.wubangzhu.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.StringUtils;
import com.tsy.sdk.pay.alipay.Alipay;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.Callback3;
import com.wubangzhu.domain.http.api.login.LoginClient;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.UserInfoResponse;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;
import com.zhou.zhoulib.util.Const;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UserInfoFragment extends BaseFragment {
    @BindView(R.id.info_avatar)
    ImageView mAvatar;
    @BindView(R.id.info_phone)
    TextView mPhone;
    @BindView(R.id.info_tgid)
    TextView mTgid;
    @BindView(R.id.info_ticketA)
    TextView mTicketA;
    @BindView(R.id.info_ticketB)
    TextView mTicketB;
    @BindView(R.id.info_totalincome)
    TextView mTotalIncome;
    @BindView(R.id.info_dayincome)
    TextView mDayIncome;
    @BindView(R.id.info_totalpeople)
    TextView mTotalPeople;
    @BindView(R.id.info_daypeople)
    TextView mDayPeople;
    @BindView(R.id.info_tgbtn)
    Button mTgbtn;
    @BindView(R.id.info_buytiket)
    Button mBuybtn;
    @BindView(R.id.info_waitbiao)
    RecyclerView mWaitBiao;
    @BindView(R.id.info_zhongbiao)
    RecyclerView mZhongBiao;
    @BindView(R.id.info_buyhistorylist)
    RecyclerView mBuyHistory;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_userinfo, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        initData();

        return rootView;
    }

    private void initView() {

    }

    private void initData() {
        new LoginClient().postFindUser(ShareData.getShareStringData(ShareKeys.Login_UKEY),
                ShareData.getShareIntData(ShareKeys.Login_UserId), new Callback3<UserInfoResponse>() {
                    @Override
                    public void onFailure(RetrofitError retrofitError) {

                    }

                    @Override
                    public void onSuccess(UserInfoResponse response, Response response2) throws InterruptedException, JSONException {

                        if (response != null && response.getCode() == 0) {
                            UserInfoResponse.UserBean userBean = response.getUser();
                            if (userBean != null) {
                                mPhone.setText(userBean.getName());
                                if (!StringUtils.isEmpty(userBean.getTgname()+"")) {
                                    mTgbtn.setVisibility(View.GONE);
                                    mTgid.setText(response.getUser().getTgname() + "");
                                }
                            }

                        }


                    }
                });
    }

    @OnClick({R.id.info_tgbtn, R.id.info_buytiket})
    void btnClick(View v) {
        if (v == mTgbtn) {
            new LoginClient().postgoToTg(ShareData.getShareStringData(ShareKeys.Login_UKEY), ShareData.getShareIntData(ShareKeys.Login_UserId),
                    new Callback2<BaseResponse>() {
                        @Override
                        public void onFailure(RetrofitError retrofitError) {

                        }

                        @Override
                        public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {

                            if (response != null && response.getCode() == 0) {
                                mTgid.setText(response.getMessage());
                                mTgbtn.setVisibility(View.GONE);
                            }
                        }
                    });

        } else {


        }
    }

    /**
     * 支付宝支付
     * @param pay_param 支付服务生成的支付参数
     */
    private void doAlipay(String pay_param) {
        new Alipay(getContext(), pay_param, new Alipay.AlipayResultCallBack() {
            @Override
            public void onSuccess() {
                Toast.makeText(getContext(), "支付成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDealing() {
                Toast.makeText(getContext(), "支付处理中...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(int error_code) {
                switch (error_code) {
                    case Alipay.ERROR_RESULT:
                        Toast.makeText(getContext(), "支付失败:支付结果解析错误", Toast.LENGTH_SHORT).show();
                        break;

                    case Alipay.ERROR_NETWORK:
                        Toast.makeText(getContext(), "支付失败:网络连接错误", Toast.LENGTH_SHORT).show();
                        break;

                    case Alipay.ERROR_PAY:
                        Toast.makeText(getContext(), "支付错误:支付码支付失败", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        Toast.makeText(getContext(), "支付错误", Toast.LENGTH_SHORT).show();
                        break;
                }

            }

            @Override
            public void onCancel() {
                Toast.makeText(getContext(), "支付取消", Toast.LENGTH_SHORT).show();
            }
        }).doPay();
    }

}
