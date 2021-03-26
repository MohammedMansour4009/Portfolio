package com.example.portfolio.ui.fragment.Portfolio;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.portfolio.databinding.FragmentPortfolioBinding;
import com.example.portfolio.model.experience.Experience;
import com.example.portfolio.model.portfolio.InfoApp;
import com.example.portfolio.model.portfolio.Portfolio;

import java.util.ArrayList;
import java.util.List;


public class PortfolioFragment extends Fragment  implements InfoAppAdapter.OnPortfolioListener {
    private static final String TAG = "PortfolioFragment";
    FragmentPortfolioBinding binding;
    InfoAppAdapter infoAppAdapter;
    List<InfoApp> infoAppList;
    PortfolioViewModel profileViewModel;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        initRecyclerViewInfoApp();
        getRemoteInfoApp();

    }

    private void init() {
        profileViewModel = ViewModelProviders.of(this).get(PortfolioViewModel.class);
        profileViewModel.getPortfolioFromDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPortfolioBinding.inflate(getLayoutInflater());
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
        infoAppList = new ArrayList<>();
        infoAppAdapter = new InfoAppAdapter(this);
    }

    private void getRemoteInfoApp() {
        profileViewModel.profileLiveData.observe(getViewLifecycleOwner(), new Observer<Portfolio>() {
            @Override
            public void onChanged(Portfolio profile) {
                infoAppList=profile.getInfoAppList();
                infoAppAdapter.setPortfolioList(infoAppList);
                binding.rvPortfolio.setAdapter(infoAppAdapter);
                binding.rvPortfolio.getAdapter().notifyDataSetChanged();

            }
        });
    }

    @Override
    public void onInfoAppClick(int position) {
        Log.d(TAG, "onInfoAppClick: clicked" + position);
        infoAppList.get(position);
        NavDirections action = PortfolioFragmentDirections.actionPortfolioFragmentToPortfolioDetailsFragment(infoAppList.get(position).getId(), infoAppList.get(position).getNameApp());
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }
}