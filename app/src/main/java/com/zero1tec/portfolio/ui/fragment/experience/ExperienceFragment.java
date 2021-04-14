package com.zero1tec.portfolio.ui.fragment.experience;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.zero1tec.portfolio.databinding.FragmentExperienceBinding;


public class ExperienceFragment extends Fragment {

    private FragmentExperienceBinding binding;
    private InfoExperienceAdapter experienceAdapter;
    private ExperienceViewModel profileViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initRecyclerViewInfoApp();
        getRemoteInfoApp();

    }

    private void init() {
        profileViewModel = ViewModelProviders.of(this).get(ExperienceViewModel.class);
        profileViewModel.getExperienceFromDatabase();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExperienceBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @BindingAdapter("android:src")
    public static void setImageUri(ImageView view, String imageUri) {
        if (imageUri == null) {
            view.setImageURI(null);
        } else {
            view.setImageURI(Uri.parse(imageUri));
        }
    }

    private void initRecyclerViewInfoApp() {
        experienceAdapter = new InfoExperienceAdapter();
    }

    private void getRemoteInfoApp() {
        profileViewModel.profileLiveData.observe(getViewLifecycleOwner(), experience -> {
            experienceAdapter.setExperienceList(experience.getExperienceList());
            binding.rvExperience.setAdapter(experienceAdapter);
        });
    }
}