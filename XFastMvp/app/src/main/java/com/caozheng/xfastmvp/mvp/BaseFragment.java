package com.caozheng.xfastmvp.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caozheng.xfastmvp.XFastConf;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * @author caozheng
 * @date 2017/10/28
 *
 * describe:
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    public Activity mActivity;

    private View mContextView = null;

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();

        mContextView = inflater.inflate(bindLayout(), container, false);
        initView(mContextView);
        doBusiness(getActivity());
        return mContextView;
    }

    public SweetAlertDialog pDialog;


    /**
     * 绑定布局
     *
     * @return
     */
    public abstract int bindLayout();

    /**
     * 初始化控件
     *
     * @param view
     */
    public abstract void initView(final View view);

    /**
     * 业务操作
     *
     * @param mContext
     */
    public abstract void doBusiness(Context mContext);

    /**
     * View点击
     *
     * @param v
     */
    public abstract void widgetClick(View v);

    @Override
    public void onClick(View v) {
        if (fastClick()) {
            widgetClick(v);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T $(View view, int resId) {
        return (T) view.findViewById(resId);
    }

    /**
     * 日志输出
     *
     * @param msg
     */
    protected void $Log(String msg) {
        if (XFastConf.LOG) {
            Log.d(TAG, msg);
        }
    }

    /**
     * 防止快速点击
     *
     * @return
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    /**
     * 显示网络错误
     */
    public void showNetError(){

    }

    /**
     * 显示加载动画
     */
    public SweetAlertDialog showLoading(){
        pDialog = new SweetAlertDialog(mActivity, SweetAlertDialog.PROGRESS_TYPE).setTitleText("Loading");
        pDialog.getProgressHelper().setBarColor(mActivity.getResources().getColor(android.R.color.holo_blue_bright));
        pDialog.setCancelable(true);
        pDialog.setCanceledOnTouchOutside(true);
        pDialog.show();
        return pDialog;
    }

    /**
     * 显示加载动画
     *
     * @param text
     * @return
     */
    public SweetAlertDialog showLoading(String text){
        pDialog = new SweetAlertDialog(mActivity, SweetAlertDialog.PROGRESS_TYPE).setTitleText(text);
        pDialog.getProgressHelper().setBarColor(mActivity.getResources().getColor(android.R.color.holo_blue_bright));
        pDialog.setCancelable(true);
        pDialog.setCanceledOnTouchOutside(true);
        pDialog.show();
        return pDialog;
    }

    /**
     * 隐藏加载
     */
    public void hideLoading(){
        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
