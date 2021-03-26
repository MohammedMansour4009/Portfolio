package com.example.portfolio.ui.fragment.Portfolio;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.databinding.RowPortfolioBinding;
import com.example.portfolio.model.portfolio.InfoApp;
import com.example.portfolio.ui.fragment.Portfolio.details.PortfolioDetailsFragment;

import java.util.ArrayList;
import java.util.List;


public class InfoAppAdapter extends RecyclerView.Adapter<InfoAppAdapter.carViewHolder> {
    private static final String TAG = "InfoAppAdapter";
    private List<InfoApp> infoAppList;
    private OnPortfolioListener onPortfolioListener;
    View view;

    public InfoAppAdapter(OnPortfolioListener onPortfolioListener) {//Because get data from out
        this.infoAppList = new ArrayList<>();
        this.onPortfolioListener = onPortfolioListener;

    }


    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        view = recyclerView.getRootView();
    }

    public void setPortfolioList(List<InfoApp> InfoAppList) {
        this.infoAppList = InfoAppList;
    }

    @NonNull
    @Override
    public InfoAppAdapter.carViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//inflate of layout and Components
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_portfolio, parent, false);
        return new InfoAppAdapter.carViewHolder(RowPortfolioBinding.bind(view),onPortfolioListener);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoAppAdapter.carViewHolder holder, final int position) {// put new data ever time
        InfoApp infoApp = infoAppList.get(position);
        holder.binding.setModel(infoApp);
    }


    @Override
    public int getItemCount() {
        return infoAppList.size();
    }



    class carViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {//declare elements and but resources
        RowPortfolioBinding binding;

        OnPortfolioListener onPortfolioListener;
        public carViewHolder(@NonNull RowPortfolioBinding binding,OnPortfolioListener onPortfolioListener) {
            super(binding.getRoot());
            this.binding = binding;

            this.onPortfolioListener=onPortfolioListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onInfoAppClick: clicked" + getAdapterPosition());
            onPortfolioListener.onInfoAppClick(infoAppList.get(getAdapterPosition()).getId());
        }
    }

    public  interface OnPortfolioListener{
        void  onInfoAppClick(int position);
    }

}