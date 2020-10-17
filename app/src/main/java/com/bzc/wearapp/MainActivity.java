package com.bzc.wearapp;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import com.bzc.wearapp.adapter.RecyclerAdapter;
import com.bzc.wearapp.bean.RecyclerBean;
import com.bzc.wearapp.ui.card.CardActivity;
import com.bzc.wearapp.ui.detailuse.DetailUseActivity;
import com.bzc.wearapp.ui.food.FoodListActivity;
import com.bzc.wearapp.ui.notification.NotificationActivity;
import com.bzc.wearapp.ui.wearableactiondrawerView.WearableActionDrawerViewActivity;
import com.bzc.wearapp.ui.wearablenavigationdrawerview.WearableNavigationDrawerViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends WearableActivity {

    private WearableRecyclerView mWearableRecyclerView;
    private List<RecyclerBean> mRecyclerBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initEvent();
        // Enables Always-on
        setAmbientEnabled();
    }

    private void initData() {
        mRecyclerBeanList = new ArrayList<>();
        mRecyclerBeanList.add(new RecyclerBean(NotificationActivity.class, "通知的使用", R.mipmap.ic_01));
        mRecyclerBeanList.add(new RecyclerBean(WearableNavigationDrawerViewActivity.class, "顶部导航栏", R.mipmap.ic_02));
        mRecyclerBeanList.add(new RecyclerBean(WearableActionDrawerViewActivity.class, "底部导航栏", R.mipmap.ic_03));
        mRecyclerBeanList.add(new RecyclerBean(DetailUseActivity.class, "综合使用", R.mipmap.ic_04));
        mRecyclerBeanList.add(new RecyclerBean(FoodListActivity.class, "网络请求", R.mipmap.ic_05));
        mRecyclerBeanList.add(new RecyclerBean(CardActivity.class, "Card使用", R.mipmap.ic_01));
    }

    private void initEvent() {

    }

    private void initView() {
        mWearableRecyclerView = findViewById(R.id.recycler_view);
        mWearableRecyclerView.setLayoutManager(new WearableLinearLayoutManager(this));
        RecyclerAdapter adapter = new RecyclerAdapter(this, mRecyclerBeanList);
        //第一个列表项和最后一个列表项在屏幕上垂直居中对齐
        mWearableRecyclerView.setEdgeItemsCenteringEnabled(true);
        //是否可以使用圆形滚动手势
        mWearableRecyclerView.setCircularScrollingGestureEnabled(true);
        //靠近屏幕边缘的虚拟“屏幕边框”（在此区域内能够识别出手势）的宽度
        mWearableRecyclerView.setBezelFraction(0.5f);
        //用户的手指必须旋转多少度才能滚过一个屏幕高度
        mWearableRecyclerView.setScrollDegreesPerScreen(90f);
        //设置数据
        mWearableRecyclerView.setAdapter(adapter);
    }
}
