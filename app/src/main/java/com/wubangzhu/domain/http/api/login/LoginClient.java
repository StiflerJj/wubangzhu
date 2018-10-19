package com.wubangzhu.domain.http.api.login;


import com.wubangzhu.BuildConfig;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.URL;
import com.wubangzhu.domain.http.request.login.LoginRequest;
import com.wubangzhu.domain.http.response.login.LoginResponse;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;

import retrofit.RestAdapter;

public class LoginClient {
    LoginApi loginApi = new RestAdapter.Builder()
            .setEndpoint(URL.HOST)
            .setLogLevel(BuildConfig.DEBUG? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
            .build()
            .create(LoginApi.class);

    public void postLogin(LoginRequest request, Callback2<LoginResponse> responseCallback2){
        loginApi.postLogin(request.toString(),responseCallback2);
    }



}
