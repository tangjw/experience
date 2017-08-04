package com.zonsim.tbs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * ^-^
 * Created by tang-jw on 2017/7/26.
 */

public class TBSActivity extends AppCompatActivity {
    
    private WebView mWebView;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_tbs);
        
        
        mWebView = (WebView) findViewById(R.id.x5_webview);
    
        WebSettings settings =
                mWebView.getSettings();
        
        settings.setJavaScriptEnabled(true);
        
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
    
        
        mWebView.loadUrl("http://s4.uczzd.cn/ucnews/news?aid=16871624809867081690");
        
    
    }
}
