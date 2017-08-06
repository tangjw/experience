package com.zonsim.dagger.nowdothis;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    
    private final String PREFS_DEFAULT;
    
    public DataModule(String PREFS_DEFAULT) {
        this.PREFS_DEFAULT = PREFS_DEFAULT;
    }
    
    @Provides
    SharedPreferences provideSharedPrefs(Application app) {
        return app.getSharedPreferences(PREFS_DEFAULT, Context.MODE_PRIVATE);
    }
    
    @Provides
    Gson provideGson() {
        return new Gson();
    }
}
