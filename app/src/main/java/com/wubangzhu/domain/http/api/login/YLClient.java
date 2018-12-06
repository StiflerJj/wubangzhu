package com.wubangzhu.domain.http.api.login;

import com.wubangzhu.BuildConfig;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.URL;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllMyBiao;
import com.wubangzhu.domain.http.response.login.AllPayGoods;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.LoginResponse;
import com.wubangzhu.domain.http.response.login.StartShopResponse;

import org.json.JSONException;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class YLClient {
    YLApi ylApi = new RestAdapter.Builder()
            .setEndpoint(URL.HOST)
            .setLogLevel(BuildConfig.DEBUG? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
            .build()
            .create(YLApi.class);
    public void postfindAll(String ukey, Callback2<AllGoods> responseCallback2){
        ylApi.postfindAll(ukey,responseCallback2);
    }
    public void poststartShop(String ukey,int type,int shopmodelid, Callback2<StartShopResponse> responseCallback2){
        ylApi.poststartShop(ukey,type,shopmodelid,responseCallback2);
    }
    public void postguessShop(String ukey,int shmhistoryid,String number, Callback2<BaseResponse> responseCallback2){
        ylApi.postguessShop(ukey,shmhistoryid,number,responseCallback2);
    }

    public void postfindAllPayArea(String ukey,Callback2<AllPayGoods> responseCallback2){
        ylApi.postguessShop(ukey,responseCallback2);
    }
    public void postbaomingPay(String ukey,int userid,int ourguessid,int bmGuessNumber,Callback2<BaseResponse> responseCallback2){
        ylApi.postbaomingPay(ukey,userid,ourguessid,bmGuessNumber,responseCallback2);
    }
    public void postguessPay(String ukey,int userid,int ourguessid,int bmGuessNumber,Callback2<BaseResponse> responseCallback2){
        ylApi.postdoguessPay(ukey,userid,ourguessid,bmGuessNumber,responseCallback2);
    }

    public void postfindMyWaitGuess(String ukey,int userid,Callback2<AllMyBiao> responseCallback2){
        ylApi.postdoguessPay(ukey,userid,responseCallback2);
    }
    public void postfindMyWin(String ukey,int userid,Callback2<AllMyBiao> responseCallback2){
        ylApi.postfindMyGuessWin(ukey,userid,responseCallback2);
    }
}
