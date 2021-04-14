package com.example.portfolio.ui.welcom;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.portfolio.model.welcom.InfoWelcome;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WelcomeViewModel extends ViewModel {
    private final String TAG = "ProfileViewModel";
    private DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference();
    public MutableLiveData<List<InfoWelcome>> welcomeLiveData = new MediatorLiveData<>();


    public void getWelcomeFromDatabase() {// its first task for View Model
        List<InfoWelcome> infoWelcomeList = new ArrayList<>();
        mDatabase.child("Welcome").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap : snapshot.getChildren()) {
                    InfoWelcome infoWelcome =  snap.getValue(InfoWelcome.class);
                    infoWelcomeList.add(infoWelcome);
                }
                welcomeLiveData.setValue(infoWelcomeList);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: in upload welcome model form data base " + error.getMessage() + "code =" + error.getCode());
            }
        });

    }



}
