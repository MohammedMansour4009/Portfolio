package com.example.portfolio.ui.fragment.profile;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.portfolio.databinding.FragmentProfileBinding;
import com.example.portfolio.model.profile.MoreInfo;
import com.example.portfolio.model.profile.Profile;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    MoreInfoAdapter moreInfoAdapter;
    List<MoreInfo> moreInfoList;
    ProfileViewModel profileViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initRecyclerViewMoreInfo();
        getRemoteMoreInfo();
    }



    private void init() {
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        profileViewModel.getProfileFromDatabase();
        binding.clProfile.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @BindingAdapter("imageUri")
    public  static void setImageUri(ImageView view, String imageUri) {
        Glide.with(view.getContext()).load(imageUri).into(view);
        }


    private void initRecyclerViewMoreInfo() {
        moreInfoList = new ArrayList<>();
        moreInfoAdapter = new MoreInfoAdapter();

        binding.rvMoreInfo.setAdapter(moreInfoAdapter);
        binding.rvMoreInfo.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && binding.fcb.getVisibility() == View.VISIBLE) {
                    binding.fcb.hide();
                } else if (dy < 0 && binding.fcb.getVisibility() != View.VISIBLE) {
                    binding.fcb.show();
                }
            }
        });
    }

    private void getRemoteMoreInfo() {
        profileViewModel.profileLiveData.observe(getViewLifecycleOwner(), new Observer<Profile>() {
            @Override
            public void onChanged(Profile profile) {
                binding.setModel(profile);
                moreInfoAdapter.setMoreInfoList(profile.getMoreInfoList());
                binding.rvMoreInfo.getAdapter().notifyDataSetChanged();
                binding.clProfile.setVisibility(View.VISIBLE);

            }
        });
    }


}