package com.wubangzhu.domain.http.api.login;


import com.wubangzhu.BuildConfig;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.Callback3;
import com.wubangzhu.domain.http.URL;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.DanmuResponse;
import com.wubangzhu.domain.http.response.login.FIndAllGouWu;
import com.wubangzhu.domain.http.response.login.LoginResponse;
import com.wubangzhu.domain.http.response.login.LunbotuResponse;
import com.wubangzhu.domain.http.response.login.UserInfoResponse;

import retrofit.RestAdapter;

public class GWClient {
    GWApi gouwuapi = new RestAdapter.Builder()
            .setEndpoint(URL.HOST)
            .setLogLevel(BuildConfig.DEBUG? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
            .build()
            .create(GWApi.class);
    public void postFindpicByType(String ukey, int type,Callback2<LunbotuResponse> responseCallback2){
        gouwuapi.postFindpicBytype(ukey,type,responseCallback2);
    }
    public void postFindNoticeByType(String ukey, int type,Callback2<DanmuResponse> responseCallback2){
        gouwuapi.postFindNoticeBytype(ukey,type,responseCallback2);
    }
    public void postgwFindAll(String ukey, Callback2<FIndAllGouWu> responseCallback2){
        gouwuapi.postgwfindAll(ukey,responseCallback2);
    }
    public void postgwBuy(String ukey,int gwsmodelid,int howmany,int xa,int xb,double paymoney, Callback2<BaseResponse> responseCallback2){
        gouwuapi.postgoumai(ukey,gwsmodelid,howmany,xa,xb,paymoney,responseCallback2);
    }


}
