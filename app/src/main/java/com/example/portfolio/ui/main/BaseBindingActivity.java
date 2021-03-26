package com.example.portfolio.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public abstract class BaseBindingActivity<B extends ViewBinding> extends AppCompatActivity {

    public B binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewBinding();
        setContentView(binding.getRoot());

    }
    protected abstract B getViewBinding();
}
