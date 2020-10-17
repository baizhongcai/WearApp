package com.bzc.wearapp.ui.wearableactiondrawerView;

import androidx.wear.widget.CircularProgressLayout;
import androidx.wear.widget.drawer.WearableActionDrawerView;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.bzc.wearapp.R;

public class WearableActionDrawerViewActivity extends WearableActivity implements MenuItem.OnMenuItemClickListener {

    private WearableActionDrawerView mWearableActionDrawerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wearable_action_drawer_view);

        initView();
        initEvent();
        setAmbientEnabled();
    }

    private void initEvent() {
        mWearableActionDrawerView.setOnMenuItemClickListener(this);
    }

    private void initView() {

        mWearableActionDrawerView = findViewById(R.id.wearableActionDrawerView);
        /**以下是WearableActionDrawerView动态操控的代码**/
        //设置底部导航拉起后的标题
        mWearableActionDrawerView.setTitle("请选择操作");
        mWearableActionDrawerView.getController().peekDrawer();

        //稍微漏出抽屉（即显示第一个item的图标）
        //mWearableActionDrawerView.getController().peekDrawer();
        //打开抽屉
        //mWearableActionDrawerView.getController.openDrawer();
        //关闭抽屉
        //mWearableActionDrawerView.getController.closeDrawer();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        int resId = menuItem.getItemId();
        if(resId == R.id.menu_1){
            Toast.makeText(this, "点击1", Toast.LENGTH_LONG).show();
        }else if(resId == R.id.menu_2){
            Toast.makeText(this, "点击2", Toast.LENGTH_LONG).show();
        }
        return false;
    }
}