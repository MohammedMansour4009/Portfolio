package com.zero1tec.portfolio.ui.fragment.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.FragmentProfileBinding;
import com.zero1tec.portfolio.model.profile.Media;
import com.zero1tec.portfolio.model.profile.Profile;
import com.zero1tec.portfolio.ui.fragment.profile.sheet.MediaAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private Profile profile;
    private MoreInfoAdapter moreInfoAdapter;

    private MediaAdapter mediaAdapter;
    private List<Media> mediaList;

    private ProfileViewModel profileViewModel;

    private BottomSheetDialog bottomSheetDialog;

    private RecyclerView rvMedia;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

        initRecyclerViewMoreInfo();

        getRemoteMoreInfo();


    }

    private void initBottomSheet() {
        //init BottomSheet
        bottomSheetDialog = new BottomSheetDialog(getContext(), R.style.AppBottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(getContext())
                .inflate(R.layout.layout_bottom_sheet, getActivity().findViewById(R.id.bottom_sheet_container));
        rvMedia = bottomSheetView.findViewById(R.id.rv_media);
        TextView tvContactMe = bottomSheetView.findViewById(R.id.tv_contact_me_in_sheet);
        TextView tvEmail = bottomSheetView.findViewById(R.id.tv_contact_me2_in_sheet);

        //init recycler view in  BottomSheet
        mediaAdapter.setMediaList(mediaList);
        rvMedia.setAdapter(mediaAdapter);

        contentOfBottomSheet(bottomSheetView);


        bottomSheetDialog.setContentView(bottomSheetView);

        tvContactMe.setOnClickListener(v -> contactMe());
        tvEmail.setOnClickListener(v -> contactMe());
        binding.bSheet.setOnClickListener(v -> bottomSheetDialog.show());


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


    private void contentOfBottomSheet(View bottomSheetView) {
        TextView tvName = bottomSheetView.findViewById(R.id.tv_name_in_sheet);
        tvName.setText(profile.getTextName());
        TextView tvEmail = bottomSheetView.findViewById(R.id.tv_email);
        tvEmail.setText(profile.getTextName());
        ImageView imageView = bottomSheetView.findViewById(R.id.civ_icon_sheet);
        Glide.with(getContext()).load(profile.getImage()).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }


    private void init() {
        profile = new Profile();
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        profileViewModel.getProfileFromDatabase();
//      It layout hidden until the data comes from Firebase
        binding.clmProfile.setVisibility(View.GONE);

        mediaList = new ArrayList<>();
        mediaAdapter = new MediaAdapter();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @BindingAdapter("imageUri")
    public static void setImageUri(ImageView view, String imageUri) {
        Glide.with(view.getContext()).load(imageUri).into(view);
    }


    private void initRecyclerViewMoreInfo() {
        moreInfoAdapter = new MoreInfoAdapter();
        binding.rvMoreInfo.setAdapter(moreInfoAdapter);
    }


    private void getRemoteMoreInfo() {
        profileViewModel.profileLiveData.observe(getViewLifecycleOwner(), profile1 -> {
            profile = profile1;
            binding.setModel(profile);

            moreInfoAdapter.setMoreInfoList(profile.getMoreInfoList());
            binding.rvMoreInfo.getAdapter().notifyDataSetChanged();
            binding.clmProfile.setVisibility(View.VISIBLE);
            mediaList = profile.getMediaList();

            initBottomSheet();


            rvMedia.getAdapter().notifyDataSetChanged();
        });
    }

}