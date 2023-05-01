package com.example.menssana.citas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.menssana.R;
import com.example.menssana.db.Citas;
import com.example.menssana.db.DbCitas;

public class VerActivity extends AppCompatActivity {

    EditText txtLugar, txtFecha;
    Button btnGuarda;

    Citas cita;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        txtLugar = findViewById(R.id.editLugar);
        txtFecha = findViewById(R.id.editFecha);
        btnGuarda = findViewById(R.id.btnGuarda);

        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        }  else {
                id = (int) savedInstanceState.getSerializable("ID");
            }

            DbCitas dbCitas = new DbCitas(VerActivity.this);
            cita = dbCitas.verCita(id);

            if (cita != null){
                txtLugar.setText(cita.getLugar());
                txtFecha.setText(cita.getFecha());
                btnGuarda.setVisibility(View.INVISIBLE);
                txtLugar.setInputType(InputType.TYPE_NULL);
                txtFecha.setInputType(InputType.TYPE_NULL);
        }
    }}
