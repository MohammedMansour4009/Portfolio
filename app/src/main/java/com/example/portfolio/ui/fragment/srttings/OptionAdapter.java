package com.example.portfolio.ui.fragment.srttings;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.databinding.RowSettingsBinding;
import com.example.portfolio.model.setting.Options;

import java.util.ArrayList;
import java.util.List;


public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.OptionViewHolder> {
    private List<Options> optionsList;
    private int position;

    public OptionAdapter() {
        this.optionsList = new ArrayList<>();
    }


    public void setOptionList(List<Options> OptionsList) {
        this.optionsList = OptionsList;
    }

    @NonNull
    @Override
    public OptionAdapter.OptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_settings, parent, false);
        return new OptionAdapter.OptionViewHolder(RowSettingsBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull OptionAdapter.OptionViewHolder holder, final int position) {
        Options options = optionsList.get(position);
        holder.binding.setModel(options);
        //put the toggle Switch for Dark Mode
        if (this.position == 0) {
            holder.binding.swDarkMode.setVisibility(View.VISIBLE);
        }
        holder.binding.swDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                holder.binding.swDarkMode.setChecked(true);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                holder.binding.tvDescription.setText("Dark");

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                holder.binding.swDarkMode.setChecked(false);

            }

        });
    }


    @Override
    public int getItemCount() {
        if (optionsList == null)
            return 0;

        return optionsList.size();
    }

    //use it in new RecyclerView because i need put toggle switch in the first item of the  recyclerView
    public void setLastPosition(int positionForLastRV) {
        this.position = positionForLastRV;
    }

    class OptionViewHolder extends RecyclerView.ViewHolder {
        RowSettingsBinding binding;

        public OptionViewHolder(@NonNull RowSettingsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}