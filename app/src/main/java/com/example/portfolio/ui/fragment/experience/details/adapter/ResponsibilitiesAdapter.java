package com.example.portfolio.ui.fragment.experience.details.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.databinding.RowResponsibilitiesBinding;
import com.example.portfolio.model.experience.details.InfoResponsibilities;

import java.util.ArrayList;
import java.util.List;


public class ResponsibilitiesAdapter extends RecyclerView.Adapter<ResponsibilitiesAdapter.responsibilitiesViewHolder> {
    private List<InfoResponsibilities> InfoResponsibilitiesList;

    public ResponsibilitiesAdapter( ) {
        this.InfoResponsibilitiesList = new ArrayList<>();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setInfoResponsibilitiesList(List<InfoResponsibilities> InfoResponsibilitiesList) {
        this.InfoResponsibilitiesList = InfoResponsibilitiesList;
    }

    @NonNull
    @Override
    public responsibilitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//inflate of layout and Components
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_responsibilities, parent, false);
        return new responsibilitiesViewHolder(RowResponsibilitiesBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull responsibilitiesViewHolder holder, final int position) {// put new data ever time
        InfoResponsibilities InfoResponsibilities = InfoResponsibilitiesList.get(position);
        holder.binding.setModel(InfoResponsibilities);
    }


    @Override
    public int getItemCount() {
        return InfoResponsibilitiesList.size();
    }

    class responsibilitiesViewHolder extends RecyclerView.ViewHolder {//declare elements and but resources
        RowResponsibilitiesBinding  binding;

        public responsibilitiesViewHolder(@NonNull RowResponsibilitiesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}