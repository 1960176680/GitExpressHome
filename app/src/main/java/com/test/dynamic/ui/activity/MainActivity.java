package com.test.dynamic.ui.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.test.dynamic.R;
import com.test.dynamic.presenter.MainAtPresenter;
import com.test.dynamic.ui.adapter.CommonFragmentPagerAdapter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.common.BaseFragment;
import com.test.dynamic.ui.fragment.FragmentFactory;
import com.test.dynamic.ui.view.IMainAtView;
import com.test.dynamic.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2018-02-06.
 */

public class MainActivity extends BaseActivity<IMainAtView,MainAtPresenter> implements ViewPager.OnPageChangeListener,IMainAtView{
    private final int GET_PERMISSION_REQUEST = 100; //权限申请自定义码
    @Bind(R.id.ibAddMenu)
    ImageButton mIbAddMenu;
    @Bind(R.id.vpContent)
    ViewPager mVpContent;
    @Bind(R.id.tvMessageNormal)
    TextView tvMessageNormal;
    @Bind(R.id.tvMeNormal)
    TextView tvMeNormal;
    @Bind(R.id.tvMessagePress)
    TextView tvMessagePress;

    @Bind(R.id.tvMePress)
    TextView tvMePress;
    @Bind(R.id.tvMessageTextNormal)
    TextView tvMessageTextNormal;

    @Bind(R.id.tvMessageTextPress)
    TextView tvMessageTextPress;

    @Bind(R.id.tvMeTextPress)
    TextView tvMeTextPress;
    @Bind(R.id.tvMeTextNormal)
    TextView tvMeTextNormal;

    @Bind(R.id.llMessage)
    LinearLayout mLlMessage;

    @Bind(R.id.llMe)
    LinearLayout mLlMe;
    private List<BaseFragment> mFragmentList;

    @Override
    public void initView() {
        setToolbarTitle(UIUtils.getString(R.string.app_name));
        //默认选中第一个
        setTransparency();
        tvMessagePress.getBackground().setAlpha(255);
        tvMessageTextPress.setTextColor(Color.argb(255, 69, 192, 26));
        //设置ViewPager的最大缓存页面
        mVpContent.setOffscreenPageLimit(3);

    }

    @Override
    public void initData() {
        mFragmentList = new ArrayList<>(4);
        mFragmentList.add(FragmentFactory.getInstance().getHomeFragment());

        mFragmentList.add(FragmentFactory.getInstance().getMeFragment());
        mVpContent.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList));
    }
    @Override
    public void initListener() {
        mLlMessage.setOnClickListener(v -> bottomBtnClick(v));

        mLlMe.setOnClickListener(v -> bottomBtnClick(v));
        mVpContent.addOnPageChangeListener(this);

//        mIbAddMenu.setOnClickListener(v -> jumpToActivity(SettingActivity.class));
        getPermissions();

    }


    /**
     * 获取权限
     */
    private void getPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager
                    .PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager
                            .PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager
                            .PERMISSION_GRANTED) {
//                startActivityForResult(new Intent(MainActivity.this, CameraActivity.class), 100);
            } else {
                //不具有获取权限，需要进行权限申请
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.CAMERA}, GET_PERMISSION_REQUEST);
            }
        } else {
//            startActivityForResult(new Intent(MainActivity.this, CameraActivity.class), 100);
        }
    }
    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == GET_PERMISSION_REQUEST) {
            int size = 0;
            if (grantResults.length >= 1) {
                int writeResult = grantResults[0];
                //读写内存权限
                boolean writeGranted = writeResult == PackageManager.PERMISSION_GRANTED;//读写内存权限
                if (!writeGranted) {
                    size++;
                }
                //录音权限
                int recordPermissionResult = grantResults[1];
                boolean recordPermissionGranted = recordPermissionResult == PackageManager.PERMISSION_GRANTED;
                if (!recordPermissionGranted) {
                    size++;
                }
                //相机权限
                int cameraPermissionResult = grantResults[2];
                boolean cameraPermissionGranted = cameraPermissionResult == PackageManager.PERMISSION_GRANTED;
                if (!cameraPermissionGranted) {
                    size++;
                }
                if (size == 0) {
//                    startActivityForResult(new Intent(MainActivity.this, CameraActivity.class), 100);
                } else {
                    Toast.makeText(this, "请到设置-权限管理中开启", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }







    @Override
    protected void onDestroy() {
        super.onDestroy();
//        for (Activity activity : activities) {
//            activity.finish();
//        }
//        unRegisterBR();
    }
    public void bottomBtnClick(View view) {
        setTransparency();
        switch (view.getId()) {
            case R.id.llMessage:
                setToolbarTitle(UIUtils.getString(R.string.app_name));
                mVpContent.setCurrentItem(0, false);
                tvMessagePress.getBackground().setAlpha(255);
                tvMessageTextPress.setTextColor(Color.argb(255, 69, 192, 26));
                break;


            case R.id.llMe:
                setToolbarTitle(UIUtils.getString(R.string.tv_title_more));
                mVpContent.setCurrentItem(3, false);
                tvMePress.getBackground().setAlpha(255);
                tvMeTextPress.setTextColor(Color.argb(255, 69, 192, 26));
                break;
        }
    }
    /**
     * 把press图片、文字全部隐藏(设置透明度)
     */
    private void setTransparency() {
        tvMessageNormal.getBackground().setAlpha(255);

        tvMeNormal.getBackground().setAlpha(255);
        tvMessagePress.getBackground().setAlpha(1);

        tvMePress.getBackground().setAlpha(1);
        tvMessageTextNormal.setTextColor(Color.argb(255, 153, 153, 153));

        tvMeTextNormal.setTextColor(Color.argb(255, 153, 153, 153));
        tvMessageTextPress.setTextColor(Color.argb(0, 69, 192, 26));

        tvMeTextPress.setTextColor(Color.argb(0, 69, 192, 26));
    }

    @Override
    protected MainAtPresenter createPresenter() {
        return new MainAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }
    @Override
    protected boolean isToolbarCanBack() {
        return false;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //根据ViewPager滑动位置更改透明度
        int diaphaneity_one = (int) (255 * positionOffset);
        int diaphaneity_two = (int) (255 * (1 - positionOffset));
        switch (position) {
            case 0:
                mIbAddMenu.setVisibility(View.GONE);
                setToolbarTitle(UIUtils.getString(R.string.app_name));
                tvMessageNormal.getBackground().setAlpha(diaphaneity_one);
                tvMessagePress.getBackground().setAlpha(diaphaneity_two);

                tvMessageTextNormal.setTextColor(Color.argb(diaphaneity_one, 153, 153, 153));
                tvMessageTextPress.setTextColor(Color.argb(diaphaneity_two, 69, 192, 26));
                tvMeTextNormal.setTextColor(Color.argb(diaphaneity_two, 153, 153, 153));
                tvMeTextPress.setTextColor(Color.argb(diaphaneity_one, 69, 192, 26));
                tvMeNormal.getBackground().setAlpha(diaphaneity_two);
                tvMePress.getBackground().setAlpha(diaphaneity_one);
                break;
            case 1:
                setToolbarTitle(UIUtils.getString(R.string.tv_title_more));
                break;
        }
    }

    @Override
    public void onPageSelected(int position) {
        if (position == 1) {
            //如果是“通讯录”页被选中，则显示快速导航条
//            FragmentFactory.getInstance().getContactsFragment().showQuickIndexBar(true);
        } else {
//            FragmentFactory.getInstance().getContactsFragment().showQuickIndexBar(false);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }


    @Override
    public TextView getTvMessageCount() {
        return null;
    }
}
