package com.zonsim.dagger.named;

import dagger.Component;

/**
 * @Named 注解 区分同类型
 * Created by tang-jw on 8/6.
 */
@Component(modules = ContextModule.class)
public interface ContextComponent {
    
    void inject(NamedActivity activity);
    
}
