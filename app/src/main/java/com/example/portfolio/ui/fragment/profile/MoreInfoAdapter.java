package com.example.portfolio.ui.fragment.profile;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.databinding.RowProfileBinding;
import com.example.portfolio.model.profile.MoreInfo;

import java.util.ArrayList;
import java.util.List;


public class MoreInfoAdapter extends RecyclerView.Adapter<MoreInfoAdapter.MoreInfoViewHolder> {
    private List<MoreInfo> moreInfoList;


    public MoreInfoAdapter( ) {
        this.moreInfoList = new ArrayList<>();
    }

   

    public void setMoreInfoList(List<MoreInfo> moreInfoList) {
        this.moreInfoList = moreInfoList;
    }

    @NonNull
    @Override
    public MoreInfoAdapter.MoreInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_profile, parent, false);
        return new MoreInfoAdapter.MoreInfoViewHolder(RowProfileBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull MoreInfoAdapter.MoreInfoViewHolder holder, final int position) {
        MoreInfo category = moreInfoList.get(position);
        holder.binding.setModel(category);
    }


    @Override
    public int getItemCount() {
        return moreInfoList.size();
    }

    class MoreInfoViewHolder extends RecyclerView.ViewHolder {//declare elements and but resources
        RowProfileBinding binding;

        public MoreInfoViewHolder(@NonNull RowProfileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}