package com.test.dynamic.ui.fragment.joinrequest;

import com.test.dynamic.R;
import com.test.dynamic.presenter.ApplyedFgPresenter;
import com.test.dynamic.ui.activity.JoinRequestActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.IApplyedFgView;

/**
 * Created by Administrator on 2018-03-16.
 */

public class ApplyedFragment extends BaseFragment<IApplyedFgView,ApplyedFgPresenter> implements IApplyedFgView{
    @Override
    protected ApplyedFgPresenter createPresenter() {
        return new ApplyedFgPresenter(((JoinRequestActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_applyed;
    }
}
