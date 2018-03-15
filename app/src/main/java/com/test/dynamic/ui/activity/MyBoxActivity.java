package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.MyBoxAtPresenter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IMyBoxAtView;

/**
 * Created by Administrator on 2018-03-14.
 */

public class MyBoxActivity extends BaseActivity<IMyBoxAtView,MyBoxAtPresenter>{

    @Override
    public void initView() {
         setToolbarTitle("我的箱子");
    }

    @Override
    protected MyBoxAtPresenter createPresenter() {
        return new MyBoxAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_mybox;
    }
}
