package com.zonsim.dagger.nowdothis;

import android.app.Application;
import android.net.Uri;
import android.util.Log;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * ^-^
 * Created by tang-jw on 8/6.
 */

@Module
public class NetworkModule {
    
    @Provides
    OkHttpClient provideOkHttpClient(Application application) {
    
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
    
        builder.writeTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(10, TimeUnit.SECONDS);
    
        builder.cache(new Cache(new File(application.getCacheDir(), "http"), 1024 * 1024));
        
        return builder.build();
    }
    
    
    @Provides
    Picasso providePicasso(Application app, OkHttpClient client) {
        return new Picasso.Builder(app)
//                .downloader(new OkHttpDownloader(client))
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
                        Log.e("Picasso", "Failed to load image: %s", e);
                    }
                })
                .build();
    }
    
}
