package com.zero1tec.portfolio.ui.fragment.Portfolio;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.RowPortfolioBinding;
import com.zero1tec.portfolio.model.portfolio.InfoApp;

import java.util.ArrayList;
import java.util.List;


public class InfoAppAdapter extends RecyclerView.Adapter<InfoAppAdapter.InfoAppViewHolder> {
    private static final String TAG = "InfoAppAdapter";
    private List<InfoApp> infoAppList;
    private final OnPortfolioListener onPortfolioListener;

    public InfoAppAdapter(OnPortfolioListener onPortfolioListener) { 
        this.infoAppList = new ArrayList<>();
        this.onPortfolioListener = onPortfolioListener;

    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setPortfolioList(List<InfoApp> InfoAppList) {
        this.infoAppList = InfoAppList;
    }

    @NonNull
    @Override
    public InfoAppAdapter.InfoAppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { 
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_portfolio, parent, false);
        return new InfoAppAdapter.InfoAppViewHolder(RowPortfolioBinding.bind(view),onPortfolioListener);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoAppAdapter.InfoAppViewHolder holder, final int position) {
        InfoApp infoApp = infoAppList.get(position);
        holder.binding.setModel(infoApp);
    }


    @Override
    public int getItemCount() {
        return infoAppList.size();
    }



    class InfoAppViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  { 
        RowPortfolioBinding binding;

        OnPortfolioListener onPortfolioListener;
        public InfoAppViewHolder(@NonNull RowPortfolioBinding binding,OnPortfolioListener onPortfolioListener) {
            super(binding.getRoot());
            this.binding = binding;

            this.onPortfolioListener=onPortfolioListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onInfoAppClick: clicked" + getAdapterPosition());
            onPortfolioListener.onInfoAppClick(infoAppList.get(getAdapterPosition()).getId()-1);
        }
    }

    public  interface OnPortfolioListener{
        void  onInfoAppClick(int position);
    }

}