package com.zonsim.dagger.applicationmodule;

import dagger.Component;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

@Component(modules = ApplicationModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    
//    void inject(Container container);
}

