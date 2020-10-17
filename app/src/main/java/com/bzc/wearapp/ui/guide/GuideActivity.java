package com.bzc.wearapp.ui.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;

import com.bzc.wearapp.MainActivity;
import com.bzc.wearapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class GuideActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        startTime();
        setAmbientEnabled();
    }

    private void startTime() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}