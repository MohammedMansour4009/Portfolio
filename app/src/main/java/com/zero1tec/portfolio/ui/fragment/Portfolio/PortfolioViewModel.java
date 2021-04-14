package com.zero1tec.portfolio.ui.fragment.Portfolio;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zero1tec.portfolio.model.portfolio.Portfolio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PortfolioViewModel extends ViewModel {
    private final String TAG = " PortfolioViewModel";
    private final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public MutableLiveData<Portfolio> profileLiveData = new MediatorLiveData<>();



    public void getPortfolioFromDatabase() {
        mDatabase.child("Portfolio").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                profileLiveData.setValue( snapshot.getValue(Portfolio.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: in upload PortfolioFragment model form data base " + error.getMessage() + "code =" + error.getCode());
            }
        });

    }


}
