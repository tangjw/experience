package com.zonsim.dagger.nowdothis;

import com.zonsim.dagger.DaggerAppComponent;
import com.zonsim.dagger.ImgurActivity;

import dagger.Component;

/**
 * ImgurComponent 依赖DaggerAppComponent。当使用 ImgurComponent 注入 ImgurActivity 时，
 * 如果找不到对应的依赖，就会到 DaggerAppComponent 中查找。但是，DaggerAppComponent 必须
 * 显式把 ImgurComponent 找不到的依赖提供给它。
 * Created by tang-jw on 8/6.
 */

@Component(
        dependencies = DaggerAppComponent.class,
        modules = {
                ImgurModule.class
        })
public interface ImgurComponent {
    
    void inject(ImgurActivity activity);
    
}
