package com.wubangzhu.domain.http.api.login;

import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.response.login.LoginResponse;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

public interface LoginApi {
    @POST("/user/login?logintype=1")
    void postLogin(@Header("authorization") String value, Callback2<LoginResponse> callback2);

}
