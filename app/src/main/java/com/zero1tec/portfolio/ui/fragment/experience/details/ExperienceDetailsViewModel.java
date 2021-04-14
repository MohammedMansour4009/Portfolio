package com.zero1tec.portfolio.ui.fragment.experience.details;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zero1tec.portfolio.model.experience.details.ExperienceDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ExperienceDetailsViewModel extends ViewModel {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public MutableLiveData<ExperienceDetails> detailsMutableLiveData = new MutableLiveData<>();
    private final String TAG="ExperienceDetailsViewModel";


    public void getPortfolioFromDatabase() {
        mDatabase.child("info_Activity_Experience_Details ").child("Experience_Details").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               ExperienceDetails experienceDetails = snapshot.getValue(ExperienceDetails.class);
                detailsMutableLiveData.setValue(snapshot.getValue(ExperienceDetails.class));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: in upload PortfolioFragment model form data base " + error.getMessage() + "code =" + error.getCode());
            }
        });

    }


}
