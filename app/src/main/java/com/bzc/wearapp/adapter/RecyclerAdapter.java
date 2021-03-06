package com.bzc.wearapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bzc.wearapp.R;
import com.bzc.wearapp.bean.RecyclerBean;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context mContent;
    private List<RecyclerBean> mRecyclerBeanList;
    public RecyclerAdapter(Context content, List<RecyclerBean> data){
        mRecyclerBeanList = data;
        mContent = content;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContent).inflate(R.layout.activity_list_item, parent, false);
        final  ViewHolder holder = new ViewHolder(view);
        holder.recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int postion = holder.getAdapterPosition();
                Intent intent = new Intent(mContent, mRecyclerBeanList.get(postion).getCls());
                mContent.startActivity(intent);
            }
        });

        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerBean bean = mRecyclerBeanList.get(position);
        holder.titleView.setText(bean.getName());
        holder.iconView.setImageResource(bean.getImageId());
    }

    @Override
    public int getItemCount() {
        return mRecyclerBeanList.size();
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
