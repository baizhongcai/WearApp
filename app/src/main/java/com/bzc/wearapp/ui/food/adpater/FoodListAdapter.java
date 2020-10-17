package com.bzc.wearapp.ui.food.adpater;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bzc.wearapp.R;
import com.bzc.wearapp.ui.food.bean.FoodListBean;
import com.bzc.wearapp.util.ConstantUtil;

import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder>{

    private List<FoodListBean.DataBean> mDataList;
    private Context mContext;

    public void setListData(List<FoodListBean.DataBean> dataList){
        mDataList = dataList;
        notifyDataSetChanged();
    }
    public FoodListAdapter(Context content, List<FoodListBean.DataBean> dataList){
        this.mContext = content;
        this.mDataList = dataList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_list_item, parent, false);
        final FoodListAdapter.ViewHolder holder = new FoodListAdapter.ViewHolder(view);
        holder.recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int postion = holder.getAdapterPosition();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodListBean.DataBean bean = mDataList.get(position);
        holder.titleView.setText(bean.getName());
        String path = bean.getImgsrc().substring(2);
        String imagePath = ConstantUtil.BASE_SERVER_PATH + path;
        Glide.with(mContext)
                .load(imagePath)
                .into(holder.iconView);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View recyclerView;
        TextView titleView;
        ImageView iconView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView;
            titleView = itemView.findViewById(R.id.titleView);
            iconView = itemView.findViewById(R.id.iconView);
        }
    }
}
