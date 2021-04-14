package com.example.portfolio.ui.fragment.srttings;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.portfolio.model.setting.Setting;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SettingsViewModel extends ViewModel {
    private final String TAG = " SettingViewModel";
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    public MutableLiveData<Setting> settingLiveData = new MediatorLiveData<>();



    public void getSettingFromDatabase() {// its first task for View Model
        mDatabase.child("info Activity Setting ").child("Setting").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                settingLiveData.setValue(snapshot.getValue(Setting.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d(TAG, "onCancelled: in upload SettingFragment model form data base " + error.getMessage() + "code =" + error.getCode());
            }
        });

    }


}
