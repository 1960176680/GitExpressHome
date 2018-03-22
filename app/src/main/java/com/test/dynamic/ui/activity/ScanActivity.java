package com.test.dynamic.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.test.dynamic.R;
import com.test.dynamic.presenter.ScanAtPresenter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IScanAtView;
import com.test.dynamic.util.LogUtils;
import com.test.dynamic.util.PopupWindowUtils;
import com.test.dynamic.util.UIUtils;

import butterknife.Bind;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

/**
 * @描述 扫一扫界面
 */
public class ScanActivity extends BaseActivity<IScanAtView, ScanAtPresenter> implements IScanAtView, QRCodeView.Delegate {

    public static final int IMAGE_PICKER = 100;

    @Bind(R.id.ibToolbarMore)
    ImageButton mIbToolbarMore;
    @Bind(R.id.zxingview)
    ZXingView mZxingview;

    @Bind(R.id.llSaoma)
    LinearLayout mLlSaoma;
    @Bind(R.id.llFengmian)
    LinearLayout mLlFengmian;
    @Bind(R.id.llJiejing)
    LinearLayout mLlJiejing;
    @Bind(R.id.llFanyi)
    LinearLayout mLlFanyi;

    @Bind(R.id.ivSaomaNormal)
    ImageView mIvSaomaNormal;
    @Bind(R.id.ivSaomaPress)
    ImageView mIvSaomaPress;
    @Bind(R.id.ivFengmianNormal)
    ImageView mIvFengmianNormal;
    @Bind(R.id.ivFengmianPress)
    ImageView mIvFengmianPress;
    @Bind(R.id.ivJiejingNormal)
    ImageView mIvJiejingNormal;
    @Bind(R.id.ivJiejingPress)
    ImageView mIvJiejingPress;
    @Bind(R.id.ivFanyiNormal)
    ImageView mIvFanyiNormal;
    @Bind(R.id.ivFanyiPress)
    ImageView mIvFanyiPress;
    private FrameLayout mView;
    private PopupWindow mPopupWindow;

    @Override
    public void initView() {
        selectBottomOne(0);
        mIbToolbarMore.setVisibility(View.VISIBLE);
//        NetConstant.SCAN_RESULT_OUT="";
//        NetConstant.SCAN_RESULT_QUERY="";
//        NetConstant.SCAN_RESULT="";
    }

    @Override
    public void initListener() {
        mIbToolbarMore.setOnClickListener(v -> showPopupMenu());
        mZxingview.setDelegate(this);
        mLlSaoma.setOnClickListener(v -> selectBottomOne(0));
        mLlFengmian.setOnClickListener(v -> selectBottomOne(1));
        mLlJiejing.setOnClickListener(v -> selectBottomOne(2));
        mLlFanyi.setOnClickListener(v -> selectBottomOne(3));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mZxingview.startCamera();
        mZxingview.startSpotAndShowRect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mZxingview.stopCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mZxingview.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {//返回多张照片
//            if (data != null) {
//                final ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
//                if (images != null && images.size() > 0) {
//                    //取第一张照片
//                    ThreadPoolFactory.getNormalPool().execute(new Runnable() {
//                        @Override
//                        public void run() {
//                            String result = QRCodeDecoder.syncDecodeQRCode(images.get(0).path);
//                            if (TextUtils.isEmpty(result)) {
//                                UIUtils.showToast(UIUtils.getString(R.string.scan_fail));
//                            } else {
//                                handleResult(result);
//                            }
//                        }
//                    });
//                }
//            }
//        }
    }

    @Override
    protected ScanAtPresenter createPresenter() {
        return new ScanAtPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_scan;
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        handleResult(result);
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        UIUtils.showToast(UIUtils.getString(R.string.open_camera_error));
    }

    public void selectBottomOne(int switchItem) {
        mIvSaomaPress.setVisibility(View.GONE);
        mIvFengmianPress.setVisibility(View.GONE);
        mIvJiejingPress.setVisibility(View.GONE);
        mIvFanyiPress.setVisibility(View.GONE);
        switch (switchItem) {
            case 0:
                setToolbarTitle(UIUtils.getString(R.string.qr_cord_or_bar_code));
                mIvSaomaPress.setVisibility(View.VISIBLE);
                break;
            case 1:
                setToolbarTitle(UIUtils.getString(R.string.cover_or_movie_poster));
                mIvFengmianPress.setVisibility(View.VISIBLE);
                break;
            case 2:
                setToolbarTitle(UIUtils.getString(R.string.street_scape));
                mIvJiejingPress.setVisibility(View.VISIBLE);
                break;
            case 3:
                setToolbarTitle(UIUtils.getString(R.string.translate));
                mIvFanyiPress.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void showPopupMenu() {
        if (mView == null) {
            mView = new FrameLayout(this);
            mView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            mView.setBackgroundColor(UIUtils.getColor(R.color.white));

            TextView tv = new TextView(this);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, UIUtils.dip2Px(45));
            tv.setLayoutParams(params);
            tv.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
            tv.setPadding(UIUtils.dip2Px(20), 0, 0, 0);
            tv.setTextColor(UIUtils.getColor(R.color.gray0));
            tv.setTextSize(14);
            tv.setText(UIUtils.getString(R.string.select_qr_code_from_ablum));
            mView.addView(tv);

            tv.setOnClickListener(v -> {
                mPopupWindow.dismiss();
//                Intent intent = new Intent(ScanActivity.this, ImageGridActivity.class);
//                startActivityForResult(intent, IMAGE_PICKER);
            });
        }
        mPopupWindow = PopupWindowUtils.getPopupWindowAtLocation(mView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, getWindow().getDecorView().getRootView(), Gravity.BOTTOM, 0, 0);
        mPopupWindow.setOnDismissListener(() -> PopupWindowUtils.makeWindowLight(ScanActivity.this));
        PopupWindowUtils.makeWindowDark(this);
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    private void handleResult(String result) {
        LogUtils.sf("扫描结果:" + result);
        vibrate();

        Intent intent=new Intent();
        intent.putExtra("result",result.trim());
        setResult(Activity.RESULT_OK,intent);

////        周文广
//        String type=getIntent().getStringExtra("flag");
//        if (type.equals("out")){
//            NetConstant.SCAN_RESULT_OUT="";
//            NetConstant.SCAN_RESULT_OUT=result.trim();
//        }else if (type.equals("query")){
//            NetConstant.SCAN_RESULT_QUERY="";
//            NetConstant.SCAN_RESULT_QUERY=result.trim();
//        }else if(type.equals("in")){
//            NetConstant.SCAN_RESULT="";
//            NetConstant.SCAN_RESULT=result.trim();
//        }
        finish();

        mZxingview.startSpot();
    }

    private void loadError(Throwable throwable) {
        LogUtils.sf(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
    }
}
