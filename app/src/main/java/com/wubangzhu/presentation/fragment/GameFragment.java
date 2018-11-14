package com.wubangzhu.presentation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubangzhu.R;

import butterknife.ButterKnife;

/**
 * 猜谜主界面
 */
public class GameFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        initData();

        return rootView;
    }

    private void initData() {
    }

    private void initView() {
    }
}
