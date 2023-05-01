package com.example.menssana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Descubre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descubre);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://www.instagram.com/somosestupendas/");
        setContentView(R.layout.activity_descubre);
        WebView myWebView2 = (WebView) findViewById(R.id.webview2);
        myWebView2.loadUrl("https://www.instagram.com/mmassexologia/");
    }




}