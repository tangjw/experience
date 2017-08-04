package com.zonsim.dagger.net;

import com.zonsim.dagger.MainActivity;

import dagger.Component;

/**
 * ^-^
 * Created by tang-jw on 2017/8/4.
 */

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(MainActivity activity);
    
    void inject(Http http);
//    void inject(Http http);
}
