package com.zero1tec.portfolio.ui.fragment.experience.details.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.RowResponsibilitiesBinding;
import com.zero1tec.portfolio.model.experience.details.InfoResponsibilities;

import java.util.ArrayList;
import java.util.List;


public class ResponsibilitiesAdapter extends RecyclerView.Adapter<ResponsibilitiesAdapter.ResponsibilitiesViewHolder> {
    private List<InfoResponsibilities> InfoResponsibilitiesList;

    public ResponsibilitiesAdapter( ) {
        this.InfoResponsibilitiesList = new ArrayList<>();
    }

    public void setResponsibilitiesList(List<InfoResponsibilities> InfoResponsibilitiesList) {
        this.InfoResponsibilitiesList = InfoResponsibilitiesList;
    }

    @NonNull
    @Override
    public ResponsibilitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_responsibilities, parent, false);
        return new ResponsibilitiesViewHolder(RowResponsibilitiesBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull ResponsibilitiesViewHolder holder, final int position) {
         holder.binding.setModel(InfoResponsibilitiesList.get(position));
    }


    @Override
    public int getItemCount() {
        return InfoResponsibilitiesList.size();
    }

    static class ResponsibilitiesViewHolder extends RecyclerView.ViewHolder {
        RowResponsibilitiesBinding  binding;

        public ResponsibilitiesViewHolder(@NonNull RowResponsibilitiesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}