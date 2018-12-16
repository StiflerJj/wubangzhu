package com.wubangzhu.presentation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ActivityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kd.easybarrage.Barrage;
import com.kd.easybarrage.BarrageView;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.GWClient;
import com.wubangzhu.domain.http.response.login.DanmuResponse;
import com.wubangzhu.domain.http.response.login.FIndAllGouWu;
import com.wubangzhu.domain.http.response.login.LunbotuResponse;
import com.wubangzhu.presentation.activity.GoodsInfoActivity;
import com.wubangzhu.presentation.adapter.BuyAdapter;
import com.wubangzhu.presentation.widgets.GlideImageLoader;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;
import com.youth.banner.Banner;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

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
                    public void onSuccess(final FIndAllGouWu response, Response response2) throws InterruptedException, JSONException {

                        if(response!=null && response.getGwshopmodels()!=null && response.getGwshopmodels().size()>0){
                            buyAdapter = new BuyAdapter(getActivity(),response.getGwshopmodels());
                            buyAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                                    Intent intent = new Intent(getContext(), GoodsInfoActivity.class);
                                    intent.putExtra("good",response.getGwshopmodels().get(position));
                                    ActivityUtils.startActivity(intent);
                                }
                            });
                            shoplistView.setAdapter(buyAdapter);
                        }
                    }
                }
        );
        new GWClient().postFindNoticeByType(ShareData.getShareStringData(ShareKeys.Login_UKEY), 1, new Callback2<DanmuResponse>() {
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
        new GWClient().postFindpicByType(ShareData.getShareStringData(ShareKeys.Login_UKEY), 1, new Callback2<LunbotuResponse>() {
            @Override
            public void onFailure(RetrofitError retrofitError) {

            }

            @Override
            public void onSuccess(LunbotuResponse response, Response response2) throws InterruptedException, JSONException {
                banner.setImageLoader(new GlideImageLoader());
                if(response!=null && response.getPictures()!=null && response.getPictures().size()>0){
                    List<String> list = new ArrayList<>();
                    for(LunbotuResponse.PicturesBean bean : response.getPictures()){
                        list.add(bean.getPath());
                    }
                    banner.setImages(list);
                    banner.start();
                }else{
                    banner.setImages(ShareKeys.getImages());
                    banner.start();
                }
            }
        });
    }

    private void initView() {


        shoplistView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
