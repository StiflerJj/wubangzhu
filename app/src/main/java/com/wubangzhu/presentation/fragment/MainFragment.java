package com.wubangzhu.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.kd.easybarrage.Barrage;
import com.kd.easybarrage.BarrageView;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.LoginClient;
import com.wubangzhu.domain.http.api.login.YLClient;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.StartShopResponse;
import com.wubangzhu.domain.http.response.login.UserInfoResponse;
import com.wubangzhu.presentation.activity.MainActivity;
import com.wubangzhu.presentation.widgets.GlideImageLoader;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;
import com.youth.banner.Banner;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainFragment extends BaseFragment {

    @BindView(R.id.banber_main)
    Banner banner;
    @BindView(R.id.barrageView)
    BarrageView barrageView;
    @BindView(R.id.btn_gotomall)
    Button gotoMall;
    @BindView(R.id.btn_gotogame)
    Button gotoGame;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        initData();

        return rootView;
    }

    private void initData() {
//        new LoginClient().postFindUser(ShareData.getShareStringData(ShareKeys.Login_UKEY),
//                ShareData.getShareIntData(ShareKeys.Login_UserId), new Callback2<UserInfoResponse>() {
//                    @Override
//                    public void onFailure(RetrofitError retrofitError) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(UserInfoResponse response, Response response2) throws InterruptedException, JSONException {
//
//                    }
//                });
    }

    void initView(){
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(ShareKeys.getImages());
        banner.start();
        barrageView.addBarrage(new Barrage("恭喜XXX猜中iPhone XS Max！"));
    }
    @OnClick({R.id.btn_gotomall,R.id.btn_gotogame})
    void onclick(View v){
        if(v == gotoMall){
            ToastUtils.showShort("购物区");
//            new YLClient().postfindAll(ShareData.getShareStringData(ShareKeys.Login_UKEY),
//                    1, new Callback2<AllGoods>() {
//                        @Override
//                        public void onFailure(RetrofitError retrofitError) {
//
//                        }
//
//                        @Override
//                        public void onSuccess(AllGoods response, Response response2) throws InterruptedException, JSONException {
//
//                            if(response!=null && response.getShopmodels().size()>0){
//                                new YLClient().poststartShop(ShareData.getShareStringData(ShareKeys.Login_UKEY),
//                                        ShareData.getShareIntData(ShareKeys.Login_UserId),
//                                        response.getShopmodels().get(0).getId(), new Callback2<StartShopResponse>() {
//                                            @Override
//                                            public void onFailure(RetrofitError retrofitError) {
//
//                                            }
//
//                                            @Override
//                                            public void onSuccess(StartShopResponse response, Response response2) throws InterruptedException, JSONException {
//
//                                                new YLClient().postguessShop(ShareData.getShareStringData(ShareKeys.Login_UKEY),
//                                                        response.getShmhistory().getId(), response.getShmhistory().getLuckynumber() + "", new Callback2<BaseResponse>() {
//                                                            @Override
//                                                            public void onFailure(RetrofitError retrofitError) {
//
//                                                            }
//
//                                                            @Override
//                                                            public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {
//
//                                                            }
//                                                        });
//                                            }
//                                        });
//                            }
//                        }
//                    });
        }else{
            ToastUtils.showShort("娱乐区");
        }
    }
}
