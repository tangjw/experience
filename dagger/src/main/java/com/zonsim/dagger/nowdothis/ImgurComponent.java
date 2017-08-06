package com.zonsim.dagger.nowdothis;

import com.zonsim.dagger.DaggerAppComponent;
import com.zonsim.dagger.ImgurActivity;

import dagger.Component;

/**
 * ^-^
 * Created by tang-jw on 8/6.
 */

@Component(dependencies = DaggerAppComponent.class, modules = {ImgurModule.class})
public interface ImgurComponent {
    
    void inject(ImgurActivity activity);
    
}
