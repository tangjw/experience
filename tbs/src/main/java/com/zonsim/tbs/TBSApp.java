package com.zonsim.tbs;

import android.app.Application;

/**
 * ^-^
 * Created by tang-jw on 2017/7/26.
 */

public class TBSApp extends Application {
    
    @Override
    public void onCreate() {
        super.onCreate();
    
        /*QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                System.out.println("TBSApp onCoreInitFinished");
            }
    
            @Override
            public void onViewInitFinished(boolean b) {
                System.out.println("TBSApp onViewInitFinished "+b);
            }
        });   */
        
        
    }
}
