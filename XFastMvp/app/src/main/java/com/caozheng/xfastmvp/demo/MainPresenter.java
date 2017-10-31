package com.caozheng.xfastmvp.demo;

import com.caozheng.xfastmvp.mvp.BasePresenter;

/**
 * @author caozheng
 * @date 2017/10/30
 *
 * describe:
 */

public class MainPresenter extends BasePresenter<MainView> {

    public MainPresenter(MainView view){
        attachView(view);
    }

    public void main(){
        mView.test();
    }

}
