package com.zonsim.dagger.contextdemo;

import dagger.Component;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

@Component(modules = ActivityModule2.class)
public interface ActivityComponent2 {
    
    void inject(Container2 container);
    
}
