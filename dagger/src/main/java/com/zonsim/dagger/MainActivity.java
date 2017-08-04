package com.zonsim.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zonsim.dagger.net.DaggerHttpComponent;
import com.zonsim.dagger.net.Http;
import com.zonsim.dagger.net.HttpModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    
    @Inject
    Http mHttp;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build().inject(this);
        
        System.out.println(mHttp.mString);
    }
}
