package com.zonsim.dagger.named;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zonsim.dagger.ImgurActivity;
import com.zonsim.dagger.R;

import javax.inject.Inject;
import javax.inject.Named;

public class NamedActivity extends AppCompatActivity {
    
    @Named("Activity")
    @Inject
    Context mContext;
    @Named("Application")
    @Inject
    Context mAppContext;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_named);
        
        DaggerContextComponent.builder()
                .contextModule(new ContextModule(this))
                .build().inject(this);
        
    }
    
    public void click(View view) {
        mContext.startActivity(new Intent(this, ImgurActivity.class));
    }
}
