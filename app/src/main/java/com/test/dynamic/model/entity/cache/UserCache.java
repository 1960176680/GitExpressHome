package com.test.dynamic.model.entity.cache;

import com.test.dynamic.app.AppConst;
import com.test.dynamic.util.SPUtils;
import com.test.dynamic.util.UIUtils;

/**
 * @描述 用户缓存
 */
public class UserCache {

    public static String getId() {
        return SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.User.ID, "");
    }

    public static String getPhone() {
        return SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.User.PHONE, "");
    }

    public static String getToken() {
        return SPUtils.getInstance(UIUtils.getContext()).getString(AppConst.User.TOKEN, "");
    }

    public static void save(String phone, String key) {
        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.User.PHONE, phone);
        SPUtils.getInstance(UIUtils.getContext()).putString(AppConst.User.PASSWORD, key);
    }

    public static void clear() {
//        SPUtils.getInstance(MyApp.getInstances().getApplicationContext()).remove(AppConst.User.ID);
        SPUtils.getInstance(UIUtils.getContext()).remove(AppConst.User.PHONE);
//        SPUtils.getInstance(MyApp.getInstances().getApplicationContext()).remove(AppConst.User.TOKEN);
//        DBManager.getInstance().deleteAllUserInfo();
    }

}
