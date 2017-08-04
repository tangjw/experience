package com.zonsim.dagger.applicationmodule;

import android.content.Context;

import com.zonsim.dagger.contextdemo.ContextLife;

import dagger.Component;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    
    @ContextLife("Application")
    Context getApplication();
    
}

