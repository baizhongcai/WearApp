package com.bzc.wearapp.ui.detailuse.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.widget.WearableRecyclerView;

import com.bzc.wearapp.R;
import com.bzc.wearapp.ui.detailuse.bean.ListDataBean;

import java.util.List;

public class ListAdapter extends WearableRecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListDataBean> mDataList;
    private Context mContext;

    public ListAdapter(Context context, List<ListDataBean> dataList){
        this.mContext = context;
        this.mDataList = dataList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_list_item, parent, false);
        final ListAdapter.ViewHolder holder = new ListAdapter.ViewHolder(view);
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
        ListDataBean bean = mDataList.get(position);
        holder.titleView.setText(bean.getName());
        holder.iconView.setImageResource(bean.getResId());

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
