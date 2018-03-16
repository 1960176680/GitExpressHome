package com.test.dynamic.ui.fragment.joinrequest;

import com.test.dynamic.R;
import com.test.dynamic.presenter.QueryResultFgPresenter;
import com.test.dynamic.ui.activity.JoinRequestActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.IQueryResultFgView;

/**
 * Created by Administrator on 2018-03-16.
 */

public class QueryResultFragment extends BaseFragment<IQueryResultFgView,QueryResultFgPresenter> implements IQueryResultFgView{
    @Override
    protected QueryResultFgPresenter createPresenter() {
        return new QueryResultFgPresenter(((JoinRequestActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_queryresult;
    }
}
