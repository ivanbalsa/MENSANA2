package com.example.menssana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class noticiaCompleta extends AppCompatActivity {

    TextView tituloscard,fuentescard,fechascard,description;
    WebView webView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia_completa);
        tituloscard = findViewById(R.id.tituloscard);
        fuentescard = findViewById(R.id.fuentescard);
        fechascard = findViewById(R.id.fechascard);
        description = findViewById(R.id.description);
        webView = findViewById(R.id.webView);
        imageView = findViewById(R.id.portada);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String source = intent.getStringExtra("source");
        String publishedAt = intent.getStringExtra("publishedAt");
        String urlportada = intent.getStringExtra("urlportada");
        String url = intent.getStringExtra("url");
        String description2 = intent.getStringExtra("description");

        tituloscard.setText(title);
        fuentescard.setText(source);
        fechascard.setText(publishedAt);
        description.setText(description2);
        Picasso.with(noticiaCompleta.this).load(urlportada).into(imageView);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setWebViewClient(new WebViewClient());
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        webView.loadUrl(url);
    }
}