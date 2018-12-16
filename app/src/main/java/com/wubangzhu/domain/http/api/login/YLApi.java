package com.wubangzhu.domain.http.api.login;

import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllMyBiao;
import com.wubangzhu.domain.http.response.login.AllMyHistoryBiao;
import com.wubangzhu.domain.http.response.login.AllPayGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.GoodHistoryLIst;
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
    @POST("/yl/bmourguess")//报名收费区 0报名成功 999报名人数已满 998 账户余额不足请充值 997已经报名 其他稍后重试
    void postbaomingPay(@Query("ukey") String ukey,@Query("userid") int userid,@Query("ourguessid") int ourguessid,
                        @Query("bmGuessnumber") int bmGuessnumber,Callback2<BaseResponse> callback2);
    @POST("/yl/doguess")//猜数字收费区 0我猜对了 1猜对 2猜测数字过大 3猜测数字过小 4错误，请稍后重试 999猜大或者猜小 998竞猜尚未开始 997该游戏已结束
    void postdoguessPay(@Query("ukey") String ukey,@Query("userid") int userid,@Query("ourguessid") int ourguessid,
                        @Query("guessnumber") int bmGuessnumber,Callback2<BaseResponse> callback2);

    @POST("/yl/findMyWaitGuess")//获取当前用户等待/正在 参与游戏
    void postdoguessPay(@Query("ukey") String ukey,@Query("userid") int userid,Callback2<AllMyBiao> callback2);

    @POST("/yl/findMyGuess")//获取当前用户猜到的游戏
    void postfindMyGuess(@Query("ukey") String ukey, @Query("userid") int userid, @Query("type") int type, Callback2<AllMyHistoryBiao> callback2);
}
