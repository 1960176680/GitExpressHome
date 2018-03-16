package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.MyInfoAtPresenter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IMyInfoAtView;

/**
 * Created by Administrator on 2018-03-15.
 */

public class MyInfoActivity extends BaseActivity<IMyInfoAtView,MyInfoAtPresenter> {

    @Override
    public void initView() {
        setToolbarTitle("我的信息");
    }

    @Override
    protected MyInfoAtPresenter createPresenter() {
        return new MyInfoAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_myinfo;
    }
}
