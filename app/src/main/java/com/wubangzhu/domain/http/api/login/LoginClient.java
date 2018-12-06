package com.wubangzhu.domain.http.api.login;


import com.wubangzhu.BuildConfig;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.Callback3;
import com.wubangzhu.domain.http.URL;
import com.wubangzhu.domain.http.request.login.LoginRequest;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.LoginResponse;
import com.wubangzhu.domain.http.response.login.UserInfoResponse;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;

import retrofit.RestAdapter;

public class LoginClient {
    LoginApi loginApi = new RestAdapter.Builder()
            .setEndpoint(URL.HOST)
            .setLogLevel(BuildConfig.DEBUG? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
            .build()
            .create(LoginApi.class);

    public void postLogin(String phone,String pwd, Callback2<LoginResponse> responseCallback2){
        loginApi.postLogin(phone,pwd,responseCallback2);
    }
    public void postRcode(String request, Callback2<BaseResponse> responseCallback2){
        loginApi.postRcode(request.toString(),responseCallback2);
    }
    public void postRegist(String phonenumber,String code,String password,String tgname, Callback2<BaseResponse> responseCallback2){
        loginApi.postRegist(phonenumber,code,password,tgname,responseCallback2);
    }
    public void postFindUser(String ukey,int id, Callback3<UserInfoResponse> responseCallback2){
        loginApi.postFindUser(ukey,id,responseCallback2);
    }
    public void postgoToTg(String ukey,int id, Callback2<BaseResponse> responseCallback2){
        loginApi.postgoToTg(ukey,id,responseCallback2);
    }

    public void postchongzhiTest(String ukey,int userid,int money, Callback2<BaseResponse> responseCallback2){
        loginApi.postchongzhiTest(ukey,userid,money,responseCallback2);
    }


}
