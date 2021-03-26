package com.example.portfolio.ui.fragment.experience;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.portfolio.databinding.FragmentExperienceBinding;
import com.example.portfolio.model.experience.Experience;

import java.util.ArrayList;
import java.util.List;


public class ExperienceFragment extends Fragment {

    FragmentExperienceBinding binding;
    InfoExperienceAdapter experienceAdapter;
    List<Experience> experienceList;
    ExperienceViewModel profileViewModel;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
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
        experienceList = new ArrayList<>();
        experienceAdapter = new InfoExperienceAdapter();
    }

    private void getRemoteInfoApp() {
        profileViewModel.profileLiveData.observe(getViewLifecycleOwner(), new Observer<com.example.portfolio.model.experience.Experience>() {
            @Override
            public void onChanged(com.example.portfolio.model.experience.Experience experience) {
                experienceAdapter.setExperienceList(experience.getExperienceList());
                binding.rvExperience.setAdapter(experienceAdapter);
                binding.rvExperience.getAdapter().notifyDataSetChanged();
            }
        });
    }
}