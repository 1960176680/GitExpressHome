package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.RegisterAtPresent;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IRegisterAtView;

/**
 * Created by Administrator on 2018-03-14.
 */

public class RegisterActivity extends BaseActivity<IRegisterAtView,RegisterAtPresent> implements IRegisterAtView {
    @Override
    public void initView() {
        setToolbarTitle("客户注册");
    }

    @Override
    protected RegisterAtPresent createPresenter() {
        return new RegisterAtPresent(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_register;
    }
}
