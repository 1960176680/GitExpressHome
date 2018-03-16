package com.test.dynamic.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.dynamic.R;
import com.test.dynamic.app.MyApp;
import com.test.dynamic.model.entity.cache.UserCache;
import com.test.dynamic.presenter.MeFgPresenter;
import com.test.dynamic.ui.activity.BindNewBoxActivity;
import com.test.dynamic.ui.activity.JoinRequestActivity;
import com.test.dynamic.ui.activity.MainActivity;
import com.test.dynamic.ui.activity.MyAddressActivity;
import com.test.dynamic.ui.activity.MyBoxActivity;
import com.test.dynamic.ui.activity.MyDistrictActivity;
import com.test.dynamic.ui.activity.MyInfoActivity;
import com.test.dynamic.ui.activity.MyPacketActivity;
import com.test.dynamic.ui.activity.RegisterActivity;
import com.test.dynamic.ui.activity.RoleActivity;
import com.test.dynamic.ui.activity.ServiceActivity;
import com.test.dynamic.ui.activity.SettingActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.IMeFgView;
import com.test.dynamic.util.LogUtils;
import com.test.dynamic.widget.CustomDialog;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.Bind;

/**
 * 我界面
 */
public class MeFragment extends BaseFragment<IMeFgView, MeFgPresenter> implements IMeFgView {

    private CustomDialog mQrCardDialog;
    @Bind(R.id.lineUser)
    LinearLayout lineUser;
    @Bind(R.id.lineExpresser)
    LinearLayout lineExpresser;

    @Bind(R.id.line1)
    AutoRelativeLayout line1;
    @Bind(R.id.line11)
    AutoRelativeLayout line11;
    @Bind(R.id.line2)
    AutoRelativeLayout line2;
    @Bind(R.id.line22)
    AutoRelativeLayout line22;
    @Bind(R.id.line3)
    AutoRelativeLayout line3;
    @Bind(R.id.line33)
    AutoRelativeLayout line33;
    @Bind(R.id.line4)
    AutoRelativeLayout line4;
    @Bind(R.id.line44)
    AutoRelativeLayout line44;
    @Bind(R.id.line5)
    AutoRelativeLayout line5;
    @Bind(R.id.line55)
    AutoRelativeLayout line55;
    @Bind(R.id.line6)
    AutoRelativeLayout line6;
    @Bind(R.id.line66)
    AutoRelativeLayout line66;
    @Bind(R.id.line7)
    AutoRelativeLayout line7;
    @Bind(R.id.line8)
    AutoRelativeLayout line8;
    @Override
    public void init() {

    }
    @Override
    public void initView(View rootView) {
        String role= UserCache.getRole();
        if (role.equals("user")){
            lineUser.setVisibility(View.VISIBLE);
        }else{
            lineExpresser.setVisibility(View.VISIBLE);
        }
//        tv_user.setText(UserCache.getPhone());
    }
    @Override
    public void initListener() {

        line1.setOnClickListener(v -> listClick(v));
        line2.setOnClickListener(v -> listClick(v));
        line3.setOnClickListener(v -> listClick(v));
        line4.setOnClickListener(v -> listClick(v));
        line5.setOnClickListener(v -> listClick(v));
        line6.setOnClickListener(v -> listClick(v));
        line7.setOnClickListener(v -> listClick(v));
        line8.setOnClickListener(v -> listClick(v));


        line11.setOnClickListener(v -> listClick(v));
        line22.setOnClickListener(v -> listClick(v));
        line33.setOnClickListener(v -> listClick(v));
        line44.setOnClickListener(v -> listClick(v));
        line55.setOnClickListener(v -> listClick(v));
        line66.setOnClickListener(v -> listClick(v));

    }

    private void listClick(View v) {
        MainActivity mainActivity= (MainActivity) getActivity();
        switch (v.getId()){
            case R.id.line1:
                mainActivity.jumpToActivity(MyPacketActivity.class);
                break;
            case R.id.line11:
                mainActivity.jumpToActivity(MyInfoActivity.class);
                break;

            case R.id.line2:
                mainActivity.jumpToActivity(MyAddressActivity.class);
                break;
            case R.id.line22:
                mainActivity.jumpToActivity(MyDistrictActivity.class);
                break;
            case R.id.line3:
                mainActivity.jumpToActivity(MyBoxActivity.class);
                break;
            case R.id.line33:
                mainActivity.jumpToActivity(JoinRequestActivity.class);
                break;
            case R.id.line4:
                mainActivity.jumpToActivity(BindNewBoxActivity.class);
                break;
            case R.id.line5:
                mainActivity.jumpToActivity(RegisterActivity.class);
                break;
            case R.id.line6:
            case R.id.line44:
                mainActivity.jumpToActivity(ServiceActivity.class);
                break;
            case R.id.line7:
            case R.id.line55:
                MyApp.activities.clear();
                mainActivity.jumpToActivityAndClearTask(RoleActivity.class);
                mainActivity.finish();
                break;
            case R.id.line8:
            case R.id.line66:
                mainActivity.jumpToActivity(SettingActivity.class);
                break;
        }
    }

    @Override
    public void initData() {
//        mPresenter.loadUserInfo();
    }





    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    private void loadQRCardError(Throwable throwable) {
        LogUtils.sf(throwable.getLocalizedMessage());
    }

    @Override
    protected MeFgPresenter createPresenter() {
        return new MeFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_more;
    }

    @Override
    public ImageView getIvHeader() {
        return null;
    }

    @Override
    public TextView getTvName() {
        return null;
    }

    @Override
    public TextView getTvAccount() {
        return null;
    }
}
