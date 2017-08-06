package com.zonsim.dagger;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * ^-^
 * Created by tang-jw on 8/5.
 */

@Module
public class DaggerAppModule {
    
    private DaggerApp mApp;
    
    public DaggerAppModule(DaggerApp app) {
        mApp = app;
    }
    @Provides
    DaggerApp provideDaggerApp() {
        return mApp;
    }
    
    @Provides
    Application provideApplication(DaggerApp app) {
        return app;
    }
    
}
