package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.BindNewBoxAtPresent;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IBindNewBoxAtView;

/**
 * Created by Administrator on 2018-03-14.
 */

public class BindNewBoxActivity extends BaseActivity<IBindNewBoxAtView,BindNewBoxAtPresent> implements IBindNewBoxAtView{

    @Override
    public void initView() {
        setToolbarTitle("绑定箱子");
    }

    @Override
    protected BindNewBoxAtPresent createPresenter() {
        return new BindNewBoxAtPresent(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_bindnewbox;
    }
}
