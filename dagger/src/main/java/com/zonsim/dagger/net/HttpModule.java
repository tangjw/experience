package com.zonsim.dagger.net;

import com.zonsim.dagger.BuildConfig;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * ^-^
 * Created by tang-jw on 2017/8/4.
 */

@Module
public class HttpModule {
    
    @Inject
    HttpLoggingInterceptor mHttpLoggingInterceptor;
    
    @Singleton
    @Provides
    public Http provideHttp() {
        return new Http("http://118.145.26.215:9090/edu/");
    }
    
    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
    
    @Provides
    public OkHttpClient.Builder provideOkHttpClientBuilder(Interceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(interceptor);
        }
        return builder;
    }
}
