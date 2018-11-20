package com.wubangzhu.presentation.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
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

            if(isRegistEmpty())
                return;
            new LoginClient().postRegist(editTextPhone.getText().toString(),editTextCode.getText().toString(),editTextPwd.getText().toString(),editTextCode.getText().toString(), new Callback2<BaseResponse>() {
                @Override
                public void onFailure(RetrofitError retrofitError) {

                }

                @Override
                public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {

                    if(response.getCode()==0){
                        finish();
                    }
                }
            });
        }else{
            if(StringUtils.isEmpty(editTextPhone.getText().toString())){
                ToastUtils.showShort("请正确输入手机号码");
                return;
            }
            new LoginClient().postRcode(editTextPhone.getText().toString(), new Callback2<BaseResponse>() {
                @Override
                public void onFailure(RetrofitError retrofitError) {

                }

                @Override
                public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {

                }
            });

        }

    }

    private boolean isRegistEmpty(){
        if(StringUtils.isEmpty(editTextPhone.getText().toString())){
            ToastUtils.showShort(R.string.rewrite);
            return true;
        }else if(StringUtils.isEmpty(editTextCode.getText().toString())){
            ToastUtils.showShort(R.string.rewrite_code);
            return true;
        }else if(StringUtils.isEmpty(editTextPwd.getText().toString())){
            ToastUtils.showShort(R.string.rewrite);
            return true;
        }else if(StringUtils.isEmpty(editTextPwdagain.getText().toString())){
            ToastUtils.showShort(R.string.rewrite);
            return true;
        }else if(StringUtils.isEmpty(editTextInviter.getText().toString())){
            ToastUtils.showShort(R.string.rewrite_tgid);
            return true;
        }else if(!StringUtils.equals(editTextPwd.getText().toString(),editTextPwdagain.getText().toString())){
            ToastUtils.showShort(R.string.rewrite_notsame);
            return true;
        }
        return false;
    }
}
