package com.test.dynamic.presenter;

import android.content.Context;
import android.view.View;

import com.test.dynamic.R;
import com.test.dynamic.presenter.base.BasePresenter;
import com.test.dynamic.ui.activity.MainActivity;
import com.test.dynamic.ui.common.BaseActivity;
import com.test.dynamic.ui.view.IHomeFgView;
import com.test.dynamic.util.UIUtils;
import com.test.dynamic.widget.CustomDialog;
public class HomeFgPresenter extends BasePresenter<IHomeFgView> {

    private Context context;
//    private List<InBean> datas= new ArrayList<>();
//    private List<InBean> removeDatas= new ArrayList<>();
    private int listsize;
//    private LQRAdapterForRecyclerView<InBean> mAdapter;
    private int mUnreadCountTotal = 0;
    private CustomDialog mConversationMenuDialog;

    public HomeFgPresenter(BaseActivity context) {
        super(context);
        this.context = context;
    }

    public void getConversations() {
//        loadData();
//        this.datas=datas;
//        setAdapter(datas);
    }




    private void updateTotalUnreadView() {
        if (mUnreadCountTotal > 0) {
            ((MainActivity) mContext).getTvMessageCount().setText(mUnreadCountTotal + "");
            ((MainActivity) mContext).getTvMessageCount().setVisibility(View.VISIBLE);
            ((MainActivity) mContext).setToolbarTitle(UIUtils.getString(R.string.app_name) + "(" + mUnreadCountTotal + ")");
        } else {
            ((MainActivity) mContext).getTvMessageCount().setVisibility(View.GONE);
            ((MainActivity) mContext).setToolbarTitle(UIUtils.getString(R.string.app_name));
        }
    }

//    private void setAdapter(List<InBean> datas) {
//        if (mAdapter == null) {
//            mAdapter = new LQRAdapterForRecyclerView<InBean>(mContext, datas, R.layout.iten_in) {
//                @Override
//                public void convert(LQRViewHolderForRecyclerView helper, InBean item, int position) {
//                    TextView danHao = helper.getView(R.id.danHao);
//                    TextView states = helper.getView(R.id.states);
//                    TextView num = helper.getView(R.id.num);
//                    ImageView delete_img = helper.getView(R.id.delete_img);
//
//                    danHao.setText(item.getCode());
//                    String status=item.getStatus();
//                    if (status.equals("未上传")){
//                        states.setTextColor(Color.RED);
//                        delete_img.setVisibility(View.VISIBLE);
//                    }else {
//                        states.setTextColor(Color.GREEN);
//                        delete_img.setVisibility(View.INVISIBLE);
//                    }
//                    states.setText(status);
//                    delete_img.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//                            builder.setTitle("注意:删除操作");
//                            builder.setMessage("确定要删除吗？");
//                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    InBean inBean=datas.get(position);
//                                    InBeanDao inBeanDao=MyApp.getInstances().getDaoSession().getInBeanDao();
//                                    inBeanDao.delete(inBean);
//                                    datas.remove(position);
//                                    mAdapter.notifyDataSetChanged();
//                                }
//                            });
//                            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
//                                }
//                            });
//                            builder.show();
//                        }
//                    });
//
//
//                    int size=datas.size();
//                    num.setText(size-position+"");
//                }
//            };
//            getView().getRvRecentMessage().setAdapter(mAdapter);
//        }
//
//    }





    /**
     * 清空界面列表
     */





    public void speech(String toast) {
//        speechUtil.speakXunFei(toast);
    }


//    上面为查询

}
