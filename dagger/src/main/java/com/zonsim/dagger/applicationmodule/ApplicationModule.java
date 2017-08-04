package com.zonsim.dagger.applicationmodule;

import android.content.Context;

import com.zonsim.dagger.App;
import com.zonsim.dagger.contextdemo.ContextLife;

import dagger.Module;
import dagger.Provides;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

@Module
public class ApplicationModule {
    
    private App mApplication;
    
    public ApplicationModule(App application) {
        mApplication = application;
    }
    
    @ContextLife("Application")
    @Provides
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
    
}
