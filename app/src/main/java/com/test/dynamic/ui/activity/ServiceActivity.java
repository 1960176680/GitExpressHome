package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.ServiceAtPresent;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IServiceAtView;

/**
 * Created by Administrator on 2018-03-14.
 */

public class ServiceActivity extends BaseActivity<IServiceAtView,ServiceAtPresent> implements IServiceAtView  {
    @Override
    public void initView() {
        setToolbarTitle("客服");
    }

    @Override
    protected ServiceAtPresent createPresenter() {
        return new ServiceAtPresent(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_service;
    }
}
