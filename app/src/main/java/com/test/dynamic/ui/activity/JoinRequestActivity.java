package com.test.dynamic.ui.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.dynamic.R;
import com.test.dynamic.presenter.JoinRequestAtPresenter;
import com.test.dynamic.ui.adapter.CommonFragmentPagerAdapter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.fragment.FragmentFactory;
import com.test.dynamic.ui.view.IJoinRequestAtView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2018-03-15.
 */
public class JoinRequestActivity extends BaseActivity<IJoinRequestAtView,JoinRequestAtPresenter> implements IJoinRequestAtView,ViewPager.OnPageChangeListener {
    @Bind(R.id.vp_record)
    ViewPager vp_record;
    @Bind(R.id.tvNearby)
    TextView tvNearby;
    @Bind(R.id.tvQueryResult)
    TextView tvQueryResult;
    @Bind(R.id.tvApplyed)
    TextView tvApplyed;


    @Bind(R.id.view_line)
    View view_line;

    private List<BaseFragment> fragmentList;
    private int outMetrics;
    @Override
    public void initView() {
        setToolbarTitle("申请入驻");
        initLine();
        vp_record.setOffscreenPageLimit(2);
    }

    @Override
    public void initListener() {
        tvNearby.setOnClickListener(v -> topBtnClick(v));
        tvQueryResult.setOnClickListener(v -> topBtnClick(v));
        vp_record.addOnPageChangeListener(this);
    }

    @Override
    public void initData() {
        fragmentList=new ArrayList<>();
        fragmentList.add(FragmentFactory.getInstance().getQueryResultFragment());
        fragmentList.add(FragmentFactory.getInstance().getNearbyFragment());
        fragmentList.add(FragmentFactory.getInstance().getApplyedFragment());
        vp_record.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(),fragmentList));
        vp_record.setCurrentItem(0,false);
    }

    @Override
    protected JoinRequestAtPresenter createPresenter() {
        return new JoinRequestAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_joinrequest;
    }
    private void initLine() {
        outMetrics = getWindowManager().getDefaultDisplay().getWidth();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view_line.getLayoutParams();
        params.width = outMetrics / 3;
        view_line.setLayoutParams(params);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LinearLayout.LayoutParams params= ((LinearLayout.LayoutParams) view_line.getLayoutParams());
        params.leftMargin = (int) (positionOffset * outMetrics / 3 + position * outMetrics / 3);
        view_line.setLayoutParams(params);
    }

    @Override
    public void onPageSelected(int position) {
        if (position==0){
            tvQueryResult.setEnabled(false);
            tvNearby.setEnabled(true);
            tvApplyed.setEnabled(true);
//            unUpLoadDataFragment.initFragmentData();
        }else if (position==1){
            tvQueryResult.setEnabled(true);
            tvNearby.setEnabled(false);
            tvApplyed.setEnabled(true);
//            upLoadDataFragment.initFragmentData();
        }else if (position==2){
            tvQueryResult.setEnabled(true);
            tvNearby.setEnabled(true);
            tvApplyed.setEnabled(false);
//            upLoadDataFragment.initFragmentData();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void topBtnClick(View view){
        switch (view.getId()) {
            case R.id.tvQueryResult:
                vp_record.setCurrentItem(0,false);
                break;
            case R.id.tvNearby:
                vp_record.setCurrentItem(1,false);
                break;
            case R.id.tvApplyed:
                vp_record.setCurrentItem(2,false);
                break;
        }

    }
}
