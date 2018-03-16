package com.test.dynamic.ui.fragment;

import com.test.dynamic.ui.fragment.joinrequest.ApplyedFragment;
import com.test.dynamic.ui.fragment.joinrequest.NearbyFragment;
import com.test.dynamic.ui.fragment.joinrequest.QueryResultFragment;
import com.test.dynamic.ui.fragment.myaddress.RecAddressFragment;
import com.test.dynamic.ui.fragment.myaddress.SendAddressFragment;
import com.test.dynamic.ui.fragment.mycard.NoCardFragment;
import com.test.dynamic.ui.fragment.mycard.YesCardFragment;
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

    private RecAddressFragment mRecAddressFragment;
    private SendAddressFragment mSendAddressFragment;

    private YesCardFragment mYesCardFragment;
    private NoCardFragment mNoCardFragment;

    private QueryResultFragment mQueryResultFragment;
    private NearbyFragment mNearbyFragment;
    private ApplyedFragment mApplyedFragment;


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


    public RecAddressFragment getRecAddressFragment() {
        if (mRecAddressFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mRecAddressFragment == null) {
                    mRecAddressFragment = new RecAddressFragment();
                }
            }
        }
        return mRecAddressFragment;
    }


    public SendAddressFragment getSendAddressFragment() {
        if (mSendAddressFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mSendAddressFragment == null) {
                    mSendAddressFragment = new SendAddressFragment();
                }
            }
        }
        return mSendAddressFragment;
    }

    public YesCardFragment getYesCardFragment() {
        if (mYesCardFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mYesCardFragment == null) {
                    mYesCardFragment = new YesCardFragment();
                }
            }
        }
        return mYesCardFragment;
    }
    public NoCardFragment getNoCardFragment() {
        if (mNoCardFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mNoCardFragment == null) {
                    mNoCardFragment = new NoCardFragment();
                }
            }
        }
        return mNoCardFragment;
    }


    public QueryResultFragment getQueryResultFragment() {
        if (mQueryResultFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mQueryResultFragment == null) {
                    mQueryResultFragment = new QueryResultFragment();
                }
            }
        }
        return mQueryResultFragment;
    }
    public NearbyFragment getNearbyFragment() {
        if (mNearbyFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mNearbyFragment == null) {
                    mNearbyFragment = new NearbyFragment();
                }
            }
        }
        return mNearbyFragment;
    }
    public ApplyedFragment getApplyedFragment() {
        if (mApplyedFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mApplyedFragment == null) {
                    mApplyedFragment = new ApplyedFragment();
                }
            }
        }
        return mApplyedFragment;
    }
}
