package com.example.valorantchampions;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Encuentros extends AppCompatActivity {

    SQLiteHelper helper;
    SQLiteDatabase db;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuentros);
        lv = findViewById(R.id.listaEncuentros);
        consultaEncuentros();
    }
    public void consultaEncuentros (){
        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        Cursor cursor =
                db.query(EstructuraBBDD.Partidos.TABLE_NAME_PARTIDOS, null,
                        null, null, null, null, EstructuraBBDD.Partidos.COLUMN_NAME_ENCUENTRO + " ASC");

        String [] from = {EstructuraBBDD.Partidos.COLUMN_NAME_FECHA,
                EstructuraBBDD.Partidos.COLUMN_NAME_ENCUENTRO,
                EstructuraBBDD.Partidos.COLUMN_NAME_EQUIPO1,
                EstructuraBBDD.Partidos.COLUMN_NAME_PUNTUACION1,
                EstructuraBBDD.Partidos.COLUMN_NAME_PUNTUACION2,
                EstructuraBBDD.Partidos.COLUMN_NAME_EQUIPO2};
        int[] to = {R.id.textFecha, R.id.textNum,R.id.textE1, R.id.textP1, R.id.textP2, R.id.textE2};
        SimpleCursorAdapter adaptador3 = new SimpleCursorAdapter(this,
                R.layout.lista_encuentros, cursor, from, to,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adaptador3);
        db.close();
    }

}