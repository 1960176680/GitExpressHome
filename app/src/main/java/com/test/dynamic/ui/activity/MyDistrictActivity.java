package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.MyDistrictAtPresenter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IMyDistrictAtView;

/**
 * Created by Administrator on 2018-03-15.
 */
public class MyDistrictActivity extends BaseActivity<IMyDistrictAtView,MyDistrictAtPresenter> {
    @Override
    protected MyDistrictAtPresenter createPresenter() {
        return new MyDistrictAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_mydistrict;
    }
}
