package com.example.portfolio.ui.fragment.profile;


import android.content.Context;
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


public class MoreInfoAdapter extends RecyclerView.Adapter<MoreInfoAdapter.carViewHolder> {
    private List<MoreInfo> moreInfoList;
    private Context context;
    private int index = 0;

    public MoreInfoAdapter( ) {//Because get data from out
        this.moreInfoList = new ArrayList<>();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }

    public void setMoreInfoList(List<MoreInfo> moreInfoList) {
        this.moreInfoList = moreInfoList;
    }

    @NonNull
    @Override
    public MoreInfoAdapter.carViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//inflate of layout and Components
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_profile, parent, false);
        return new MoreInfoAdapter.carViewHolder(RowProfileBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull MoreInfoAdapter.carViewHolder holder, final int position) {// put new data ever time
        MoreInfo category = moreInfoList.get(position);
        holder.binding.setModel(category);
    }


    @Override
    public int getItemCount() {
        return moreInfoList.size();
    }

    class carViewHolder extends RecyclerView.ViewHolder {//declare elements and but resources
        RowProfileBinding binding;

        public carViewHolder(@NonNull RowProfileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}