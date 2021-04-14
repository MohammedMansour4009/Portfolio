package com.example.portfolio.ui.fragment.Portfolio.details;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.databinding.RowPortfolioBinding;
import com.example.portfolio.databinding.RowSkillsBinding;
import com.example.portfolio.model.portfolio.details.Skills;

import java.util.ArrayList;
import java.util.List;


public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder> {
    private List<Skills> skillsList;

    public SkillsAdapter( ) {//Because get data from out
        this.skillsList = new ArrayList<>();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setSkillsList(List<Skills> SkillsList) {
        this.skillsList = SkillsList;
    }

    @NonNull
    @Override
    public SkillsAdapter.SkillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//inflate of layout and Components
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_skills, parent, false);
        return new SkillsAdapter.SkillsViewHolder(RowSkillsBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsAdapter.SkillsViewHolder holder, final int position) {// put new data ever time
        Skills skills = skillsList.get(position);
        holder.binding.setModel(skills);
    }


    @Override
    public int getItemCount() {
        return skillsList.size();
    }

    class SkillsViewHolder extends RecyclerView.ViewHolder {//declare elements and but resources
        RowSkillsBinding binding;

        public SkillsViewHolder(@NonNull RowSkillsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}