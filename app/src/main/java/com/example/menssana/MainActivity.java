package com.example.menssana;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.TextName);
        SharedPreferences Name = getSharedPreferences( "Nombre", Context.MODE_PRIVATE);
        name.setText(Name.getString("Nombre",""));
    }

    public void Siguiente(View view){
        SharedPreferences Nombre = getSharedPreferences("Nombre", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = Nombre.edit();
        Obj_editor.putString("Nombre", name.getText().toString());
        Obj_editor.commit(); //para guardar finalmente el nombre que haya metido el ususario
        Intent siguiente = new Intent(this, MenuPrincipal.class);
        startActivity(siguiente);
    }
}