package com.wubangzhu.domain.http.api.login;

import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.Callback3;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.LoginResponse;
import com.wubangzhu.domain.http.response.login.UserInfoResponse;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

public interface LoginApi {
    @POST("/user/doLogin")
    void postLogin(@Query("phonenumber") String phone,@Query("password") String password, Callback2<LoginResponse> callback2);
    @POST("/user/sendRcode")
    void postRcode(@Query("phonenumber") String value, Callback2<BaseResponse> callback2);
    @POST("/user/register")
    void postRegist(@Query("phonenumber") String value,@Query("code") String code,
                    @Query("password") String password,@Query("tgname") String tgname,
                    Callback2<BaseResponse> callback2);
    @POST("/user/findUser")
    void postFindUser(@Query("ukey") String ukey,@Query("id") int id, Callback3<UserInfoResponse> callback2);
    @POST("/user/goToTg")
    void postgoToTg(@Query("ukey") String ukey,@Query("id") int id, Callback2<BaseResponse> callback2);

    @POST("/user/chongzhitest")
    void postchongzhiTest(@Query("ukey") String ukey,@Query("userid") int userid,@Query("money") int money, Callback2<BaseResponse> callback2);
}
