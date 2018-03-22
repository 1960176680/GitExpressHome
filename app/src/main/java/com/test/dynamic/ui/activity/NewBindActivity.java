package com.test.dynamic.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.dynamic.R;
import com.test.dynamic.presenter.NewBindAtPresent;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.INewBindAtView;

import butterknife.Bind;

/**
 * Created by Administrator on 2018-03-16.
 */

public class NewBindActivity extends BaseActivity<INewBindAtView,NewBindAtPresent> implements INewBindAtView{
    @Bind(R.id.ivScan)
    ImageView ivScan;
    @Bind(R.id.etScan)
    EditText etScan;
    @Bind(R.id.tvSelectAddr)
    TextView tvSelectAddr;

    private final int REQUEST_IN = 0x0001;
    @Override
    public void initView() {
        setToolbarTitle("新绑定");
    }

    @Override
    public void initData() {
         mPresenter.loadAddr();
    }

    @Override
    public void initListener() {
        ivScan.setOnClickListener(v -> {
            Intent intent=new Intent(this,ScanActivity.class);
            startActivityForResult(intent,REQUEST_IN);
        });

        tvSelectAddr.setOnClickListener(v -> mPresenter.showAddr());
    }

    @Override
    protected NewBindAtPresent createPresenter() {
        return new NewBindAtPresent(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_newbind;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        扫描条码
        if (requestCode==REQUEST_IN&&resultCode== Activity.RESULT_OK){
            String result=data.getStringExtra("result");
            etScan.setText(result);
            etScan.setSelection(etScan.getText().length());
        }

    }

    @Override
    public TextView getSelectAddr() {
        return tvSelectAddr;
    }
}
