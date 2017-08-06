package com.zonsim.dagger;

import android.app.Application;
import android.content.Context;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

public class DaggerApp extends Application {
    
    public String string = "text text";
    private DaggerAppComponent mComponent;
    
    @Override
    public void onCreate() {
        super.onCreate();
        
        mComponent = DaggerDaggerAppComponent.builder()
                .daggerAppModule(new DaggerAppModule(this))
                .build();
        
    }
    
    public static DaggerAppComponent getComponent(Context context) {
        return ((DaggerApp) context.getApplicationContext()).mComponent;
    }
    
    
}
