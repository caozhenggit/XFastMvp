package com.caozheng.xfastmvp.demo;

import com.caozheng.xfastmvp.mvp.BasePresenter;

/**
 * @author caozheng
 * @date 2017/10/30
 *
 * describe:
 */

public class MainPresenter extends BasePresenter<MainView> {

    @Override
    public void attachView(MainView mView) {
        attachView(mView);
    }

    public void main(){
        mView.test();
    }

}
