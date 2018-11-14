package com.wubangzhu.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wubangzhu.R;
import com.wubangzhu.domain.http.Callback2;
import com.wubangzhu.domain.http.api.login.LoginClient;
import com.wubangzhu.domain.http.response.login.UserInfoResponse;
import com.wubangzhu.util.ShareData;
import com.wubangzhu.util.ShareKeys;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UserInfoFragment extends BaseFragment {
    @BindView(R.id.info_avatar)
    ImageView mAvatar;
    @BindView(R.id.info_phone)
    TextView mPhone;
    @BindView(R.id.info_tgid)
    TextView mTgid;
    @BindView(R.id.info_ticketA)
    TextView mTicketA;
    @BindView(R.id.info_ticketB)
    TextView mTicketB;
    @BindView(R.id.info_totalincome)
    TextView mTotalIncome;
    @BindView(R.id.info_dayincome)
    TextView mDayIncome;
    @BindView(R.id.info_totalpeople)
    TextView mTotalPeople;
    @BindView(R.id.info_daypeople)
    TextView mDayPeople;
    @BindView(R.id.info_tgbtn)
    Button mTgbtn;
    @BindView(R.id.info_buytiket)
    Button mBuybtn;
    @BindView(R.id.info_waitbiao)
    RecyclerView mWaitBiao;
    @BindView(R.id.info_zhongbiao)
    RecyclerView mZhongBiao;
    @BindView(R.id.info_buyhistorylist)
    RecyclerView mBuyHistory;



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
