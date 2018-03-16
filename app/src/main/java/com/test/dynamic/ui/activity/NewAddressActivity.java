package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.NewAddressAtPresenter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.INewAddressAtView;

/**
 * Created by Administrator on 2018-03-16.
 */

public class NewAddressActivity extends BaseActivity<INewAddressAtView,NewAddressAtPresenter> {

    @Override
    public void initView() {
        setToolbarTitle("新增地址");
    }

    @Override
    protected NewAddressAtPresenter createPresenter() {
        return new NewAddressAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_newaddress;
    }
}
