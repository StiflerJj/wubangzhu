package com.wubangzhu.presentation.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.YLClient;
import com.wubangzhu.domain.http.response.login.AllGoods;
import com.wubangzhu.domain.http.response.login.AllGoods.ShopmodelsBean;
import com.wubangzhu.domain.http.response.login.BaseResponse;
import com.wubangzhu.domain.http.response.login.StartShopResponse;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class FreePlayActivity extends AppCompatActivity {
    @BindView(R.id.img_freerule)
    ImageView imgFree;
    @BindView(R.id.goodname_free)
    TextView goodname_free;
    @BindView(R.id.goodinfo_free)
    TextView goodinfo_free;
    @BindView(R.id.yuanjiafree)
    TextView yuanjiafree;
    @BindView(R.id.goodprice_free)
    TextView goodprice_free;
    ShopmodelsBean bean;
    MaterialDialog dialog;
    View inputViewFree;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freeplay);
        ButterKnife.bind(this);
        bean = (ShopmodelsBean) getIntent().getSerializableExtra("freegood");
        goodname_free.setText(bean.getName());
        goodinfo_free.setText(bean.getName());
        yuanjiafree.setText("原价:");
        goodprice_free.setText("￥"+bean.getPrice());
        inputViewFree = LayoutInflater.from(this).inflate(R.layout.view_guessfree, null);
    }
    @OnClick({R.id.freerule,R.id.img_freerule,R.id.freeplay_btn,R.id.back_free}) void onclick(View v){
        switch (v.getId()){
            case R.id.freerule:
                imgFree.setVisibility(View.VISIBLE);
                break;
            case R.id.img_freerule:
                imgFree.setVisibility(View.GONE);
                break;
            case R.id.back_free:
                finish();
                break;
            case R.id.freeplay_btn:
                new YLClient().poststartShop(ShareData.getShareStringData(ShareKeys.Login_UKEY), ShareData.getShareIntData(ShareKeys.Login_UserId),
                                        bean.getId(), new Callback2<StartShopResponse>() {
                                            @Override
                                            public void onFailure(RetrofitError retrofitError) {

                                            }

                                            @Override
                                            public void onSuccess(final StartShopResponse response, Response response2) throws InterruptedException, JSONException {

                                                if (response != null && response.getCode() == 0) {
                                                    dialog = new MaterialDialog.Builder(FreePlayActivity.this)
                                                            .customView(inputViewFree, false).show();
                                                    dialog.setCancelable(false);
                                                    dialog.getCustomView().findViewById(R.id.jingcaitext).setOnTouchListener(new View.OnTouchListener() {
                                                        @Override
                                                        public boolean onTouch(View view, MotionEvent event) {
                                                            if (event.getX() > ((TextView)dialog.getCustomView().findViewById(R.id.jingcaitext)).getWidth()
                                                                    - ((TextView)dialog.getCustomView().findViewById(R.id.jingcaitext)).getPaddingRight()
                                                                    - 60){
                                                                dialog.dismiss();
                                                            }
                                                            return false;

                                                        }
                                                    });
                                                    ((EditText)dialog.getCustomView().findViewById(R.id.input_guessfree)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
                                                        @Override
                                                        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                                                            if (i == EditorInfo.IME_ACTION_DONE) {
                                                                String number = ((EditText)dialog.getCustomView().findViewById(R.id.input_guessfree)).getText().toString();

                                                                if(number.length()==0){
                                                                    ToastUtils.showShort(R.string.gameinfo_biao_content_null);
                                                                    return false;
                                                                }
                                                                new YLClient().postguessShop(ShareData.getShareStringData(ShareKeys.Login_UKEY), response.getShmhistory().getId(),
                                                                        number, new Callback2<BaseResponse>() {
                                                                            @Override
                                                                            public void onFailure(RetrofitError retrofitError) {

                                                                            }

                                                                            @Override
                                                                            public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {
                                                                                ((TextView)dialog.getCustomView().findViewById(R.id.tips_guessfree)).setText(response.getMessage());
                                                                            }
                                                                        });

                                                            }
                                                            return false;
                                                        }
                                                    });

                                                    dialog.getCustomView().findViewById(R.id.btn_guessfree).setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            String number = ((EditText)dialog.getCustomView().findViewById(R.id.input_guessfree)).getText().toString();

                                                            if(number.length()==0){
                                                                ToastUtils.showShort(R.string.gameinfo_biao_content_null);
                                                                return;
                                                            }
                                                            new YLClient().postguessShop(ShareData.getShareStringData(ShareKeys.Login_UKEY), response.getShmhistory().getId(),
                                                                    number, new Callback2<BaseResponse>() {
                                                                        @Override
                                                                        public void onFailure(RetrofitError retrofitError) {

                                                                        }

                                                                        @Override
                                                                        public void onSuccess(BaseResponse response, Response response2) throws InterruptedException, JSONException {

                                                                        }
                                                                    });
                                                        }
                                                    });
                                                    dialog.getCustomView().findViewById(R.id.btn_guessfreecancel).setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            dialog.dismiss();
                                                        }
                                                    });

                                                }
                                            }
                                        });
                break;
            default:
                break;
        }

    }
}
