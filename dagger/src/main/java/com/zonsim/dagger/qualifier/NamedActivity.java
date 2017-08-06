package com.zonsim.dagger.qualifier;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zonsim.dagger.ImgurActivity;
import com.zonsim.dagger.R;

import javax.inject.Inject;

public class NamedActivity extends AppCompatActivity {
    
    @ContextLife("Activity")
    @Inject
    Context mContext;
    @ContextLife("Application")
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
