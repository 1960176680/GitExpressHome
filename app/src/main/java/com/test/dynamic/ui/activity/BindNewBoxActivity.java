package com.test.dynamic.ui.activity;

import com.test.dynamic.R;
import com.test.dynamic.presenter.BindNewBoxAtPresent;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IBindNewBoxAtView;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.Bind;

/**
 * Created by Administrator on 2018-03-14.
 */

public class BindNewBoxActivity extends BaseActivity<IBindNewBoxAtView,BindNewBoxAtPresent> implements IBindNewBoxAtView{

    @Bind(R.id.line1)
    AutoRelativeLayout line1;
    @Bind(R.id.line2)
    AutoRelativeLayout line2;
    @Override
    public void initView() {
        setToolbarTitle("绑定箱子");
    }

    @Override
    public void initListener() {
         line1.setOnClickListener(v -> jumpToActivity(NewBindActivity.class));

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
