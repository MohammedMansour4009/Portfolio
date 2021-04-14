package com.example.portfolio.ui.fragment.experience.details.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.databinding.RowLinksBinding;
import com.example.portfolio.model.experience.details.InfoLink;

import java.util.ArrayList;
import java.util.List;


public class LinkAdapter extends RecyclerView.Adapter<LinkAdapter.LinkViewHolder> {
    private List<InfoLink> InfoLinkList;

    public LinkAdapter( ) {
        this.InfoLinkList = new ArrayList<>();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setExperienceList(List<InfoLink> InfoLinkList) {
        this.InfoLinkList = InfoLinkList;
    }

    @NonNull
    @Override
    public LinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_links, parent, false);
        return new LinkViewHolder(RowLinksBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull LinkViewHolder holder, final int position) {// put new data ever time
        InfoLink InfoLink = InfoLinkList.get(position);
        holder.binding.setModel(InfoLink);
    }


    @Override
    public int getItemCount() {
        return InfoLinkList.size();
    }

    class LinkViewHolder extends RecyclerView.ViewHolder {//declare elements and but resources
        RowLinksBinding binding;

        public LinkViewHolder(@NonNull RowLinksBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }


}