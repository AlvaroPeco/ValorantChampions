package com.example.valorantchampions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper=new SQLiteHelper(this);
        db = helper.getWritableDatabase();



    }

    public void insertaEquipos(String equipo, String ciudad, int puntos, int foto){
        ContentValues values = new ContentValues();
        values.put("Equipo", equipo);
        values.put("Ciudad", ciudad);
        values.put("Puntos", puntos);
        values.put("Foto", foto);
        db.insert("Equipos", null, values);
    }

    public void insertaEncuentros (int encuentros,String fecha, String equipo1, String equipo2, int puntuacion1, int puntuacion2){
        ContentValues values = new ContentValues();
        values.put("Encuentros", encuentros);
        values.put("Fecha", fecha);
        values.put("Equipo1", equipo1);
        values.put("Equipo2", equipo2);
        values.put("Puntuacion1", puntuacion1);
        values.put("Puntuacion2", puntuacion2);
        db.insert("Encuentros", null, values);
    }
}