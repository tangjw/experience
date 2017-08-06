package com.zonsim.dagger;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.zonsim.dagger.nowdothis.TodoStorage;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
    
    @Inject
    DaggerApp mApp;
    
    @Inject
    Gson mGson;
    
    @Inject
    TodoStorage mTodoStorage;
    
    @Inject
    SharedPreferences mSharedPreferences;
    
    
    @Inject
    OkHttpClient mOkHttpClient;
    
    @Inject
    Picasso mPicasso;
    
//    @Named("Activity")
//    @Inject
//    Context mContext;
//    
//    @Named("Application")
//    @Inject
//    Context mAppContext;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DaggerDaggerAppComponent.builder()
        
        DaggerApp.getComponent(this).inject(this);

//        mTodoStorage.saveTodos("哈哈哈哈");
        
//        DaggerContextComponent.builder()
//                .contextModule(new ContextModule(this))
//                .build().inject(this);
        
    }
    
    public void click(View view) {
        
    }
}
