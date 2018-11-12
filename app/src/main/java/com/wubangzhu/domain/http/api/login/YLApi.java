package com.wubangzhu.domain.http.api.login;

import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.StartShopResponse;

import retrofit.http.POST;
import retrofit.http.Query;

public interface YLApi {
    @POST("/yl/findAll")
    void postfindAll(@Query("ukey") String ukey, @Query("type") int type, Callback2<AllGoods> callback2);
    @POST("/yl/startShop")
    void poststartShop(@Query("ukey") String ukey, @Query("userid") int userid,@Query("shopmodelid") int shopmodelid, Callback2<StartShopResponse> callback2);
    @POST("/yl/guessShop")
    void postguessShop(@Query("ukey") String ukey, @Query("shmhistoryid") int shmhistoryid,@Query("number") String number, Callback2<BaseResponse> callback2);
}
