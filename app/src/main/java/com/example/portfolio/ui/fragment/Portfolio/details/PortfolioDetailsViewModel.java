package com.example.portfolio.ui.fragment.Portfolio.details;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.portfolio.model.portfolio.details.PortfolioDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PortfolioDetailsViewModel extends ViewModel {
    private final String TAG2 = " PortfolioDetailsViewModel";
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public MutableLiveData<PortfolioDetails> profileLiveData = new MediatorLiveData<>();



    public void getPortfolioDetailsFromDatabase() {// its first task for View Model
        mDatabase.child("info Activity PortfolioDetails ").child("PortfolioDetails").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                profileLiveData.setValue( snapshot.getValue(PortfolioDetails.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("TAG", "onCancelled: in upload PortfolioDetailsFragment model form data base " + error.getMessage() + "code =" + error.getCode());
            }
        });

    }
}
