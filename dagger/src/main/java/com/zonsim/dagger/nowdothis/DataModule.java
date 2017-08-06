package com.zonsim.dagger.nowdothis;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    
    static final String PREFS_DEFAULT = "nowdothis";
    
    @Provides
    SharedPreferences provideSharedPrefs(Application app) {
        return app.getSharedPreferences(PREFS_DEFAULT, Context.MODE_PRIVATE);
    }
    
    @Provides
    Gson provideGson() {
        return new Gson();
    }
}
