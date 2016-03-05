package com.tikalk.okretro;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by oren on 05/03/16.
 */
public class Cars extends Application {
    private RealmConfiguration realmConfig;
    @Override
    public void onCreate() {
        super.onCreate();
        realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
