package com.test.dynamic.ui.fragment.mycard;

import com.test.dynamic.R;
import com.test.dynamic.presenter.NoCardFgpresenter;
import com.test.dynamic.ui.activity.MyDistrictActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.INoCardFgView;

/**
 * Created by Administrator on 2018-03-16.
 */

public class NoCardFragment extends BaseFragment<INoCardFgView,NoCardFgpresenter>{


    @Override
    protected NoCardFgpresenter createPresenter() {
        return new NoCardFgpresenter(((MyDistrictActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_nocard;
    }
}
