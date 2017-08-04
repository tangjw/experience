package com.zonsim.dagger.sample;

import javax.inject.Inject;

/**
 * 在 Class A 中，有 Class B 的实例，则称 Class A 对 Class B 有一个依赖。
 * Created by tang-jw on 2017/7/31.
 */

public class A {
    @Inject
    B b;  // @Inject不可以标记为private类型。
    
    public void init() {
        DaggerMyComponent.create().inject(this);
//        DaggerMyComponent.builder().build().inject(this);
        DaggerMyComponent.builder()
                .moduleA(new ModuleA())
                .moduleB(new ModuleB())
                .moduleC(new ModuleC())
                .build().inject(this);
    }
    
    
}
