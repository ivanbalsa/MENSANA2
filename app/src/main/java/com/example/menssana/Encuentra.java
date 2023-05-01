package com.example.menssana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;


public class Encuentra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuentra);

    }

    public void cita(View view){
        Intent encuentra = new Intent(this, Encuentra.class);
        startActivity(encuentra);
    }



}