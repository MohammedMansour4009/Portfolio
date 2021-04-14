package com.zero1tec.portfolio.ui.fragment.experience;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.RowExperienceBinding;
import com.zero1tec.portfolio.model.experience.InfoExperience;

import java.util.ArrayList;
import java.util.List;


public class InfoExperienceAdapter extends RecyclerView.Adapter<InfoExperienceAdapter.InfoExperienceViewHolder> {
    private List<InfoExperience> InfoExperienceList;

    public InfoExperienceAdapter( ) {//Because get data from out
        this.InfoExperienceList = new ArrayList<>();
    }



    public void setExperienceList(List<InfoExperience> InfoExperienceList) {
        this.InfoExperienceList = InfoExperienceList;
    }

    @NonNull
    @Override
    public InfoExperienceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_experience, parent, false);
        return new InfoExperienceViewHolder(RowExperienceBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull InfoExperienceViewHolder holder, final int position) {
        InfoExperience infoExperience = InfoExperienceList.get(position);
        holder.binding.setModel(infoExperience);
        holder.binding.cvExperience.setOnClickListener(v -> {
            NavDirections action=ExperienceFragmentDirections.actionExperienceFragmentToExperienceDetailsFragment(infoExperience.getId());
            Navigation.findNavController(v).navigate(action);
        });
    }


    @Override
    public int getItemCount() {
        return InfoExperienceList.size();
    }

    static class InfoExperienceViewHolder extends RecyclerView.ViewHolder {
        RowExperienceBinding binding;

        public InfoExperienceViewHolder(@NonNull RowExperienceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}