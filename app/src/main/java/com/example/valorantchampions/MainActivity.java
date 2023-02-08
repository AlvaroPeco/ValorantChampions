package com.example.valorantchampions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper=new SQLiteHelper(this);
        db = helper.getWritableDatabase();
        db.delete("Equipos", "_id>0", null);
        crearEquipos();



    }

    public void crearEquipos(){
        insertaEquipos("boom", "Indonesia", -15, R.drawable.boom);
        insertaEquipos("cienthieves", "Estados Unidos", -17, R.drawable.cienthieves);
        insertaEquipos("drx", "Korea", 17, R.drawable.drx);
        insertaEquipos("Edward Gaming", "China", -9, R.drawable.edward);
        insertaEquipos("Fnatic", "Europa", 15, R.drawable.fnatic);
        insertaEquipos("Fun Plus Phoenix", "Europa", 13, R.drawable.fun);
        insertaEquipos("Furia eSport", "Brasil", -15, R.drawable.furia);
        insertaEquipos("Kru eSport", "Latam", -8, R.drawable.kru);
        insertaEquipos("Leviatán", "Latam", 13, R.drawable.leviatan);
        insertaEquipos("Team Liquid", "Europa", 2, R.drawable.liquid);
        insertaEquipos("LOUD", "Brasil", 12, R.drawable.loud);
        insertaEquipos("Optic Gaming", "NorteAmerica", 23, R.drawable.optic);
        insertaEquipos("Paper Rex", "Asia", -6, R.drawable.paper);
        insertaEquipos("xSet", "Estados Unidos", 10, R.drawable.set);
        insertaEquipos("xerxia", "Tailandia", -15, R.drawable.xerxia);
        insertaEquipos("Zeta Division", "Japon", -8, R.drawable.zeta);
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

    public void entrarEquipos(View view){
        Intent i = new Intent(this, Equipos.class);
        startActivity(i);
    }

    public void entrarClasi (View view){
        Intent i = new Intent(this, Clasificacion.class);
        startActivity(i);
    }
}