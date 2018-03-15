package com.test.dynamic.ui.activity;

import android.content.Intent;
import android.widget.Button;

import com.test.dynamic.R;
import com.test.dynamic.app.MyApp;
import com.test.dynamic.presenter.RoleAtPresenter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IRoleAtView;
import com.test.dynamic.util.LogUtils;
import com.test.dynamic.util.SPUtils;

import butterknife.Bind;

/**
 * Created by Administrator on 2018-03-13.
 */

public class RoleActivity extends BaseActivity<IRoleAtView,RoleAtPresenter> {
    @Bind(R.id.btnUser)
    Button btnUser;
    @Bind(R.id.btnExpresser)
    Button btnExpresser;
    @Override
    public void init() {
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
    }

    @Override
    public void initView() {
        LogUtils.i(getTaskId()+"----roleactivity");
    }

    @Override
    public void initListener() {
        btnUser.setOnClickListener(v -> {
            SPUtils.getInstance(RoleActivity.this).putString("role","user");
            MyApp.activities.clear();
            jumpToActivityAndClearTask(MainActivity.class);
            finish();
        });

        btnExpresser.setOnClickListener(v -> {
            SPUtils.getInstance(RoleActivity.this).putString("role","expresser");
            jumpToActivityAndClearTask(MainActivity.class);
        });
    }


    @Override
    protected RoleAtPresenter createPresenter() {
        return new RoleAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_role;
    }
    @Override
    protected boolean isToolbarCanBack() {
        return false;
    }

}
