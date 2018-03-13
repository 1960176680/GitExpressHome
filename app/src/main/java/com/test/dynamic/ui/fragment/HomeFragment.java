package com.test.dynamic.ui.fragment;

import android.view.View;

import com.test.dynamic.R;
import com.test.dynamic.model.entity.cache.UserCache;
import com.test.dynamic.presenter.HomeFgPresenter;
import com.test.dynamic.ui.activity.MainActivity;
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
    protected HomeFgPresenter createPresenter() {
        return new HomeFgPresenter(((MainActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_home;
    }
}
