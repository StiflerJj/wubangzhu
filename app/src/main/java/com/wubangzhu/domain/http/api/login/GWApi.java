package com.wubangzhu.domain.http.api.login;

import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllPayGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.StartShopResponse;

import retrofit.http.POST;
import retrofit.http.Query;

public interface GWApi {
    @POST("/gw/findAll")//购物区所有
    void postgwfindAll(@Query("ukey") String ukey, Callback2<BaseResponse> callback2);
    @POST("/gw/gw")//购物区购买
    void postgoumai(@Query("ukey") String ukey, @Query("userid") int userid, @Query("shopmodelid") int shopmodelid, Callback2<StartShopResponse> callback2);


}
