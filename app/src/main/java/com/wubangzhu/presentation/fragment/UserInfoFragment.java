package com.wubangzhu.presentation.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.Callback3;
import com.wubangzhu.domain.http.api.login.LoginClient;
import com.wubangzhu.domain.http.api.login.YLClient;
import com.wubangzhu.domain.http.response.login.AllMyBiao;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.UserInfoResponse;
import com.wubangzhu.presentation.adapter.MyBiaoAdapter;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;
import com.zhou.zhoulib.util.Const;

import org.json.JSONException;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UserInfoFragment extends BaseFragment {
    /**
     * 获取权限使用的 RequestCode
     */
    private static final int PERMISSIONS_REQUEST_CODE = 1002;

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
    @BindView(R.id.info_buyhistorylist)
    RecyclerView mBuyHistory;
    @BindView(R.id.biao_group)
    RadioGroup biao_group;
    @BindView(R.id.biao_ing_btn)
    RadioButton ingRadioBtn;
    @BindView(R.id.biao_bingo_btn)
    RadioButton bingoRadioBtn;


    MaterialDialog dialog;
    View inputView,inputViewFree;

    MyBiaoAdapter myBiaoAdapter;


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
        if (Build.VERSION.SDK_INT >= 23) {
            // Here, thisActivity is the current activity
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{
                                Manifest.permission.READ_PHONE_STATE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        }, PERMISSIONS_REQUEST_CODE);

            } else {
                ToastUtils.showLong("支付宝 SDK 已有所需的权限");
            }
        }
        inputView = LayoutInflater.from(getContext()).inflate(R.layout.view_guessinput, null);
        inputViewFree = LayoutInflater.from(getContext()).inflate(R.layout.view_guessfree, null);
        mWaitBiao.setLayoutManager(new LinearLayoutManager(getContext()));



    }

    private void initData() {
        getUserInfo();
        getMyBiao();
        getMyZhongBiao();
        getMyBuyGoods();

    }

    @OnClick({R.id.info_tgbtn, R.id.info_buytiket})
    void btnClick(View v) {
        if (v == mTgbtn) {
            getTgId();
        } else {
            ((TextView) inputView.findViewById(R.id.dialog_title)).setText(R.string.userinfo_howmuch);
            dialog = new MaterialDialog.Builder(getContext())
                    .customView(inputView, false)
                    .positiveText("确定")
                    .negativeText("取消")
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                            String initNumber = ((EditText) dialog.getCustomView().findViewById(R.id.input_guess)).getText().toString();
                            ((EditText) dialog.getCustomView().findViewById(R.id.input_guess)).setInputType(InputType.TYPE_CLASS_NUMBER);
                            if (initNumber.length() == 0) {
                                ToastUtils.showShort(R.string.userinfo_paymoney_content_null);
                                return;
                            }
                            new LoginClient().postchongzhiTest(ShareData.getShareStringData(ShareKeys.Login_UKEY),
                                    ShareData.getShareIntData(ShareKeys.Login_UserId), Integer.parseInt(initNumber), new Callback2<BaseResponse>() {
                                        @Override
                                        public void onFailure(RetrofitError retrofitError) {

                                        }

                                        @Override
                                        public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {

                                        }
                                    });


                        }
                    })
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        }
                    })
                    .show();

//            Runnable payRunnable = new Runnable() {
//
//                @Override
//                public void run() {
//                    PayTask alipay = new PayTask(getActivity());
//                    Map<String, String> result = alipay.payV2("alipay_sdk=alipay-sdk-java-3.4.49.ALL&app_id=2018111862261364&biz_content=%7B%22body%22%3A%22%E6%88%91%E6%98%AF%E6%B5%8B%E8%AF%95%E6%95%B0%E6%8D%AE%22%2C%22out_trade_no%22%3A%22123%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22App%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95Java%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=%E5%95%86%E6%88%B7%E5%A4%96%E7%BD%91%E5%8F%AF%E4%BB%A5%E8%AE%BF%E9%97%AE%E7%9A%84%E5%BC%82%E6%AD%A5%E5%9C%B0%E5%9D%80&sign=A29n99uwFYaUAiqbjmXArzq6p1wgjPnGZ03sEeb70bvHdO9KPv74kqKHC7jcCiZuE8KoxZ2NXmbVYIBrVHILsEkbRSYg5rl10jOoeliOt2AfWfzMqU23g8jY2t%2FCUgXEpy4Yy6%2BY6ju3i%2Fhi3md1YdojtiyyVDATHRGLZguuGalbGmwtGZHDth2subNPuio0H%2BsKiEfmOVSncVd37ln7AWE0PiUM4JyvIErZSWljqy5Rbjd1ZwG1wIaLLN6f9Bc4F1rkDPX%2FBnvDukYl3zBMW0TugnZKxLXV4O3MlFfeJ8%2FTj%2FpUovOy%2FY8iOJli3%2BXA9uHyKWH6qXVg0gLWw79z6w%3D%3D&sign_type=RSA2&timestamp=2018-11-27+22%3A24%3A52&version=1.0", true);
//                    Log.i("msp", result.toString());
//
//                }
//            };
//
//            Thread payThread = new Thread(payRunnable);
//            payThread.start();

        }
    }


    /**
     * 权限获取回调
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                           int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE: {

                // 用户取消了权限弹窗
                if (grantResults.length == 0) {
                    ToastUtils.showLong("无法获取支付宝 SDK 所需的权限, 请到系统设置开启");
                    return;
                }

                // 用户拒绝了某些权限
                for (int x : grantResults) {
                    if (x == PackageManager.PERMISSION_DENIED) {
                        ToastUtils.showLong("无法获取支付宝 SDK 所需的权限, 请到系统设置开启");
                        return;
                    }
                }

                // 所需的权限均正常获取
                ToastUtils.showLong("支付宝 SDK 所需的权限已经正常获取");
            }
        }
    }

    void getUserInfo(){
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
                                mPhone.setText("用户: "+userBean.getName());
                                mTicketA.setText("未使用1.1元A卷 "+response.getUser().getXa()+"张");
                                mTicketB.setText("未使用1.3元B卷 "+response.getUser().getXb()+"张");
                                if (userBean.getIstg() != 0) {
                                    mTgbtn.setVisibility(View.GONE);
                                    mTgid.setText("推广ID: "+response.getUser().getTgname());
                                }
                            }

                        }


                    }
                });
    }
    void getMyBiao(){
        new YLClient().postfindMyWaitGuess(ShareData.getShareStringData(ShareKeys.Login_UKEY), ShareData.getShareIntData(ShareKeys.Login_UserId), new Callback2<AllMyBiao>() {
            @Override
            public void onFailure(RetrofitError retrofitError) {

            }

            @Override
            public void onSuccess(final AllMyBiao response, Response response2) throws InterruptedException, JSONException {

                if(response!=null && response.getOurGuesses()!=null && response.getOurGuesses().size()>0){
                    myBiaoAdapter = new MyBiaoAdapter(response.getOurGuesses());
                    myBiaoAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {
                            if(response.getOurGuesses().get(position).getStarttime()>System.currentTimeMillis()){
                                ToastUtils.showLong(R.string.gameinfo_biao_notstart);
                                return;
                            }
                            dialog = new MaterialDialog.Builder(getContext())
                                    .customView(inputViewFree, false).show();
                            dialog.setCancelable(false);
                            dialog.getCustomView().findViewById(R.id.btn_guessfree).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String number = ((EditText)dialog.getCustomView().findViewById(R.id.input_guessfree)).getText().toString();
                                    if(number.length()==0){
                                        ToastUtils.showShort(R.string.gameinfo_biao_content_null);
                                        return;
                                    }
                                    new YLClient().postguessPay(ShareData.getShareStringData(ShareKeys.Login_UKEY), ShareData.getShareIntData(ShareKeys.Login_UserId),
                                            response.getOurGuesses().get(position).getId(), Integer.parseInt(number), new Callback2<BaseResponse>() {
                                                @Override
                                                public void onFailure(RetrofitError retrofitError) {

                                                }

                                                @Override
                                                public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {

                                                }
                                            });
                                }
                            });
                            dialog.getCustomView().findViewById(R.id.btn_guessfreecancel).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });

                        }
                    });
                    mWaitBiao.setAdapter(myBiaoAdapter);

                }
            }
        });

    }
    void getMyZhongBiao(){
        new YLClient().postfindMyWin(ShareData.getShareStringData(ShareKeys.Login_UKEY), ShareData.getShareIntData(ShareKeys.Login_UserId),
                new Callback2<AllMyBiao>() {
                    @Override
                    public void onFailure(RetrofitError retrofitError) {

                    }

                    @Override
                    public void onSuccess(AllMyBiao response, Response response2) throws InterruptedException, JSONException {

                    }
                });

    }
    void getMyBuyGoods(){

    }
    void getTgId(){
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
    }

}
