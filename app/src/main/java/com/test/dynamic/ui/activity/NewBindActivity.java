package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.NewBindAtPresent;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.INewBindAtView;

/**
 * Created by Administrator on 2018-03-16.
 */

public class NewBindActivity extends BaseActivity<INewBindAtView,NewBindAtPresent> {
    @Override
    protected NewBindAtPresent createPresenter() {
        return new NewBindAtPresent(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.newbind;
    }
}
