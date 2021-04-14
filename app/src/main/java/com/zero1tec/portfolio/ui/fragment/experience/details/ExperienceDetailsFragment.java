package com.zero1tec.portfolio.ui.fragment.experience.details;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.FragmentExperienceDetailsBinding;
import com.zero1tec.portfolio.model.experience.details.ExperienceDetails;
import com.zero1tec.portfolio.ui.fragment.experience.details.adapter.LinkAdapter;
import com.zero1tec.portfolio.ui.fragment.experience.details.adapter.ResponsibilitiesAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

public class ExperienceDetailsFragment extends Fragment implements OnMapReadyCallback {

    private FragmentExperienceDetailsBinding binding;

    private LinkAdapter linkAdapter;
    private ResponsibilitiesAdapter responsibilitiesAdapter;

    private ExperienceDetailsViewModel detailsViewModel;

    private ExperienceDetails mExperienceDetails;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentExperienceDetailsBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        getRemoteInfo();
        initListeners();
    }

    private void initListeners() {
        binding.btnPlayStore.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(mExperienceDetails.getUriGooglePlay()))));
        binding.btnGithub.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(mExperienceDetails.getUriWepSite()))));
    }

    private void init() {
        mExperienceDetails = new ExperienceDetails();

        responsibilitiesAdapter = new ResponsibilitiesAdapter();
        linkAdapter = new LinkAdapter();

        detailsViewModel = ViewModelProviders.of(this)
                .get(ExperienceDetailsViewModel.class);
        detailsViewModel.getPortfolioFromDatabase();

        binding.constraintExperienceDetailsFragment.setVisibility(View.GONE);
    }

    private void getRemoteInfo() {
        detailsViewModel.detailsMutableLiveData.observe(getViewLifecycleOwner(),
                experienceDetails -> {
            mExperienceDetails=experienceDetails;

            //set the list in adapter
            responsibilitiesAdapter.
                    setResponsibilitiesList(mExperienceDetails.getResponsibilitiesList());

            linkAdapter.setExperienceList(mExperienceDetails.getInfoLinkList());

            //set the Adapter in recyclerview
            binding.rvResponsibilities.setAdapter(responsibilitiesAdapter);

            binding.rvLinks.setAdapter(linkAdapter);

            //the task of starting its work after the API fire
            binding.setModel(experienceDetails);
            mainSettingMapFragment();
            overrideToolbar();
            binding.constraintExperienceDetailsFragment.setVisibility(View.VISIBLE);

        });
    }

    private void mainSettingMapFragment() {
        GoogleMapOptions options = new GoogleMapOptions();
        options.mapType(GoogleMap.MAP_TYPE_TERRAIN);//type of map
        options.zoomControlsEnabled(true);
        options.compassEnabled(true);
        SupportMapFragment mapFragment = SupportMapFragment.newInstance(options);
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.mapContainer, mapFragment);
        ft.commit();
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng companyLocation = new LatLng(mExperienceDetails.getLatLngMy().getLatitude(), mExperienceDetails.getLatLngMy().getLongitude());
        String companyTitle = mExperienceDetails.getNameCompany();

        ClusterManager clusterManager = new ClusterManager(getContext(), googleMap);
        googleMap.setOnCameraIdleListener(clusterManager);
        googleMap.setOnMarkerClickListener(clusterManager);
        googleMap.addMarker(new MarkerOptions().position(companyLocation)//put marker
                .title(companyTitle));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(companyLocation, 17));//declare zoom of marker
    }

    private void overrideToolbar() {
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();

        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(mExperienceDetails.getName());
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }
}
