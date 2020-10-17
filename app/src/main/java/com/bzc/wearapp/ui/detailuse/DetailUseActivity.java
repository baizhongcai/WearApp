package com.bzc.wearapp.ui.detailuse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;
import androidx.wear.widget.drawer.WearableActionDrawerView;
import androidx.wear.widget.drawer.WearableNavigationDrawerView;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.MenuItem;

import com.bzc.wearapp.R;
import com.bzc.wearapp.ui.detailuse.adapter.ListAdapter;
import com.bzc.wearapp.ui.detailuse.adapter.NavigationAdapter;
import com.bzc.wearapp.ui.detailuse.bean.ListDataBean;

import java.util.ArrayList;
import java.util.List;

public class DetailUseActivity extends WearableActivity implements MenuItem.OnMenuItemClickListener {

    private WearableActionDrawerView mBottomView;
    private WearableNavigationDrawerView mTopView;
    private WearableRecyclerView mListView;
    private List<ListDataBean> mDataList;
    private List<ListDataBean> mTopList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        initData();
        initView();
        initEvent();
        setAmbientEnabled();
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for(int index = 1; index <= 50; index++){
            ListDataBean bean = new ListDataBean();
            bean.setName("这是测试name" + index);
            bean.setResId(R.mipmap.ic_05);
            mDataList.add(bean);
        }

        mTopList = new ArrayList<>();
        for(int index = 1; index <= 5; index++){
            ListDataBean bean = new ListDataBean();
            bean.setName("标题" + index);
            bean.setResId(R.mipmap.ic_05);
            mTopList.add(bean);
        }

    }

    private void initEvent() {

    }

    private void initView() {
        mBottomView = findViewById(R.id.bottom_action_drawer);
        mTopView = findViewById(R.id.top_navigation_drawer);
        mListView = findViewById(R.id.recyclerlist);
        mListView.setLayoutManager(new WearableLinearLayoutManager(this));
        ListAdapter adapter = new ListAdapter(this, mDataList);
        mListView.setAdapter(adapter);

        //顶部导航
        NavigationAdapter navigationAdapter = new NavigationAdapter(this, mTopList);
        mTopView.setAdapter(navigationAdapter);
        //mTopView.getController().peekDrawer();

        mBottomView.setTitle("请选择操作");
        //mBottomView.getController().peekDrawer();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }
}