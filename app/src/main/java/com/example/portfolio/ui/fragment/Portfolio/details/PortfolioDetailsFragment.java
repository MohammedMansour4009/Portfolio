package com.example.portfolio.ui.fragment.Portfolio.details;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.portfolio.R;
import com.example.portfolio.databinding.FragmentPortfolioDetailsBinding;
import com.example.portfolio.model.portfolio.details.PortfolioDetails;


public class PortfolioDetailsFragment extends Fragment {

    private FragmentPortfolioDetailsBinding binding;

    private SkillsAdapter skillsAdapter;

    private PortfolioDetailsViewModel profileViewModel;

    private ImageAdapter imageAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initRecyclerViewInfoApp();
        getRemoteInfoApp();

        overrideToolbar();

    }

    private void init() {
        profileViewModel = ViewModelProviders.of(this).get(PortfolioDetailsViewModel.class);
        profileViewModel.getPortfolioDetailsFromDatabase();
        //It layout  hidden until the data comes from Firebase
        binding.constraintLayoutPortfolioDetailsFragment.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPortfolioDetailsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    private void overrideToolbar() {
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(PortfolioDetailsFragmentArgs.fromBundle(getArguments()).getTitle());
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
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
        skillsAdapter =new SkillsAdapter();

        imageAdapter = new ImageAdapter();
    }

    private void getRemoteInfoApp() {
        profileViewModel.profileLiveData.observe(getViewLifecycleOwner(), new Observer<PortfolioDetails>() {
            @Override
            public void onChanged(PortfolioDetails profile) {
                binding.setModel(profile);

                skillsAdapter.setSkillsList(profile.getSkillsList());
                binding.rvSkills.setAdapter(skillsAdapter);
                binding.rvSkills.getAdapter().notifyDataSetChanged();

                imageAdapter.setImageAppList(profile.getImageAppList());
                binding.rvImageApp.setAdapter(imageAdapter);
                binding.rvImageApp.getAdapter().notifyDataSetChanged();


                binding.constraintLayoutPortfolioDetailsFragment.setVisibility(View.VISIBLE);

            }
        });
    }
}