package com.zonsim.dagger.singleton;

import javax.inject.Singleton;

import dagger.Component;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {
//    void inject(Container c);
}
