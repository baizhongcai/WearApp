package com.bzc.wearapp.ui.wearablenavigationdrawerview;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.Toast;

import androidx.wear.widget.drawer.WearableNavigationDrawerView;

import com.bzc.wearapp.R;
import com.bzc.wearapp.ui.wearablenavigationdrawerview.adapter.MainDrawerAdapter;
import com.bzc.wearapp.ui.wearablenavigationdrawerview.bean.InfoBean;

import java.util.ArrayList;
import java.util.List;

public class WearableNavigationDrawerViewActivity extends WearableActivity  implements WearableNavigationDrawerView.OnItemSelectedListener {

    private WearableNavigationDrawerView mDrawerView;
    private List<InfoBean> mInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wearable_navigation_drawer_view);
        initData();
        initView();
        initEvent();
        // Enables Always-on
        setAmbientEnabled();
    }

    private void initData() {
        mInfoList = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            InfoBean bean = new InfoBean();
            bean.setName("第" + i + "页");
            bean.setLayoutId(R.mipmap.ic_01);
            mInfoList.add(bean);
        }
    }

    private void initEvent() {
        mDrawerView.addOnItemSelectedListener(this);
    }

    private void initView() {
        mDrawerView = findViewById(R.id.wearableNavigationDrawerView);
        MainDrawerAdapter adapter = new MainDrawerAdapter(this, mInfoList);
        mDrawerView.setAdapter(adapter);
        mDrawerView.getController().peekDrawer();
    }

    @Override
    public void onItemSelected(int pos) {
        Toast.makeText(this, pos+"", Toast.LENGTH_LONG).show();
    }
}