package com.example.portfolio.ui.fragment.srttings;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.databinding.RowTitleOptionBinding;
import com.example.portfolio.model.setting.TitleOptions;

import java.util.ArrayList;
import java.util.List;


public class TitleOptionAdapter extends RecyclerView.Adapter<TitleOptionAdapter.carViewHolder> {
    private List<TitleOptions> optionsList;
    private OptionAdapter optionAdapter;
    public TitleOptionAdapter( ) {//Because get data from out
        this.optionsList = new ArrayList<>();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setOptionList(List<TitleOptions> TitleOptionsList) {
        this.optionsList = TitleOptionsList;
    }

    @NonNull
    @Override
    public TitleOptionAdapter.carViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_title_option, parent, false);
        return new TitleOptionAdapter.carViewHolder(RowTitleOptionBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull TitleOptionAdapter.carViewHolder holder, final int position) {
        TitleOptions titleOptions = optionsList.get(position);
        holder.binding.setModel(titleOptions);

        optionAdapter.setOptionList(titleOptions.getOptionsList());

        optionAdapter.setLastPosition(position);
        holder.binding.rvOption.setAdapter(optionAdapter);
    }


    @Override
    public int getItemCount() {
        return optionsList.size();
    }

    class carViewHolder extends RecyclerView.ViewHolder {
        RowTitleOptionBinding binding;

        public carViewHolder(@NonNull RowTitleOptionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            optionAdapter=new OptionAdapter();
            binding.rvOption.setAdapter(optionAdapter);
        }

    }


}