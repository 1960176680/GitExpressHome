package com.test.dynamic.ui.fragment.myaddress;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lqr.recyclerview.LQRRecyclerView;
import com.test.dynamic.R;
import com.test.dynamic.presenter.RecAddressFgPresent;
import com.test.dynamic.ui.activity.MyAddressActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.view.IRecAddressFgView;
import com.test.dynamic.util.UIUtils;

import butterknife.Bind;

/**
 * Created by Administrator on 2018-03-13.
 */

public class RecAddressFragment extends BaseFragment<IRecAddressFgView,RecAddressFgPresent> implements IRecAddressFgView{
    @Bind(R.id.recyclerview)
    LQRRecyclerView mLQRRecyclerView;
    Button mFooterView;
    @Override
    public void initView(View rootView) {

        mFooterView = new Button(getContext());
        mFooterView.setBackgroundResource(R.drawable.btn_selector);
        mFooterView.setText("新增");
        mFooterView.setTextSize(UIUtils.sp2px(8));
        mFooterView.setTextColor(UIUtils.getResource().getColorStateList(R.color.button_text));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, UIUtils.dip2Px(50));
        params.leftMargin=UIUtils.dip2Px(8);
        params.rightMargin=UIUtils.dip2Px(8);
        params.topMargin=UIUtils.dip2Px(20);
        mFooterView.setLayoutParams(params);
        mFooterView.setGravity(Gravity.CENTER);

    }

    @Override
    public void initData() {
        mPresenter.getConversation();
    }

    @Override
    protected RecAddressFgPresent createPresenter() {
        return new RecAddressFgPresent(((MyAddressActivity) getActivity()));
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_address;
    }

    @Override
    public LQRRecyclerView getRecyclerView() {
        return mLQRRecyclerView;
    }

    @Override
    public Button getFooterView() {
        return mFooterView;
    }
}
