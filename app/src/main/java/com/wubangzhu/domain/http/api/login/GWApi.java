package com.wubangzhu.domain.http.api.login;

import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllPayGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.FIndAllGouWu;
import com.wubangzhu.domain.http.response.login.StartShopResponse;

import retrofit.http.POST;
import retrofit.http.Query;

public interface GWApi {
    @POST("/pic/findPictureByType")//获取根据 type 获取轮播图
    void postFindpicBytype(@Query("ukey") String ukey,@Query("type") int type, Callback2<BaseResponse> callback2);
    @POST("/notice/findNoticeByType")//获取根据 type 获取notice
    void postFindNoticeBytype(@Query("ukey") String ukey,@Query("type") int type, Callback2<BaseResponse> callback2);
    @POST("/gw/findAll")//购物区所有
    void postgwfindAll(@Query("ukey") String ukey, Callback2<FIndAllGouWu> callback2);
    @POST("/gw/gw")//购物区购买
    void postgoumai(@Query("ukey") String ukey, @Query("gwsmodelid") int gwsmodelid, @Query("howmany") int howmany,
                    @Query("xa") int xa, @Query("xb") int xb,@Query("paymoney") double paymoney,Callback2<BaseResponse> callback2);


}
