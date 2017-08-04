package com.zonsim.dagger.contextdemo;

import android.content.Context;

import com.zonsim.dagger.App;

import dagger.Module;
import dagger.Provides;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

@Module
public class ActivityModule2 {
    private Context mContext;
    
    private Context mAppContext = App.mApp.getApplicationContext();
    
    public ActivityModule2(Context context) {
        mContext = context;
    }
    
    @ContextLife("Activity")
    @Provides
    public Context provideContext() {
        return mContext;
    }
    
    @ContextLife("Application")
    @Provides
    public Context provideApplicationContext() {
        return mAppContext;
    }
    
    
}
