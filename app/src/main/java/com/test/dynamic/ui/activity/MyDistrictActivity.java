package com.test.dynamic.ui.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.dynamic.R;
import com.test.dynamic.presenter.MyDistrictAtPresenter;
import com.test.dynamic.ui.adapter.CommonFragmentPagerAdapter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.fragment.FragmentFactory;
import com.test.dynamic.ui.view.IMyDistrictAtView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2018-03-15.
 */
public class MyDistrictActivity extends BaseActivity<IMyDistrictAtView,MyDistrictAtPresenter> implements IMyDistrictAtView,ViewPager.OnPageChangeListener{

    @Bind(R.id.vp_record)
    ViewPager vp_record;
    @Bind(R.id.tv_unupload)
    TextView tv_unupload;
    @Bind(R.id.tv_upload)
    TextView tv_upload;
    @Bind(R.id.view_line)
    View view_line;

    private List<BaseFragment> fragmentList;
    private int outMetrics;
    @Override
    public void initView() {
        setToolbarTitle("我负责的小区");
        initLine();
        vp_record.setOffscreenPageLimit(1);
    }

    @Override
    public void initListener() {
        tv_unupload.setOnClickListener(v -> topBtnClick(v));
        tv_upload.setOnClickListener(v -> topBtnClick(v));
        vp_record.addOnPageChangeListener(this);
    }

    @Override
    public void initData() {
        fragmentList=new ArrayList<>();
        fragmentList.add(FragmentFactory.getInstance().getYesCardFragment());
        fragmentList.add(FragmentFactory.getInstance().getNoCardFragment());
        vp_record.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(),fragmentList));
    }
    private void initLine() {
        outMetrics = getWindowManager().getDefaultDisplay().getWidth();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view_line.getLayoutParams();
        params.width = outMetrics / 2;
        view_line.setLayoutParams(params);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LinearLayout.LayoutParams params= ((LinearLayout.LayoutParams) view_line.getLayoutParams());
        params.leftMargin = (int) (positionOffset * outMetrics / 2 + position * outMetrics / 2);
        view_line.setLayoutParams(params);
    }

    @Override
    public void onPageSelected(int position) {
        if (position==0){
            tv_unupload.setEnabled(false);
            tv_upload.setEnabled(true);
//            unUpLoadDataFragment.initFragmentData();
        }else if (position==1){
            tv_upload.setEnabled(false);
            tv_unupload.setEnabled(true);
//            upLoadDataFragment.initFragmentData();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void topBtnClick(View view){
        switch (view.getId()) {
            case R.id.tv_unupload:
                vp_record.setCurrentItem(0,false);

                break;
            case R.id.tv_upload:
                vp_record.setCurrentItem(1,false);
                break;
        }

    }




    @Override
    protected MyDistrictAtPresenter createPresenter() {
        return new MyDistrictAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_mydistrict;
    }
}
