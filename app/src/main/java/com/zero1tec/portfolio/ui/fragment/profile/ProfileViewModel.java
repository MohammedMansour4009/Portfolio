package com.zero1tec.portfolio.ui.fragment.profile;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zero1tec.portfolio.model.profile.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileViewModel extends ViewModel {
    private final String TAG = "ProfileViewModel";
    private final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public MutableLiveData<Profile> profileLiveData = new MediatorLiveData<>();



    public void getProfileFromDatabase() {
        mDatabase.child("Profile").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                profileLiveData.setValue( snapshot.getValue(Profile.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: in upload ProfileFragment model form data base " + error.getMessage() + "code =" + error.getCode());
            }
        });

    }


}
