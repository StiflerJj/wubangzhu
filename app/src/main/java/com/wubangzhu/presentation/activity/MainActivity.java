package com.wubangzhu.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wubangzhu.R;
import com.wubangzhu.presentation.fragment.AllGoodsFragment;
import com.wubangzhu.presentation.fragment.GameFragment;
import com.wubangzhu.presentation.fragment.MainFragment;
import com.wubangzhu.presentation.fragment.UserInfoFragment;
import com.wubangzhu.presentation.widgets.NoScrollViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity{
    private SectionsPagerAdapter mSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    @BindView(R.id.container)
    NoScrollViewPager mViewPager;

    /**
     * tab
     *
     * @param savedInstanceState
     */
    @BindView(R.id.tab)
    RadioGroup mRadioGroup;
    @BindView(R.id.radio_button_home)
    RadioButton mRadioBtnMain;
    @BindView(R.id.radio_button_health)
    RadioButton mRadioBtnhealth;
    @BindView(R.id.radio_button_manage)
    RadioButton mRadioBtnmanage;
    @BindView(R.id.radio_button_info)
    RadioButton mRadioBtninfo;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
//    @BindView(R.id.drawerlayout)
//    DrawerLayout drawerLayout;
//    @BindView(R.id.nav_view)
//    NavigationView navigationView;
    ActionBarDrawerToggle mDrawerToggle;

    TextView drawerusername;
    ImageView drawerPic;



    AllGoodsFragment tab02 = new AllGoodsFragment();
    GameFragment tab03 = new GameFragment();
    UserInfoFragment tab04 = new UserInfoFragment();
    android.support.v4.app.Fragment[] fragments = { tab02, tab03, tab04};
    boolean[] fragmentsUpdateFlag = {false, false, false, false};
    String username,userid;

    public void updateFragment(android.support.v4.app.Fragment fragment, int index) {
        fragments[index] = fragment;
        fragmentsUpdateFlag[index] = true;
        mSectionsPagerAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.bind(this);
        userid = getIntent().getStringExtra("id");
        username = getIntent().getStringExtra("username");
        setSupportActionBar(toolbar);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setNoScroll(true);
        initView();
    }
    private void initView() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
//                    case R.id.radio_button_home:
//                        mSectionsPagerAdapter.getItem(0);
//                        break;
                    case R.id.radio_button_health:
                        mSectionsPagerAdapter.getItem(0);
                        break;
                    case R.id.radio_button_manage:
                        mSectionsPagerAdapter.getItem(1);
                        break;
                    case R.id.radio_button_info:
                        mSectionsPagerAdapter.getItem(2);
                        setTitle("个人中心");
                        break;
                    default:
                        break;
                }
            }
        });
        mRadioBtnhealth.setChecked(true);
    }
    @OnClick({ R.id.radio_button_health, R.id.radio_button_manage, R.id.radio_button_info})
    void onClick(View view) {
        switch (view.getId()) {
//            case R.id.radio_button_home:
//                mViewPager.setCurrentItem(0);
//                mRadioBtnMain.setChecked(true);
//
//                break;
            case R.id.radio_button_health:
                mViewPager.setCurrentItem(0);
                mRadioBtnhealth.setChecked(true);
                break;
            case R.id.radio_button_manage:
                mViewPager.setCurrentItem(1);
                mRadioBtnmanage.setChecked(true);
                break;
            case R.id.radio_button_info:
                mViewPager.setCurrentItem(2);
                mRadioBtninfo.setChecked(true);
                break;
            default:
                break;
        }
    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        FragmentManager fragmentManager;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fragmentManager = fm;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            android.support.v4.app.Fragment fragment = fragments[position % fragments.length];
//            LogUtils.i("getItem:position=" + position + ",fragment:"
//                    + fragment.getClass().getName() + ",fragment.tag="
//                    + fragment.getTag());
            return fragments[position % fragments.length];
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //得到缓存的fragment
            android.support.v4.app.Fragment fragment = (android.support.v4.app.Fragment) super.instantiateItem(container,
                    position);
            //得到tag，这点很重要
            String fragmentTag = fragment.getTag();

            if (fragmentsUpdateFlag[position % fragmentsUpdateFlag.length]) {
                //如果这个fragment需要更新

                FragmentTransaction ft = fragmentManager.beginTransaction();
                //移除旧的fragment
                ft.remove(fragment);
                //换成新的fragment
                fragment = fragments[position % fragments.length];
                //添加新fragment时必须用前面获得的tag，这点很重要
                ft.add(container.getId(), fragment, fragmentTag);
                ft.attach(fragment);
                ft.commit();

                //复位更新标志
                fragmentsUpdateFlag[position % fragmentsUpdateFlag.length] = false;
            }


            return fragment;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return fragments.length;
        }
    }
}
