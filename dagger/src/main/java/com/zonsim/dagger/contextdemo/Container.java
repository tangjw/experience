package com.zonsim.dagger.contextdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * ^-^
 * Created by tang-jw on 2017/8/1.
 */

public class Container extends Fragment {
    
    @Named("Activity")
    @Inject
    Context mContext;
    
    @Named("Application")
    @Inject
    Context mApplicationContext;
    
    public void init() {
    
//        DaggerActivityComponent.create()
        
        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(getActivity()))
                .build();
//                .inject(this);
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
