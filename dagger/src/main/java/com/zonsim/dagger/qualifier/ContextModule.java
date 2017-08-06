package com.zonsim.dagger.qualifier;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * @Named 注解 区分同类型
 * Created by tang-jw on 8/6.
 */
@Module
public class ContextModule {
    
    private Context mContext;
    private Context mAppContext;
    
    public ContextModule(Context context) {
        mContext = context;
        mAppContext = context.getApplicationContext();
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
