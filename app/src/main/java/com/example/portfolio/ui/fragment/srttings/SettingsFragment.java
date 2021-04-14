package com.example.portfolio.ui.fragment.srttings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.portfolio.databinding.FragmentSettingsBinding;


public class SettingsFragment extends Fragment {
    FragmentSettingsBinding binding;
    TitleOptionAdapter titleOptionAdapter;
    SettingsViewModel settingViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initRecyclerViewOption();
        getRemoteSetting();
        initListener();
    }

    private void initListener() {
        binding.tvContactMe.setOnClickListener(v -> {
            contactMe();
        });
    }
    private void contactMe() {
        String recipientList = "mohammed.mansour4009@gmail.com";
        String[] recipients = recipientList.split(",");
        String subject = "Oh hello there";
        String message = " ";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.setType("message/");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
    private void init() {
        settingViewModel = ViewModelProviders.of(this).get(SettingsViewModel.class);
        settingViewModel.getSettingFromDatabase();
        binding.constraintLayoutSettingFragment.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    private void initRecyclerViewOption() {
        titleOptionAdapter = new TitleOptionAdapter();
    }

    private void getRemoteSetting() {
        settingViewModel.settingLiveData.observe(getViewLifecycleOwner(), setting -> {
            binding.setModel(setting);
            titleOptionAdapter.setOptionList(setting.getTitleOptions());
            binding.rvOption.setAdapter(titleOptionAdapter);
            binding.rvOption.getAdapter().notifyDataSetChanged();

            binding.constraintLayoutSettingFragment.setVisibility(View.VISIBLE);

        });
    }
}