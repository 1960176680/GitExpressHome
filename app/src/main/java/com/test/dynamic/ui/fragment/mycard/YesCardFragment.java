package com.test.dynamic.ui.fragment.mycard;

import com.test.dynamic.R;
import com.test.dynamic.presenter.YesCardFgpresenter;
import com.test.dynamic.ui.activity.MyDistrictActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.IYesCardFgView;

/**
 * Created by Administrator on 2018-03-16.
 */

public class YesCardFragment extends BaseFragment<IYesCardFgView,YesCardFgpresenter> {


    @Override
    protected YesCardFgpresenter createPresenter() {
        return new YesCardFgpresenter(((MyDistrictActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_yescard;
    }
}
