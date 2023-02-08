package com.example.valorantchampions;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Clasificacion extends AppCompatActivity {


    SQLiteHelper helper;
    SQLiteDatabase db;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clasificacion);
        lv=findViewById(R.id.listaEquipos);
        consultaEquiposPuntos();
    }

    public void consultaEquiposPuntos (){
        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        Cursor cursor =
                db.query(EstructuraBBDD.EstructuraEquipos.TABLE_NAME_EQUIPOS, null,
                        null, null, null, null, EstructuraBBDD.EstructuraEquipos.COLUMN_NAME_PUNTOS + " DESC");


        String [] from = {EstructuraBBDD.EstructuraEquipos.COLUMN_FOTO_FOTO,
                EstructuraBBDD.EstructuraEquipos.COLUMN_NAME_EQUIPO,
                EstructuraBBDD.EstructuraEquipos.COLUMN_NAME_PUNTOS,
                };
        int[] to = {R.id.imagenClasi, R.id.textoClasi2,R.id.textoClasi3};
        SimpleCursorAdapter adaptador1 = new SimpleCursorAdapter(this,
                R.layout.listaclasificacion, cursor, from, to,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adaptador1);
        db.close();
    }
}