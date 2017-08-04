package com.zonsim.dagger.net;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * ^-^
 * Created by tang-jw on 2017/8/4.
 */

public class Http {
    
    public String mString = "HTTP ....";
    
    public final String HOST_URL;// = "http://118.145.26.215:9090/edu/"
    
    @Inject
    HttpLoggingInterceptor mHttpLoggingInterceptor;
    
    @Inject
    OkHttpClient.Builder mBuilder;
    
    public Http(String apiHost) {
    
        HOST_URL = apiHost;
    
        DaggerHttpComponent.create().inject(this);
        
        mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
    }
    
    
}
