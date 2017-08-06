package com.zonsim.dagger;

import android.app.Application;

import com.zonsim.dagger.dagger.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * ^-^
 * Created by tang-jw on 8/5.
 */

@Module
final class DaggerAppModule {
    
    private DaggerApp mApp;
    
    DaggerAppModule(DaggerApp app) {
        mApp = app;
    }
    
    @PerApp
    @Provides
    DaggerApp provideDaggerApp() {
        return mApp;
    }
    
    @PerApp
    @Provides
    Application provideApplication(DaggerApp app) {
        return app;
    }
    
}
