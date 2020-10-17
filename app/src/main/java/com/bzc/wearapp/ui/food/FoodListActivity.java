package com.bzc.wearapp.ui.food;

import androidx.wear.widget.WearableLinearLayoutManager;
import androidx.wear.widget.WearableRecyclerView;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;

import com.bzc.wearapp.R;
import com.bzc.wearapp.ui.food.adpater.FoodListAdapter;
import com.bzc.wearapp.ui.food.bean.FoodListBean;
import com.bzc.wearapp.util.ConstantUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FoodListActivity extends WearableActivity {

    private WearableRecyclerView mFoodListView;
    private FoodListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        initView();
        initData();
        initEvent();
        setAmbientEnabled();
    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().connectTimeout(8000, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder()
                .get()
                .url(ConstantUtil.BASE_SERVER_PATH + "/route/FoodRoute.php?type=selAll")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if(response.code() == 200){

                    String jsonStr = response.body().string();
                    Gson json = new Gson();
                    final FoodListBean foodListBean = json.fromJson(jsonStr, FoodListBean.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.setListData(foodListBean.getData());
                            mFoodListView.setAdapter(mAdapter);
                        }
                    });
                }

            }
        });

    }

    private void initView() {
        mFoodListView = findViewById(R.id.foodlist);
        mAdapter = new FoodListAdapter(this, new ArrayList<FoodListBean.DataBean>());
        mFoodListView.setEdgeItemsCenteringEnabled(true);
        mFoodListView.setLayoutManager(new WearableLinearLayoutManager(this));

    }

    private void initEvent() {
        
    }
}