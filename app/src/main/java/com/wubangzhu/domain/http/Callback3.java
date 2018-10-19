package com.wubangzhu.domain.http;


import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * callback with progress
 * @param <T>
 */
public abstract class Callback3<T> implements Callback<T> {

    private static List<Callback3> callbacks = new ArrayList<Callback3>(20);


    public Callback3() {
        callbacks.add(this);
    }

    public static void cancelAll() {
        callbacks.clear();
    }


    private boolean isCancelled() {
        return !callbacks.contains(this);
    }

    public void cancel() {
        callbacks.remove(this);
    }

    public final void failure(RetrofitError retrofitError) {
        if (isCancelled())
            return;
        callbacks.remove(this);
        onFailure(retrofitError);
//        LogUtils.e(retrofitError.getBody()+" "+retrofitError.getResponse()+" "+retrofitError.getMessage());
        if(retrofitError!=null && retrofitError.getMessage()!=null&& retrofitError.getMessage().contains("449")){
            ActivityUtils.finishAllActivities();
//            ActivityUtils.startActivity(LoginActivity.class);
            ToastUtils.showLong("您的登录已过期，请重新登录");
        }
    }

    public abstract void onFailure(RetrofitError retrofitError);

    public abstract void onSuccess(T response, Response response2) throws InterruptedException, JSONException;

    public final void success(T response, Response response2) {
        if (isCancelled())
            return;
        callbacks.remove(this);
        try {
            try {
                onSuccess(response, response2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
