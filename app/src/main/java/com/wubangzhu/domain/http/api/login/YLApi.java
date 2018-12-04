package com.wubangzhu.domain.http.api.login;

import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllPayGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.StartShopResponse;

import retrofit.http.POST;
import retrofit.http.Query;

public interface YLApi {
    @POST("/yl/findAll")//免费区所有
    void postfindAll(@Query("ukey") String ukey, Callback2<AllGoods> callback2);
    @POST("/yl/startShop")//免费区开始游戏（个人
    void poststartShop(@Query("ukey") String ukey, @Query("userid") int userid,@Query("shopmodelid") int shopmodelid, Callback2<StartShopResponse> callback2);
    @POST("/yl/guessShop")//免费区猜数字
    void postguessShop(@Query("ukey") String ukey, @Query("shmhistoryid") int shmhistoryid,@Query("number") String number, Callback2<BaseResponse> callback2);

    @POST("/yl/findAllOurguess")//所有收费区
    void postguessShop(@Query("ukey") String ukey, Callback2<AllPayGoods> callback2);
    @POST("/yl/bmourguess")//报名收费区
    void postbaomingPay(@Query("ukey") String ukey,@Query("userid") int userid,@Query("ourguessid") int ourguessid,
                        @Query("bmGuessnumber") int bmGuessnumber,Callback2<BaseResponse> callback2);
    @POST("/yl/doguess")//猜数字收费区
    void postdoguessPay(@Query("ukey") String ukey,@Query("userid") int userid,@Query("ourguessid") int ourguessid,
                        @Query("bmGuessnumber") int bmGuessnumber,Callback2<BaseResponse> callback2);

}
