package com.zero1tec.portfolio.ui.fragment.Portfolio.details;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.RowSkillsBinding;
import com.zero1tec.portfolio.model.portfolio.details.Skills;

import java.util.ArrayList;
import java.util.List;


public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder> {
    private List<Skills> skillsList;

    public SkillsAdapter( ) {//Because get data from out
        this.skillsList = new ArrayList<>();
    }


    public void setSkillsList(List<Skills> SkillsList) {
        this.skillsList = SkillsList;
    }

    @NonNull
    @Override
    public SkillsAdapter.SkillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_skills, parent, false);
        return new SkillsViewHolder(RowSkillsBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsAdapter.SkillsViewHolder holder, final int position) {
        holder.binding.setModel(skillsList.get(position));
    }


    @Override
    public int getItemCount() {
        return skillsList.size();
    }

    static class SkillsViewHolder extends RecyclerView.ViewHolder {
        RowSkillsBinding binding;

        public SkillsViewHolder(@NonNull RowSkillsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}