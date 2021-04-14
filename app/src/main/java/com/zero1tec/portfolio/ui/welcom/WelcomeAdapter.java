package com.zero1tec.portfolio.ui.welcom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.zero1tec.portfolio.R;
import com.zero1tec.portfolio.databinding.RowWelcomeBinding;
import com.zero1tec.portfolio.model.welcom.InfoWelcome;

import java.util.ArrayList;
import java.util.List;

public class WelcomeAdapter extends RecyclerView.Adapter<WelcomeAdapter.WelcomeViewHolder> {
    private static InfoWelcome welcome;
    private List<InfoWelcome> welcomeList;

    public WelcomeAdapter() {
        welcomeList = new ArrayList<>();
    }

    @NonNull
    @Override
    public WelcomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//inflate of layout and Components
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_welcome, parent, false);
        return new WelcomeViewHolder(RowWelcomeBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull WelcomeViewHolder holder, int position) {// put new data ever time
        welcome = welcomeList.get(position);
        holder.binding.setModel(welcome);
    }

    public void setWelcomeList(List<InfoWelcome> welcomeList) {
        this.welcomeList = welcomeList;
    }


    @Override
    public int getItemCount() {
        return welcomeList.size();
    }

    static class WelcomeViewHolder extends RecyclerView.ViewHolder {//declare elements and but resources
        RowWelcomeBinding binding;

        public WelcomeViewHolder(@NonNull RowWelcomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    //and below is the brightIt func
    @BindingAdapter("imageWelcome")
    public static void setImageUri(ImageView view, String imageUri) {
        {
            switch (welcome.getId()) {
                case 1:
                    view.setImageResource(R.drawable.ic_welcome_screen_icon_1_avd);
                    break;
                case 2:
                    view.setImageResource(R.drawable.ic_welcome_screen_icon_2_avd);
                    break;
                case 3:
                    view.setImageResource(R.drawable.ic_welcome_screen_icon_3_avd);
                    break;
            }
        }
    }


}



