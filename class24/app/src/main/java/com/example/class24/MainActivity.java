package com.example.class24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    public WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.WebView);                 // 1
//        if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},1);
//        }
//        https://developer.android.google.cn/training/permissions/requesting
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);  // 无论有无安全证书都允许
        }
        webView.getSettings().setJavaScriptEnabled(true);   // 2
        webView.setWebViewClient(new WebViewClient());      // 3
        webView.loadUrl("http://www.baidu.com");

    }
}
