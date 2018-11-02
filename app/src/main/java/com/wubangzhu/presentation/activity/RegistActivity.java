package com.wubangzhu.presentation.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.LogUtils;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.LoginClient;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.util.CommonUtil;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RegistActivity extends BaseInfoActivity{
    @BindView(R.id.input_phone)
    EditText editTextPhone;
    @BindView(R.id.input_verifycode)
    EditText editTextCode;
    @BindView(R.id.input_pwd)
    EditText editTextPwd;
    @BindView(R.id.input_pwdagain)
    EditText editTextPwdagain;
    @BindView(R.id.input_inviter)
    EditText editTextInviter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_regist);
        ButterKnife.bind(this);
        setBackArrow();
        setTitle(R.string.regist);

    }
    @OnClick({R.id.btn_regist,R.id.btn_verifycode}) void setTryit(View view){
        if(view.getId()==R.id.btn_regist){
            new LoginClient().postRegist("13722852917","180543","123456","tg1234", new Callback2<BaseResponse>() {
                @Override
                public void onFailure(RetrofitError retrofitError) {

                }

                @Override
                public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {

                }
            });
        }else{
            new LoginClient().postRcode("13722852917", new Callback2<BaseResponse>() {
                @Override
                public void onFailure(RetrofitError retrofitError) {

                }

                @Override
                public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {

                }
            });

        }

    }
}
