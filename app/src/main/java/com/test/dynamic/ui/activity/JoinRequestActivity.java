package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.JoinRequestAtPresenter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IJoinRequestAtView;

/**
 * Created by Administrator on 2018-03-15.
 */
public class JoinRequestActivity extends BaseActivity<IJoinRequestAtView,JoinRequestAtPresenter> {


    @Override
    protected JoinRequestAtPresenter createPresenter() {
        return new JoinRequestAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_joinrequest;
    }
}
