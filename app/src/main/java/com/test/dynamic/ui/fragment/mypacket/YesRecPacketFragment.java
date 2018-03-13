package com.test.dynamic.ui.fragment.mypacket;

import com.test.dynamic.R;
import com.test.dynamic.presenter.YesRecPacketFgPresent;
import com.test.dynamic.ui.activity.MyPacketActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.IYesRecPacketFgView;

/**
 * Created by Administrator on 2018-03-13.
 */

public class YesRecPacketFragment extends BaseFragment<IYesRecPacketFgView,YesRecPacketFgPresent>{
    @Override
    protected YesRecPacketFgPresent createPresenter() {
        return new YesRecPacketFgPresent(((MyPacketActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_yesrecpacket;
    }

}
