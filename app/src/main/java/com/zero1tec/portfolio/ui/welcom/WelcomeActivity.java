package com.zero1tec.portfolio.ui.welcom;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zero1tec.portfolio.databinding.ActivityWelcomeBinding;
import com.zero1tec.portfolio.model.welcom.InfoWelcome;
import com.zero1tec.portfolio.ui.main.BaseBindingActivity;
import com.zero1tec.portfolio.ui.main.MainActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class WelcomeActivity extends BaseBindingActivity<ActivityWelcomeBinding> {

    private final String TAG = "WelcomeActivity";
    private WelcomeAdapter welcomeAdapter;
    private int index = 1;

    private WelcomeViewModel welcomeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        init();
        initRecyclerViewWelcome();
        initListeners();

    }

    private void initListeners() {
        binding.bInBottom.setOnClickListener(v -> {
            index = binding.vpWelcome.getCurrentItem();
            binding.vpWelcome.setCurrentItem(++index);

            if (index == (binding.vpWelcome.getAdapter().getItemCount())) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
            if (binding.vpWelcome.getCurrentItem() == (binding.vpWelcome.getAdapter().getItemCount() - 1)) {
                binding.bInBottom.setText("MY PORTFOLIO");
            } else {
                binding.bInBottom.setText("SKIP");
            }


        });

    }


    @Override
    protected ActivityWelcomeBinding getViewBinding() {
        return ActivityWelcomeBinding.inflate(getLayoutInflater());
    }


    private void init() {

        welcomeAdapter = new WelcomeAdapter();

        welcomeViewModel = ViewModelProviders.of(this).get(WelcomeViewModel.class);
        welcomeViewModel.getWelcomeFromDatabase();

        binding.bInBottom.setVisibility(View.GONE);
    }

    private void initRecyclerViewWelcome() {

        welcomeViewModel.welcomeLiveData.observe(this, new Observer<List<InfoWelcome>>() {
            @Override
            public void onChanged(List<InfoWelcome> infoWelcomes) {
                welcomeAdapter.setWelcomeList(infoWelcomes);
                binding.vpWelcome.setAdapter(welcomeAdapter);
                binding.vpWelcome.getAdapter().notifyDataSetChanged();
                binding.bInBottom.setVisibility(View.VISIBLE);
                binding.indicator.setViewPager(binding.vpWelcome);

                binding.vpWelcome.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);
                        if (binding.vpWelcome.getCurrentItem() == (binding.vpWelcome.getAdapter().getItemCount() - 1)) {
                            binding.bInBottom.setText("MY PORTFOLIO");
                        } else
                            binding.bInBottom.setText("SKIP");
                    }
                });

            }

        });
    }
}