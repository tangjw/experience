package com.zonsim.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zonsim.dagger.nowdothis.DaggerImgurComponent;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class ImgurActivity extends AppCompatActivity {
    
    @Inject
    Retrofit mRetrofit;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgur);
        
        DaggerImgurComponent.builder()
                .daggerAppComponent(DaggerApp.getComponent(this))
                .build().inject(this);
    }
}
