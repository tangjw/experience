package com.zonsim.dagger.sample;

import dagger.Component;

/**
 * ^-^
 * Created by tang-jw on 2017/7/31.
 */
//多个 module
@Component(modules = {MyModule.class, ModuleA.class, ModuleB.class})
public interface MyComponent {
    void inject(A a);
}


