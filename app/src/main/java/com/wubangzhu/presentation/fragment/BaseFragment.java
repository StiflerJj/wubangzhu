package com.wubangzhu.presentation.fragment;

import android.support.v4.app.Fragment;

import com.wubangzhu.presentation.activity.MainActivity;
import com.wubangzhu.util.HandleBackUtil;


public class BaseFragment extends Fragment implements HandleBackInterface{
    @Override
    public boolean onBackPressed() {
        return HandleBackUtil.handleBackPress(this);
    }

    public void updateFragment(Fragment fragment, int index){
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.updateFragment(fragment,index);
    }
}
