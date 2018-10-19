package com.wubangzhu.presentation.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.LoginClient;
import com.wubangzhu.domain.http.request.login.LoginRequest;
import com.wubangzhu.domain.http.response.login.LoginResponse;
import com.wubangzhu.util.CommonUtil;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.username)
    EditText mUserName;
    @BindView(R.id.pwd)
    EditText mPassword;
    @BindView(R.id.login_btn)
    Button login;
    @BindView(R.id.tryit)
    TextView tryit;
    //密碼是否可見
    private boolean isPwdVisible = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        tryit.setText(Html.fromHtml("暂无账号，登录<font color=#ffffff>试用</font>"));
        mPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // et.getCompoundDrawables()得到一个长度为4的数组，分别表示左右上下四张图片
                Drawable drawable = mPassword.getCompoundDrawables()[2];
                //如果右边没有图片，不再处理
                if (drawable == null)
                    return false;
                //如果不是按下事件，不再处理
                if (motionEvent.getAction() != MotionEvent.ACTION_UP)
                    return false;
                if (motionEvent.getX() > mPassword.getWidth()
                        - mPassword.getPaddingRight()
                        - drawable.getIntrinsicWidth()){
                    //修改密码是否可见的状态
                    isPwdVisible = !isPwdVisible;
                    //設置密碼是否可見
                    if (isPwdVisible) {
                        //设置密码为明文，并更改眼睛图标
                        mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    } else {
                        //设置密码为暗文，并更改眼睛图标
                        mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }


                }
                return false;
            }
        });
        if(ShareData.contains(ShareKeys.authorization)){
            ActivityUtils.startActivity(MainActivity.class);
            finish();
        }



    }
    @OnClick(R.id.login_btn) void setLogin(){
        if(CommonUtil.isBlank(mUserName.getText().toString()) || CommonUtil.isBlank(mPassword.getText().toString())){
            CommonUtil.showToast(LoginActivity.this,R.string.rewrite);
        }
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName(mUserName.getText().toString());
        loginRequest.setPassWord(mPassword.getText().toString());
        LoginClient loginClient = new LoginClient();
        loginClient.postLogin(loginRequest, new Callback2<LoginResponse>() {
            @Override
            public void onFailure(RetrofitError retrofitError) {
                CommonUtil.showToast(LoginActivity.this,R.string.rewrite);
            }

            @Override
            public void onSuccess(LoginResponse response, Response response2) throws InterruptedException {
                if(response!=null && response2!=null){
                    ShareData.setShareStringData(ShareKeys.authorization, response2.getHeaders().get(3).getValue());
                    LogUtils.e(response2.getHeaders().get(3).getValue());
                    if(response.getStatus()==1){
                        if(response.getMember()!=null){
                            ShareData.setShareStringData(ShareKeys.Login_UserId,response.getMember().getId());
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            intent.putExtra("username",response.getMember().getPname());
                            intent.putExtra("id",response.getMember().getId());
                            ActivityUtils.startActivity(intent);
                        }
                    }else
                        CommonUtil.showToast(LoginActivity.this,R.string.rewrite);
                }
            }
        });
    }
    @OnClick(R.id.tryit) void setTryit(){
        CommonUtil.showToast(this,"try it");
    }
}
