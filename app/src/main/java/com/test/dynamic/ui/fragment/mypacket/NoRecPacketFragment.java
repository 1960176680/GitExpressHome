package com.test.dynamic.ui.fragment.mypacket;

import com.test.dynamic.R;
import com.test.dynamic.presenter.NoRecPacketFgPresent;
import com.test.dynamic.ui.activity.MyPacketActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.INoRecPacketFgView;

/**
 * Created by Administrator on 2018-03-13.
 */

public class NoRecPacketFragment extends BaseFragment<INoRecPacketFgView,NoRecPacketFgPresent> {
    @Override
    protected NoRecPacketFgPresent createPresenter() {
        return new NoRecPacketFgPresent(((MyPacketActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_yesrecpacket;
    }
}
