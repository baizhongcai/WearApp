package com.bzc.wearapp.ui.notification;

import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import com.bzc.wearapp.R;

public class NotificationActivity extends WearableActivity implements View.OnClickListener {
    private Button mShowBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        initView();
        initEvent();
        setAmbientEnabled();
    }

    private void initEvent() {
        mShowBtn.setOnClickListener(this);
    }

    private void initView() {
        mShowBtn = findViewById(R.id.showBtn);
    }

    @Override
    public void onClick(View view) {
        int resId = view.getId();
        if(resId == R.id.showBtn){
            //showNotification();
            showWearNotification();
        }
    }
    //显示通知
    private void showNotification() {

        int notificationId = 001;
        // The channel ID of the notification.
        String id = "my_channel_01";
        // Build intent for notification content
        Intent viewIntent = new Intent(this, ViewEventActivity.class);
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //高版本需要渠道
        if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            //只在Android O之上需要渠道，这里的第一个参数要和下面的channelId一样
            NotificationChannel notificationChannel = new NotificationChannel(id,"name", NotificationManager.IMPORTANCE_HIGH);
            //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，通知才能正常弹出
            manager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notification = new NotificationCompat.Builder(this,id)
                .setContentTitle("这是一个内容标题")
                .setContentText("这是一个内容文本这是一个内容文本这是一个内容")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(viewPendingIntent)
                .addAction(R.mipmap.ic_01, "这是测试Activity", viewPendingIntent)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true);

        manager.notify(notificationId, notification.build());
    }

    private  void showWearNotification(){
        int notificationId = 001;
        // The channel ID of the notification.
        String id = "my_channel_01";
        // Build intent for notification content
        Intent viewIntent = new Intent(this, ViewEventActivity.class);
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Create the action
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.mipmap.ic_01,
                        "手表通知", viewPendingIntent)
                        .build();

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //高版本需要渠道
        if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            //只在Android O之上需要渠道，这里的第一个参数要和下面的channelId一样
            NotificationChannel notificationChannel = new NotificationChannel(id,"name", NotificationManager.IMPORTANCE_HIGH);
            //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，通知才能正常弹出
            manager.createNotificationChannel(notificationChannel);
        }

        Notification notification = new NotificationCompat.Builder(this,id)
                .setContentTitle("这是一个内容标题")
                .setContentText("这是一个内容文本这是一个内容文本这是一个内容")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .extend(new NotificationCompat.WearableExtender().addAction(action))
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .build();

        manager.notify(notificationId, notification);
    }

}