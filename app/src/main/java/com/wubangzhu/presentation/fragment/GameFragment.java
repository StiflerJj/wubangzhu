package com.wubangzhu.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.util.DialogUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kd.easybarrage.Barrage;
import com.kd.easybarrage.BarrageView;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.GWClient;
import com.wubangzhu.domain.http.api.login.YLClient;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllPayGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.DanmuResponse;
import com.wubangzhu.domain.http.response.login.LunbotuResponse;
import com.wubangzhu.domain.http.response.login.StartShopResponse;
import com.wubangzhu.presentation.adapter.FreeAdapter;
import com.wubangzhu.presentation.adapter.PayAdapter;
import com.wubangzhu.presentation.widgets.GlideImageLoader;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;
import com.youth.banner.Banner;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * 猜谜主界面
 */
public class GameFragment extends BaseFragment {
    @BindView(R.id.banber_game)
    Banner banner;
    @BindView(R.id.barrageView)
    BarrageView barrageView;
    @BindView(R.id.game_group)
    RadioGroup game_group;
    @BindView(R.id.free_btn)
    RadioButton freeRadioBtn;
    @BindView(R.id.pay_btn)
    RadioButton payRadioBtn;
    @BindView(R.id.game_list)
    RecyclerView mGameList;

    FreeAdapter freeAdapter;
    PayAdapter payAdapter;
    MaterialDialog dialog;
    View inputView,inputViewFree;

    List<AllGoods.ShopmodelsBean> shopmodelBeanList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        initData(1);//1 FREE 2 PAY
        getImages();
        getNotices();
        return rootView;
    }

    private void initData(int type) {
        if (type == 1) {


            new YLClient().postfindAll(ShareData.getShareStringData(ShareKeys.Login_UKEY), new Callback2<AllGoods>() {
                @Override
                public void onFailure(RetrofitError retrofitError) {

                }

                @Override
                public void onSuccess(AllGoods response, Response response2) throws InterruptedException, JSONException {

                    if (response != null && response.getCode() == 0) {
                        shopmodelBeanList = response.getShopmodels();
                        freeAdapter = new FreeAdapter(shopmodelBeanList);
                        freeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                new YLClient().poststartShop(ShareData.getShareStringData(ShareKeys.Login_UKEY), ShareData.getShareIntData(ShareKeys.Login_UserId),
                                        shopmodelBeanList.get(position).getId(), new Callback2<StartShopResponse>() {
                                            @Override
                                            public void onFailure(RetrofitError retrofitError) {

                                            }

                                            @Override
                                            public void onSuccess(final StartShopResponse response, Response response2) throws InterruptedException, JSONException {

                                                if (response != null && response.getCode() == 0) {
                                                    dialog = new MaterialDialog.Builder(getContext())
                                                            .customView(inputViewFree, false).show();
                                                    dialog.getCustomView().findViewById(R.id.btn_guessfree).setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            String number = ((EditText)dialog.getCustomView().findViewById(R.id.input_guessfree)).getText().toString();
                                                            if(number.length()==0){
                                                                ToastUtils.showShort(R.string.gameinfo_biao_content_null);
                                                                return;
                                                            }
                                                            new YLClient().postguessShop(ShareData.getShareStringData(ShareKeys.Login_UKEY), response.getShmhistory().getId(),
                                                                    number, new Callback2<BaseResponse>() {
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
                                            }
                                        });

                            }
                        });
                        mGameList.setAdapter(freeAdapter);

                    }
                }
            });
        } else {
            new YLClient().postfindAllPayArea(ShareData.getShareStringData(ShareKeys.Login_UKEY), new Callback2<AllPayGoods>() {
                @Override
                public void onFailure(RetrofitError retrofitError) {

                }

                @Override
                public void onSuccess(final AllPayGoods response, Response response2) throws InterruptedException, JSONException {

                    if (response != null && response.getOurGuesses() != null && response.getOurGuesses().size() > 0) {
                        payAdapter = new PayAdapter(response.getOurGuesses());
                        payAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, final int position) {
//
                                if (response.getOurGuesses().get(position).getState()==1) {
                                    dialog = new MaterialDialog.Builder(getContext())
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
                                                            ShareData.getShareIntData(ShareKeys.Login_UserId), response.getOurGuesses().get(position).getId(), Integer.parseInt(initNumber),
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


                            }
                        });
                        mGameList.setAdapter(payAdapter);
                    }
                }
            });
        }
    }

    private void initView() {
        freeRadioBtn.setChecked(true);

        mGameList.setLayoutManager(new LinearLayoutManager(getContext()));
        inputView = LayoutInflater.from(getContext()).inflate(R.layout.view_guessinput, null);
        inputViewFree = LayoutInflater.from(getContext()).inflate(R.layout.view_guessfree, null);
    }
//        game_group.setOnCheckedChangeListener(onCheckedChanged);
//    private RadioGroup.OnCheckedChangeListener onCheckedChanged = new RadioGroup.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//        }
//    };

    /**
     * 这里逻辑是首先判断是否被选中，刚进入界面是被选中的，pay被选中以后这里ischecked就变成了false，进而要执行type未2的数据
     *
     * @param ischecked
     */
    @OnCheckedChanged(R.id.free_btn)
    void onFreeCheckChange(boolean ischecked) {
        if (ischecked)
            return;
        initData(2);
    }

    @OnCheckedChanged(R.id.pay_btn)
    void onPayCheckChange(boolean ischecked) {
        if (ischecked)
            return;
        initData(1);
    }
    void getImages(){
        new GWClient().postFindpicByType(ShareData.getShareStringData(ShareKeys.Login_UKEY), 2, new Callback2<LunbotuResponse>() {
            @Override
            public void onFailure(RetrofitError retrofitError) {

            }

            @Override
            public void onSuccess(LunbotuResponse response, Response response2) throws InterruptedException, JSONException {

                if(response!=null && response.getPictures()!=null && response.getPictures().size()>0){
                    List<String> list = new ArrayList<>();
                    for(LunbotuResponse.PicturesBean bean : response.getPictures()){
                        list.add(bean.getPath());
                    }
                    banner.setImageLoader(new GlideImageLoader());
                    banner.setImages(list);
                    banner.start();
                }else{
                    banner.setImageLoader(new GlideImageLoader());
                    banner.setImages(ShareKeys.getImages());
                    banner.start();
                }
            }
        });
    }
    void getNotices(){
        new GWClient().postFindNoticeByType(ShareData.getShareStringData(ShareKeys.Login_UKEY), 2, new Callback2<DanmuResponse>() {
            @Override
            public void onFailure(RetrofitError retrofitError) {

            }

            @Override
            public void onSuccess(DanmuResponse response, Response response2) throws InterruptedException, JSONException {

                if(response!=null && response.getNotices()!=null && response.getNotices().size()>0){
                    for(int i=0;i<response.getNotices().size();i++){
                        barrageView.addBarrage(new Barrage(response.getNotices().get(i).getConbody()));
                    }
                }
            }
        });
    }
}
