package com.test.dynamic.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.test.dynamic.R;
import com.test.dynamic.model.entity.cache.UserCache;
import com.test.dynamic.presenter.HomeFgPresenter;
import com.test.dynamic.ui.activity.MainActivity;
import com.test.dynamic.ui.activity.ScanActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.IHomeFgView;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.Bind;

/**
 * Created by Administrator on 2018-03-12.
 */
public class HomeFragment extends BaseFragment<IHomeFgView, HomeFgPresenter> implements IHomeFgView {
    @Bind(R.id.lineUser)
    AutoLinearLayout lineUser;
    @Bind(R.id.lineExpresser)
    AutoLinearLayout lineExpresser;

    @Bind(R.id.ivScan)
    ImageView ivScan;
    @Bind(R.id.etScan)
    EditText etScan;
    private final int REQUEST_IN = 0;
    @Override
    public void initView(View rootView) {
        String role=UserCache.getRole();
        if (role.equals("user")){
            lineUser.setVisibility(View.VISIBLE);
        }else{
            lineExpresser.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void initListener() {
        ivScan.setOnClickListener(v -> {
            Intent intent=new Intent(this.getActivity(),ScanActivity.class);
            startActivityForResult(intent,REQUEST_IN);
        });
    }

    @Override
    protected HomeFgPresenter createPresenter() {
        return new HomeFgPresenter(((MainActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_home;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        扫描条码
        if (requestCode==0&&resultCode== Activity.RESULT_OK){
            String result=data.getStringExtra("result");
            etScan.setText(result);
        }

    }


}
