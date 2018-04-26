package com.example.dakaku.delisus;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class FirebasePersistance extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
