package com.bzc.wearapp.ui.card;

import android.os.Bundle;

import android.support.wearable.view.CardFragment;
import android.support.wearable.view.CardScrollView;
import android.view.Gravity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bzc.wearapp.R;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        initView();
        initEvent();

    }

    private void initEvent() {
    }

    private void initView() {

        CardScrollView cardScrollView =
                (CardScrollView) findViewById(R.id.card_scroll_view);
        cardScrollView.setCardGravity(Gravity.BOTTOM);
        
    }
}