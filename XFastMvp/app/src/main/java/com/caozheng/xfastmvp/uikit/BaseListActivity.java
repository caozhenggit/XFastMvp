package com.caozheng.xfastmvp.uikit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.caozheng.xfastmvp.R;

/**
 * @author caozheng
 * @date 2017/12/30
 * <p>
 * describe: 列表Activity抽象类
 */

public abstract class BaseListActivity extends UI {

    /**
     * toolbar样式
     * @return ToolBarOptions
     */
    protected abstract ToolBarOptions getToolBarOptions();

    /**
     * RecyclerView adapter样式
     * @return RecyclerView.Adapter
     */
    protected abstract RecyclerView.Adapter getAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_list_activity_layout);

        ToolBarOptions options = getToolBarOptions();
        setToolBar(R.id.toolbar, options);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.data_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(getAdapter());
    }
}
