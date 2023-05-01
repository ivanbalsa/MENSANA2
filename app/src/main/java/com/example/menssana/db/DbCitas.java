package com.example.menssana.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.menssana.db.Citas;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbCitas extends Dbhelper {

    Context context;

    public DbCitas(@Nullable Context context) {
        super(context);
        this.context =context;

    }
    public long insertarCita(String lugar, String fecha) {

        long id = 0;
        try {
            Dbhelper dbHelper = new Dbhelper(context);

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("lugar", lugar);
            values.put("fecha", fecha);

            id = db.insert(TABLA_CITAS, null, values);
            db.close();
        } catch (Exception ex) {
            ex.toString();
        }
        return id;

    }
    public ArrayList<Citas> mostrarCitas (){


        final Dbhelper Dbhelper= new Dbhelper(context);
        SQLiteDatabase db= Dbhelper.getWritableDatabase();

        ArrayList<Citas> listaCitas = new ArrayList<Citas>();
        Citas cita = null;
        Cursor cursorCitas=null;

        cursorCitas = db.rawQuery("SELECT * FROM " + TABLA_CITAS, null);

        if(cursorCitas.moveToFirst()){
            do{
                cita = new Citas();
                cita.setId(cursorCitas.getInt(0));
                cita.setLugar(cursorCitas.getString(1));
                cita.setFecha(cursorCitas.getString(2));
                listaCitas.add(cita);
            } while (cursorCitas.moveToNext());
        }

        cursorCitas.close();

        return listaCitas;


    }
    public Citas verCita (int id){


        final Dbhelper Dbhelper= new Dbhelper(context);
        SQLiteDatabase db= Dbhelper.getWritableDatabase();


        Citas cita = null;
        Cursor cursorCitas=null;



        cursorCitas = db.rawQuery("SELECT * FROM " + TABLA_CITAS + " WHERE id = " + id + " LIMIT 1", null);

        if(cursorCitas.moveToFirst()){

                cita = new Citas();
                cita.setId(cursorCitas.getInt(0));
                cita.setLugar(cursorCitas.getString(1));
                cita.setFecha(cursorCitas.getString(2));


        }

        cursorCitas.close();

        return cita;


    }
    public boolean EditarCita(int id, String lugar, String fecha) {

        boolean correcto = false;

        Dbhelper dbHelper = new Dbhelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLA_CITAS + " SET lugar = '" + lugar + "', fecha = '" + fecha + "' WHERE id= '" + id + "' ");
            //db.close();
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }
        return correcto;

    }
}
