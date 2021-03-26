package com.example.portfolio.ui.fragment.experience;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.databinding.RowExperienceBinding;
import com.example.portfolio.model.experience.InfoExperience;

import java.util.ArrayList;
import java.util.List;


public class InfoExperienceAdapter extends RecyclerView.Adapter<InfoExperienceAdapter.carViewHolder> {
    private List<InfoExperience> InfoExperienceList;

    public InfoExperienceAdapter( ) {//Because get data from out
        this.InfoExperienceList = new ArrayList<>();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setExperienceList(List<InfoExperience> InfoExperienceList) {
        this.InfoExperienceList = InfoExperienceList;
    }

    @NonNull
    @Override
    public carViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//inflate of layout and Components
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_experience, parent, false);
        return new carViewHolder(RowExperienceBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull carViewHolder holder, final int position) {// put new data ever time
        InfoExperience InfoExperience = InfoExperienceList.get(position);
        holder.binding.setModel(InfoExperience);
    }


    @Override
    public int getItemCount() {
        return InfoExperienceList.size();
    }

    class carViewHolder extends RecyclerView.ViewHolder {//declare elements and but resources
        RowExperienceBinding binding;

        public carViewHolder(@NonNull RowExperienceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}