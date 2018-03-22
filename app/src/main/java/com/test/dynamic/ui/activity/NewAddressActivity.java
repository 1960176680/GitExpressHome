package com.test.dynamic.ui.activity;

import android.widget.TextView;

import com.test.dynamic.R;
import com.test.dynamic.presenter.NewAddressAtPresenter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.INewAddressAtView;

import butterknife.Bind;

/**
 * Created by Administrator on 2018-03-16.
 */

public class NewAddressActivity extends BaseActivity<INewAddressAtView,NewAddressAtPresenter> implements INewAddressAtView{
    @Bind(R.id.selectAddr)
    TextView selectAddr;
    @Override
    public void initView() {
        setToolbarTitle("新增地址");
    }
    @Override
    public void initData() {
        mPresenter.loadAddr();
    }
    @Override
    public void initListener() {
        selectAddr.setOnClickListener(v -> {
            mPresenter.showAddr();
        });
    }



    @Override
    protected NewAddressAtPresenter createPresenter() {
        return new NewAddressAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_newaddress;
    }

    @Override
    public TextView getSelectAddr() {
        return selectAddr;
    }
}
