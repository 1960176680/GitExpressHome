package com.test.dynamic.ui.fragment.joinrequest;

import com.test.dynamic.R;
import com.test.dynamic.presenter.NearbyFgPresenter;
import com.test.dynamic.ui.activity.JoinRequestActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.INearbyFgView;

/**
 * Created by Administrator on 2018-03-16.
 */

public class NearbyFragment extends BaseFragment<INearbyFgView,NearbyFgPresenter> implements INearbyFgView{
    @Override
    protected NearbyFgPresenter createPresenter() {
        return new NearbyFgPresenter(((JoinRequestActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_nearby;
    }
}
