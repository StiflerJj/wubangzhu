package com.wubangzhu.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.util.DialogUtils;
import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kd.easybarrage.Barrage;
import com.kd.easybarrage.BarrageView;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.YLClient;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllPayGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.StartShopResponse;
import com.wubangzhu.presentation.adapter.FreeAdapter;
import com.wubangzhu.presentation.adapter.PayAdapter;
import com.wubangzhu.presentation.widgets.GlideImageLoader;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;
import com.youth.banner.Banner;

import org.json.JSONException;

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

    List<AllGoods.ShopmodelsBean> shopmodelBeanList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        new YLClient().postfindAllPayArea(ShareData.getShareStringData(ShareKeys.Login_UKEY), new Callback2<AllPayGoods>() {
            @Override
            public void onFailure(RetrofitError retrofitError) {

            }

            @Override
            public void onSuccess(AllPayGoods response, Response response2) throws InterruptedException, JSONException {

            }
        });
        initData(1);//1 FREE 2 PAY

        return rootView;
    }

    private void initData(int type) {
        if(type==1){


        new YLClient().postfindAll(ShareData.getShareStringData(ShareKeys.Login_UKEY), new Callback2<AllGoods>() {
            @Override
            public void onFailure(RetrofitError retrofitError) {

            }

            @Override
            public void onSuccess(AllGoods response, Response response2) throws InterruptedException, JSONException {

                if(response!=null && response.getCode()==0){
                    shopmodelBeanList = response.getShopmodels();
                    LogUtils.e("shopmodelBeanList "+shopmodelBeanList.get(0));
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
                                        public void onSuccess(StartShopResponse response, Response response2) throws InterruptedException, JSONException {

                                            if(response!=null && response.getCode()==0){


                                            }
                                        }
                                    });

                        }
                    });
                    mGameList.setAdapter(freeAdapter);

                }
            }
        });
        }else{
            new YLClient().postfindAllPayArea(ShareData.getShareStringData(ShareKeys.Login_UKEY), new Callback2<AllPayGoods>() {
                @Override
                public void onFailure(RetrofitError retrofitError) {

                }

                @Override
                public void onSuccess(AllPayGoods response, Response response2) throws InterruptedException, JSONException {

                    if(response!=null && response.getOurGuesses()!=null && response.getOurGuesses().size()>0){
                        payAdapter = new PayAdapter(response.getOurGuesses());
                        payAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                com.wubangzhu.util.DialogUtils.Companion.showCustomInputDialog(getContext());

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
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(ShareKeys.getImages());
        banner.start();
        barrageView.addBarrage(new Barrage("恭喜XXX猜中iPhone XS Max！"));
        mGameList.setLayoutManager(new LinearLayoutManager(getContext()));
//        game_group.setOnCheckedChangeListener(onCheckedChanged);
    }
//    private RadioGroup.OnCheckedChangeListener onCheckedChanged = new RadioGroup.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//        }
//    };

    /**
     * 这里逻辑是首先判断是否被选中，刚进入界面是被选中的，pay被选中以后这里ischecked就变成了false，进而要执行type未2的数据
     * @param ischecked
     */
    @OnCheckedChanged(R.id.free_btn) void onFreeCheckChange(boolean ischecked){
            if(ischecked)
                return;
            initData(2);
    }
    @OnCheckedChanged(R.id.pay_btn) void onPayCheckChange(boolean ischecked){
        if(ischecked)
            return;
        initData(1);
    }
}
