package com.zonsim.dagger.contextdemo;

import android.content.Context;

import com.zonsim.dagger.App;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

@Module
public class ActivityModule {
    private Context mContext;
    
    private Context mAppContext = App.mApp.getApplicationContext();
    
    public ActivityModule(Context context) {
        mContext = context;
    }
    
    @Named("Activity")
    @Provides
    public Context provideContext() {
        return mContext;
    }
    
    @Named("Application")
    @Provides
    public Context provideApplicationContext() {
        return mAppContext;
    }
    
    
}
