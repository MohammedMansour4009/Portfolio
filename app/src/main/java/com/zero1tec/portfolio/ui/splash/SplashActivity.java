package com.zero1tec.portfolio.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatDelegate;

import com.zero1tec.portfolio.databinding.ActivitySplashBinding;
import com.zero1tec.portfolio.model.welcom.Welcome;
import com.zero1tec.portfolio.ui.main.BaseBindingActivity;
import com.zero1tec.portfolio.ui.main.MainActivity;
import com.zero1tec.portfolio.ui.welcom.WelcomeActivity;


public class SplashActivity extends BaseBindingActivity<ActivitySplashBinding> {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        handler = new Handler();
        setHandler(2);
    }

    @Override
    protected ActivitySplashBinding getViewBinding() {
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    private void setHandler(int secondsDelayed) {
        handler.postDelayed(() -> {
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();

        }, secondsDelayed * 1000);
    }


}
