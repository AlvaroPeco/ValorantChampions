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
        db.delete("Encuentros", "_id>0", null);
        crearEquipos();
        crearEncuentros();


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

    public void crearEncuentros(){
        insertaEncuentros(1,"08-01-2022", "DRX","FUNPLUS PHOENIX",2, 0 );
        insertaEncuentros(2,"10-01-2022", "LEVIATAN","LOUD",0, 2 );
        insertaEncuentros(3,"12-01-2022", "OPTIC GAMING","TEAM LIQUID",2, 1 );
        insertaEncuentros(4,"14-01-2022", "XSET","FNATIC",2, 0 );
        insertaEncuentros(5,"16-01-2022", "FUNPLUS PHOENIX","LEVIATAN",2, 0 );
        insertaEncuentros(6,"18-01-2022", "TEAM LIQUID","FNATIC",0, 2 );
        insertaEncuentros(7,"20-01-2022", "DRX","LOUD",0, 2 );
        insertaEncuentros(8,"22-01-2022", "OPTIC GAMING","XSET",2, 1 );
        insertaEncuentros(9,"24-01-2022", "XSET","FUNPLUS PHOENIX",1, 2 );
        insertaEncuentros(10,"26-01-2022", "DRX","FNATIC",2, 1 );
        insertaEncuentros(11,"28-01-2022", "FUNPLUS PHOENIX","DRX", 0, 2 );
        insertaEncuentros(12,"30-01-2022", "LOUD","OPTIC GAMING",2, 0 );
        insertaEncuentros(13,"02-02-2022", "OPTIC GAMING","DRX",3, 2 );
        insertaEncuentros(14,"08-02-2022", "LOUD","OPTIC GAMING",3, 1 );
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

    public void entrarEncuentros (View view){
        Intent i = new Intent(this, Encuentros.class);
        startActivity(i);
    }
}