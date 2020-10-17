package com.bzc.wearapp.ui.detailuse.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.wear.widget.drawer.WearableNavigationDrawerView;

import com.bzc.wearapp.ui.detailuse.bean.ListDataBean;

import java.util.List;

public class NavigationAdapter extends WearableNavigationDrawerView.WearableNavigationDrawerAdapter {

    private List<ListDataBean> mBeanList;
    private Context mContext;

    public NavigationAdapter(Context context, List<ListDataBean> data){
        mContext = context;
        mBeanList = data;
    }
    @Override
    public CharSequence getItemText(int pos) {
        return mBeanList.get(pos).getName();
    }

    @Override
    public Drawable getItemDrawable(int pos) {
        return mContext.getDrawable(mBeanList.get(pos).getResId());
    }

    @Override
    public int getCount() {
        return mBeanList.size();
    }
}
