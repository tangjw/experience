package com.zonsim.dagger.singleton;

import com.zonsim.dagger.sample.B;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

@Module
public class MyModule {
    
    @Singleton
    @Provides
    B provideB() {
        return new B();
    }
    
}
