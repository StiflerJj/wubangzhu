package com.wubangzhu.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kd.easybarrage.Barrage;
import com.kd.easybarrage.BarrageView;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.GWClient;
import com.wubangzhu.domain.http.response.login.FIndAllGouWu;
import com.wubangzhu.presentation.adapter.BuyAdapter;
import com.wubangzhu.presentation.widgets.GlideImageLoader;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;
import com.youth.banner.Banner;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AllGoodsFragment extends BaseFragment {
    @BindView(R.id.banber_shop)
    Banner banner;
    @BindView(R.id.barrageView)
    BarrageView barrageView;
    @BindView(R.id.shop_list)
    RecyclerView shoplistView;

    BuyAdapter buyAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        initData();

        return rootView;
    }

    private void initData() {
        new GWClient().postgwFindAll(ShareData.getShareStringData(ShareKeys.Login_UKEY), new Callback2<FIndAllGouWu>() {
                    @Override
                    public void onFailure(RetrofitError retrofitError) {

                    }

                    @Override
                    public void onSuccess(FIndAllGouWu response, Response response2) throws InterruptedException, JSONException {

                        if(response!=null && response.getGwshopmodels()!=null && response.getGwshopmodels().size()>0){
                            buyAdapter = new BuyAdapter(getActivity(),response.getGwshopmodels());
                            shoplistView.setAdapter(buyAdapter);
                        }
                    }
                }
        );
    }

    private void initView() {
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(ShareKeys.getImages());
        banner.start();
        barrageView.addBarrage(new Barrage("恭喜XXX猜中iPhone XS Max！"));
        shoplistView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
