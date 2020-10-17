package com.bzc.wearapp.ui.wearablenavigationdrawerview.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;
import androidx.wear.widget.drawer.WearableNavigationDrawerView;

import com.bzc.wearapp.ui.wearablenavigationdrawerview.bean.InfoBean;

import java.util.List;

public class MainDrawerAdapter extends WearableNavigationDrawerView.WearableNavigationDrawerAdapter {

   private Context mContext;
   private List<InfoBean> mInfoList;
    public MainDrawerAdapter(Context content, List<InfoBean> data) {
        mContext = content;
        mInfoList = data;
    }

    @Override
    public CharSequence getItemText(int pos) {
        return mInfoList.get(pos).getName();
    }

    @Override
    public Drawable getItemDrawable(int pos) {
        return  ContextCompat.getDrawable(mContext, mInfoList.get(pos).getLayoutId());
    }

    @Override
    public int getCount() {
        return mInfoList.size();
    }
}
