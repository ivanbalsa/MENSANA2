package com.example.menssana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.menssana.citas.TusCitas;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void Foro(View view){
        Intent foro = new Intent(this, Foro.class);
        startActivity(foro);
    }

    public void Encuentra(View view){
        Intent encuentra = new Intent(this, Encuentra.class);
        startActivity(encuentra);
    }

    public void TusCitas(View view){
        Intent tuscitas = new Intent(this, TusCitas.class);
        startActivity(tuscitas);
    }

    public void Descubre(View view){
        Intent descubre = new Intent(this, Descubre.class);
        startActivity(descubre);
    }

    public void PideAyuda(View view){
        Intent pideayuda = new Intent(this, PideAyuda.class);
        startActivity(pideayuda);
    }
}