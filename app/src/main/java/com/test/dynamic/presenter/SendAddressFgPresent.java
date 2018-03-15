package com.test.dynamic.presenter;

import com.lqr.adapter.LQRAdapterForRecyclerView;
import com.lqr.adapter.LQRHeaderAndFooterAdapter;
import com.lqr.adapter.LQRViewHolderForRecyclerView;
import com.test.dynamic.R;
import com.test.dynamic.model.entity.MyAddressBean;
import com.test.dynamic.presenter.base.BasePresenter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.ISendAddressFgView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-03-14.
 */

public class SendAddressFgPresent extends BasePresenter<ISendAddressFgView> {
    private LQRHeaderAndFooterAdapter mAdapter;
    private List<MyAddressBean> mData = new ArrayList<>();
    public SendAddressFgPresent(BaseActivity context) {
        super(context);
    }

    public void getConversation() {
        setAdapter();
    }

    private void setAdapter() {
        if (mAdapter == null) {
            LQRAdapterForRecyclerView adapter = new LQRAdapterForRecyclerView<MyAddressBean>(mContext, mData, R.layout.item_myaddress) {
                @Override
                public void convert(LQRViewHolderForRecyclerView helper, MyAddressBean item, int position) {
                    helper.setText(R.id.tvName, item.getName());
                    helper.setText(R.id.tvAddress, item.getAddress());
                }
            };
            adapter.addFooterView(getView().getFooterView());
            mAdapter = adapter.getHeaderAndFooterAdapter();
            getView().getRecyclerView().setAdapter(mAdapter);
//        ((LQRAdapterForRecyclerView) mAdapter.getInnerAdapter()).setOnItemClickListener((lqrViewHolder, viewGroup, view, i) -> {
//            Intent intent = new Intent(mContext, UserInfoActivity.class);
//            intent.putExtra("userInfo", DBManager.getInstance().getUserInfo(mData.get(i - 1).getUserId()));//-1是因为有头部
//            mContext.jumpToActivity(intent);
//        });
        }
    }
}
