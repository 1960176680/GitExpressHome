package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.SettingAtPresent;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.ISettingAtView;

/**
 * Created by Administrator on 2018-03-14.
 */

public class SettingActivity extends BaseActivity<ISettingAtView,SettingAtPresent> implements ISettingAtView  {

    @Override
    public void initView() {
        setToolbarTitle("设置");
    }

    @Override
    protected SettingAtPresent createPresenter() {
        return new SettingAtPresent(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_setting;
    }
}
