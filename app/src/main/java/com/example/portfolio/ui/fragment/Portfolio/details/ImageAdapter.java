package com.example.portfolio.ui.fragment.Portfolio.details;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.databinding.RowImageAppBinding;
import com.example.portfolio.model.portfolio.details.ImageApp;

import java.util.ArrayList;
import java.util.List;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.carViewHolder> {
    private List<ImageApp> imageAppList;

    public ImageAdapter( ) {//Because get data from out
        this.imageAppList = new ArrayList<>();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setPortfolioList(List<ImageApp> ImageAppList) {
        this.imageAppList = ImageAppList;
    }

    @NonNull
    @Override
    public ImageAdapter.carViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//inflate of layout and Components
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_image_app, parent, false);
        return new ImageAdapter.carViewHolder(RowImageAppBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.carViewHolder holder, final int position) {// put new data ever time
        ImageApp skills = imageAppList.get(position);
        holder.binding.setModel(skills);
    }


    @Override
    public int getItemCount() {
        return imageAppList.size();
    }

    class carViewHolder extends RecyclerView.ViewHolder {//declare elements and but resources
        RowImageAppBinding binding;

        public carViewHolder(@NonNull RowImageAppBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}