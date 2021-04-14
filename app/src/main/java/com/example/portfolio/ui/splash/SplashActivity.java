package com.example.portfolio.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.portfolio.databinding.ActivitySplashBinding;
import com.example.portfolio.ui.main.BaseBindingActivity;
import com.example.portfolio.ui.main.MainActivity;
import com.example.portfolio.ui.welcom.WelcomeActivity;


public class SplashActivity extends BaseBindingActivity<ActivitySplashBinding> {

    private static final String TAG = "SplashActivity";
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        handler = new Handler();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setHandler(2);
    }

    @Override
    protected ActivitySplashBinding getViewBinding() {
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    private void setHandler(int secondsDelayed) {
        handler.postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();

        }, secondsDelayed * 1000);
    }


}
