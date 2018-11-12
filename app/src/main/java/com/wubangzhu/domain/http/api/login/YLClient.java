package com.wubangzhu.domain.http.api.login;

import com.wubangzhu.BuildConfig;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.URL;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.LoginResponse;
import com.wubangzhu.domain.http.response.login.StartShopResponse;

import retrofit.RestAdapter;

public class YLClient {
    YLApi ylApi = new RestAdapter.Builder()
            .setEndpoint(URL.HOST)
            .setLogLevel(BuildConfig.DEBUG? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
            .build()
            .create(YLApi.class);
    public void postfindAll(String ukey,int type, Callback2<AllGoods> responseCallback2){
        ylApi.postfindAll(ukey,type,responseCallback2);
    }
    public void poststartShop(String ukey,int type,int shopmodelid, Callback2<StartShopResponse> responseCallback2){
        ylApi.poststartShop(ukey,type,shopmodelid,responseCallback2);
    }
    public void postguessShop(String ukey,int shmhistoryid,String number, Callback2<BaseResponse> responseCallback2){
        ylApi.postguessShop(ukey,shmhistoryid,number,responseCallback2);
    }
}
