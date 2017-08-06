package com.zonsim.dagger;

import com.zonsim.dagger.dagger.PerApp;
import com.zonsim.dagger.nowdothis.DataModule;
import com.zonsim.dagger.nowdothis.NetworkModule;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * ^-^
 * Created by tang-jw on 8/6.
 */

@PerApp
@Component(modules = {DaggerAppModule.class, DataModule.class, NetworkModule.class})
public interface DaggerAppComponent {
    
    void inject(MainActivity activity);
    
    OkHttpClient okHttpClient();
    
//    Gson gson();
    
//    Application application();
}
