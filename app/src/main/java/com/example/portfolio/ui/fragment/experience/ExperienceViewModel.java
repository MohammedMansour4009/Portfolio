package com.example.portfolio.ui.fragment.experience;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.portfolio.model.experience.Experience;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ExperienceViewModel extends ViewModel {
    private final String TAG = "ExperienceViewModel";
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public MutableLiveData<Experience> profileLiveData = new MediatorLiveData<>();



    public void getExperienceFromDatabase() {
        mDatabase.child("Experience").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                profileLiveData.setValue( snapshot.getValue(Experience.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: in upload ExperienceFragment model form data base " + error.getMessage() + "code =" + error.getCode());
            }
        });

    }


}
