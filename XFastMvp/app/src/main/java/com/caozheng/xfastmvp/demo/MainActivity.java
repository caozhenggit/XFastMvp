package com.caozheng.xfastmvp.demo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.caozheng.xfastmvp.R;
import com.caozheng.xfastmvp.mvp.AppActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author caozheng
 * @date 2017/9/30
 *
 */
public class MainActivity extends AppActivity<MainPresenter> implements MainView {

    @BindView(R.id.tv_text) TextView tvText;

    @Override
    public void initParams(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        tvText.setText(R.string.app_name);
    }

    @Override
    public void doBusiness(Context mContext) {
        $Log(tvText.getText().toString());
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void test() {
        Toast.makeText(MainActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tv_text)
    public void onClick() {
        mPresenter.main();
    }
}
