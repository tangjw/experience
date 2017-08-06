package com.zonsim.dagger.nowdothis;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * ^-^
 * Created by tang-jw on 8/6.
 */

@Module
public class ImgurModule {
    
    @Provides
    Retrofit provideRetrofit(/*CallAdapter.Factory factory, */OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com")
//                .addCallAdapterFactory(factory)
                .client(client)
                .build();
    }
    
}
