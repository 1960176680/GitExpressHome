package com.test.dynamic.presenter;
import com.test.dynamic.presenter.base.BasePresenter;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IMeFgView;
import com.test.dynamic.util.LogUtils;
import com.test.dynamic.util.UIUtils;

public class MeFgPresenter extends BasePresenter<IMeFgView> {

//    private UserInfo mUserInfo;
    private boolean isFirst = true;

    public MeFgPresenter(BaseActivity context) {
        super(context);
    }

//    public void loadUserInfo() {
//        mUserInfo = DBManager.getInstance().getUserInfo(UserCache.getId());
//        if (mUserInfo == null || isFirst) {
//            isFirst = false;
//            ApiRetrofit.getInstance().getUserInfoById(UserCache.getId())
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(getUserInfoByIdResponse -> {
//                        if (getUserInfoByIdResponse != null && getUserInfoByIdResponse.getCode() == 200) {
//                            GetUserInfoByIdResponse.ResultEntity result = getUserInfoByIdResponse.getResult();
//
//                            mUserInfo = new UserInfo(UserCache.getId(), result.getNickname(), Uri.parse(result.getPortraitUri()));
//                            if (TextUtils.isEmpty(mUserInfo.getPortraitUri().toString())) {
//                                mUserInfo.setPortraitUri(Uri.parse(DBManager.getInstance().getPortraitUri(mUserInfo)));
//                            }
//
//                            DBManager.getInstance().saveOrUpdateFriend(new Friend(mUserInfo.getUserId(), mUserInfo.getName(), mUserInfo.getPortraitUri().toString()));
//                            fillView();
//                        }
//                    }, this::loadError);
//        } else {
//            fillView();
//        }
//    }

    public void refreshUserInfo() {
//        UserInfo userInfo = DBManager.getInstance().getUserInfo(UserCache.getId());
//        if (userInfo == null) {
//            loadUserInfo();
//        } else {
//            mUserInfo = userInfo;
//        }
    }

    public void fillView() {
//        if (mUserInfo != null) {
//            Glide.with(mContext).load(mUserInfo.getPortraitUri()).centerCrop().into(getView().getIvHeader());
//            getView().getTvAccount().setText(UIUtils.getString(R.string.my_chat_account, mUserInfo.getUserId()));
//            getView().getTvName().setText(mUserInfo.getName());
//        }
    }

    private void loadError(Throwable throwable) {
        LogUtils.sf(throwable.getLocalizedMessage());
        UIUtils.showToast(throwable.getLocalizedMessage());
    }
    public void resetKey(){
//        mContext.jumpToActivity(SettingPasswordActivity.class);
    }
}
