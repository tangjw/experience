package com.zonsim.dagger.sample;

import dagger.Module;
import dagger.Provides;

/**
 * ^-^
 * Created by tang-jw on 2017/7/31.
 */

@Module(includes = {ModuleA.class, ModuleB.class, ModuleC.class})
public class MyModule {
    @Provides
    public B provideB(C c) {
        return new B(c);
    }
    
    // 如果找不到被@Provides注释的方法提供对应参数 C 对象的话，
    // 将会自动调用被@Inject注释的 C 构造方法生成相应对象。
   /* @Provides
    public C provideC() {
        return new C();
    }*/
    
}
