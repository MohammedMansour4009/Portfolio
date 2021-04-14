package com.zero1tec.portfolio.ui.fragment.Portfolio.details;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.RowImageAppBinding;
import com.zero1tec.portfolio.model.portfolio.details.ImageApp;

import java.util.ArrayList;
import java.util.List;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private List<ImageApp> imageAppList;

    public ImageAdapter( ) {
        this.imageAppList = new ArrayList<>();
    }


    public void setImageAppList(List<ImageApp> ImageAppList) {
        this.imageAppList = ImageAppList;
    }

    @NonNull
    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_image_app, parent, false);
        return new ImageViewHolder(RowImageAppBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageViewHolder holder, final int position) {
        holder.binding.setModel(imageAppList.get(position));
    }


    @Override
    public int getItemCount() {
        return imageAppList.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        RowImageAppBinding binding;

        public ImageViewHolder(@NonNull RowImageAppBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}