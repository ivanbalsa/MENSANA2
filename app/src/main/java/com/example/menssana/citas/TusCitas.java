package com.example.menssana.citas;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.menssana.citas.ListaCitasAdapter.ListaCitasAdapter;
import com.example.menssana.R;
import com.example.menssana.db.Citas;
import com.example.menssana.db.DbCitas;

import java.util.ArrayList;

public class TusCitas extends AppCompatActivity {

    //añado EL RECICLER CREADO PARA TUS CITAS
    RecyclerView listaCitas;
    ArrayList<Citas> listaArrayCitas;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tus_citas);

        listaCitas = findViewById(R.id.listaCitas);
        listaCitas.setLayoutManager(new LinearLayoutManager(this));

        DbCitas dbcitas = new DbCitas(TusCitas.this);
        listaArrayCitas = new ArrayList<>();

        ListaCitasAdapter adapter = new ListaCitasAdapter(dbcitas.mostrarCitas());
        listaCitas.setAdapter(adapter);
    }

    public void newDate(View view){
        Intent newCita = new Intent(this, AgregarCita.class);
        startActivity(newCita);
    }


}
