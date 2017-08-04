package com.zonsim.dagger;

import android.app.Application;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

public class App extends Application {
    
    public static App mApp;
//    private App mApp;
    
    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }
    /*
    public static Context getAppContext() {
        return mApp.getApplicationContext();
    }*/
}
