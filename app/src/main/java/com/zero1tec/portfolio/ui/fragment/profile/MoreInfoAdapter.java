package com.zero1tec.portfolio.ui.fragment.profile;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.RowProfileBinding;
import com.zero1tec.portfolio.model.profile.MoreInfo;

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
        return new MoreInfoViewHolder(RowProfileBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull MoreInfoAdapter.MoreInfoViewHolder holder, final int position) {
        holder.binding.setModel(moreInfoList.get(position));
    }


    @Override
    public int getItemCount() {
        return moreInfoList.size();
    }

    static class MoreInfoViewHolder extends RecyclerView.ViewHolder {
        private final RowProfileBinding binding;

        public MoreInfoViewHolder(@NonNull RowProfileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}