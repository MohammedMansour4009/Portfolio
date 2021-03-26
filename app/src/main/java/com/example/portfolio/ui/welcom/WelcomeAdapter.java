package com.example.portfolio.ui.welcom;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolio.R;
import com.example.portfolio.databinding.RowWelcomeBinding;
import com.example.portfolio.model.welcom.InfoWelcome;

import java.util.ArrayList;
import java.util.List;

public class WelcomeAdapter extends RecyclerView.Adapter<WelcomeAdapter.carViewHolder> {
    private static InfoWelcome welcome;
    private List<InfoWelcome> welcomeList;

    public WelcomeAdapter() {
        welcomeList = new ArrayList<>();
    }

    @NonNull
    @Override
    public carViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//inflate of layout and Components
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_welcome, parent, false);
        return new carViewHolder(RowWelcomeBinding.bind(view));
    }

    @Override
    public void onBindViewHolder(@NonNull carViewHolder holder, int position) {// put new data ever time
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

    class carViewHolder extends RecyclerView.ViewHolder {//declare elements and but resources
        RowWelcomeBinding binding;

        public carViewHolder(@NonNull RowWelcomeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    //and below is the brightIt func
    @BindingAdapter("imageUriWelcome")
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



