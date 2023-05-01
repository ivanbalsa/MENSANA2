package com.example.menssana.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Dbhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "agenda.db";
    public static final String TABLA_CITAS= "t_citas";

    Context context;

    public Dbhelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " +  TABLA_CITAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "lugar TEXT NOT NULL," +
                "fecha TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLA_CITAS);
        onCreate(sqLiteDatabase);
    }
    /*public ArrayList<Citas> mostrarCitas (){


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


    }*/
    /*public void agregarCita(String lugar, String fecha){

    SQLiteDatabase bd= getWritableDatabase();

    if(bd!=null){
        bd.execSQL("INSERT INTO CITAS VALUES ('"+lugar+"','"+fecha+"')");
        bd.close();
    }
    }*/
}
