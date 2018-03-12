package com.test.dynamic.ui.fragment;

import com.test.dynamic.R;
import com.test.dynamic.presenter.HomeFgPresenter;
import com.test.dynamic.ui.activity.MainActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.IHomeFgView;

/**
 * Created by Administrator on 2018-03-12.
 */
public class HomeFragment extends BaseFragment<IHomeFgView, HomeFgPresenter> implements IHomeFgView {


    @Override
    protected HomeFgPresenter createPresenter() {
        return new HomeFgPresenter(((MainActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_home;
    }
}
