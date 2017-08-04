package com.zonsim.tbs;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QbSdk.initX5Environment(this, null);
    }
    
    public void click1(View view) {
        
        startActivity(new Intent(this, TBSActivity.class));
    }
    
    public void click2(View view) {
        
        String path = Environment.getExternalStorageDirectory() + "/download/1.pdf";
    
        HashMap<String, String> params = new HashMap<>();
    
        params.put("local", "false");
        params.put("style", "1");
    
        QbSdk.openFileReader(this, path, params, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                System.out.println("onReceiveValue: " + s);
            }
        });
        
        
    }
    
    public void click3(View view) {
        String path = Environment.getExternalStorageDirectory() + "/download/3.docx";
    
        QbSdk.openFileReader(this, path, null, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                System.out.println("onReceiveValue: " + s);
            }
        });
    }
    
    public void click4(View view) {
        String path = Environment.getExternalStorageDirectory() + "/download/4.pptx";
    
        QbSdk.openFileReader(this, path, null, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                System.out.println("onReceiveValue: " + s);
            }
        });
    }
    
    public void click5(View view) {
        String path = Environment.getExternalStorageDirectory() + "/download/2.xlsx";
    
        QbSdk.openFileReader(this, path, null, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                System.out.println("onReceiveValue: " + s);
            }
        });
    }
    
}
