package com.wubangzhu.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.LoginClient;
import com.wubangzhu.domain.http.response.login.UserInfoResponse;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;

import org.json.JSONException;

import butterknife.ButterKnife;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UserInfoFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_userinfo, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        initData();

        return rootView;
    }

    private void initView() {

    }

    private void initData() {
        new LoginClient().postFindUser(ShareData.getShareStringData(ShareKeys.Login_UKEY),
                ShareData.getShareIntData(ShareKeys.Login_UserId), new Callback2<UserInfoResponse>() {
                    @Override
                    public void onFailure(RetrofitError retrofitError) {

                    }

                    @Override
                    public void onSuccess(UserInfoResponse response, Response response2) throws InterruptedException, JSONException {

                    }
                });
    }

}
