package com.example.ptsganjil202111rpl1samy22.Class;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SportRealm extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().allowWritesOnUiThread(true)
                .name("sport.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
    
    
    
}
