package com.test.dynamic.ui.fragment;

import com.test.dynamic.ui.fragment.mypacket.NoRecPacketFragment;
import com.test.dynamic.ui.fragment.mypacket.YesRecPacketFragment;

public class FragmentFactory {

    static FragmentFactory mInstance;

    private FragmentFactory() {
    }

    public static FragmentFactory getInstance() {
        if (mInstance == null) {
            synchronized (FragmentFactory.class) {
                if (mInstance == null) {
                    mInstance = new FragmentFactory();
                }
            }
        }
        return mInstance;
    }

    private HomeFragment mHomeFragment;
    private MeFragment mMeFragment;

    private YesRecPacketFragment mYesRecPacketFragment;
    private NoRecPacketFragment mNoRecPacketFragment;


    public HomeFragment getHomeFragment() {
        if (mHomeFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
            }
        }
        return mHomeFragment;
    }

    public MeFragment getMeFragment() {
        if (mMeFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mMeFragment == null) {
                    mMeFragment = new MeFragment();
                }
            }
        }
        return mMeFragment;
    }


    public YesRecPacketFragment getYesRecPacketFragment() {
        if (mYesRecPacketFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mYesRecPacketFragment == null) {
                    mYesRecPacketFragment = new YesRecPacketFragment();
                }
            }
        }
        return mYesRecPacketFragment;
    }



    public NoRecPacketFragment getNoRecPacketFragment() {
        if (mNoRecPacketFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mNoRecPacketFragment == null) {
                    mNoRecPacketFragment = new NoRecPacketFragment();
                }
            }
        }
        return mNoRecPacketFragment;
    }
}
