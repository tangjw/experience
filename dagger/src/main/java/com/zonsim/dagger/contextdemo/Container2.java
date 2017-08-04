package com.zonsim.dagger.contextdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

public class Container2 extends Fragment {
    
    @ContextLife("Activity")
    @Inject
    Context mContext;
    
    @ContextLife("Application")
    @Inject
    Context mApplicationContext;
    
    public void init() {
        
        DaggerActivityComponent2.builder()
                .activityModule2(new ActivityModule2(getActivity()))
                .build()
                .inject(this);
    }
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
