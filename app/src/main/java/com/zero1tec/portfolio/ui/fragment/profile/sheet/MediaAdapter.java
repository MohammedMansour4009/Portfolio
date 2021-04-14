package com.zero1tec.portfolio.ui.fragment.profile.sheet;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.RowMediaBinding;
import com.zero1tec.portfolio.databinding.RowProfileBinding;
import com.zero1tec.portfolio.model.profile.Media;

import java.util.ArrayList;
import java.util.List;


public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.MediaViewHolder> {
    private List<Media> mediaList;
    private Context context;

    public MediaAdapter( ) {
        this.mediaList = new ArrayList<>();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        context = recyclerView.getContext();
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    @NonNull
    @Override
    public MediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_media, parent, false);
        return new MediaViewHolder(RowMediaBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull MediaViewHolder holder, final int position) {
        Media media  = mediaList.get(position);

        holder.binding.tvName.setText(media.getName());
        Glide.with(context) .load(media.getIcon()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.binding.ivIcon);


    }


    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    static class MediaViewHolder extends RecyclerView.ViewHolder {
        RowMediaBinding binding;

        public MediaViewHolder(@NonNull RowMediaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}