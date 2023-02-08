package com.example.valorantchampions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Equipos extends AppCompatActivity {

    TextView texto1, nombreEquipo, ciudad, puntos;
    SQLiteHelper helper;
    SQLiteDatabase db;
    ListView lv;
    ImageView foto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);

        texto1 = findViewById(R.id.textView);
        nombreEquipo = findViewById(R.id.textNombre);
        ciudad = findViewById(R.id.textCiudad);
        puntos = findViewById(R.id.textPuntos);
        foto= findViewById(R.id.imageView);

        lv = findViewById(R.id.listaM);
        // mostrarTabla();
        consultaEquipos();
    }


    public void consultaEquipos (){
        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        Cursor cursor =
                db.query(EstructuraBBDD.EstructuraEquipos.TABLE_NAME_EQUIPOS, null,
                        null, null, null, null, null);

        String[] from = {EstructuraBBDD.EstructuraEquipos.COLUMN_NAME_EQUIPO,
                EstructuraBBDD.EstructuraEquipos.COLUMN_NAME_CIUDAD,
                EstructuraBBDD.EstructuraEquipos.COLUMN_NAME_PUNTOS,
                EstructuraBBDD.EstructuraEquipos.COLUMN_FOTO_FOTO};
        int[] to = {R.id.textNombre, R.id.textCiudad,R.id.textPuntos, R.id.imageView};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this,
                R.layout.lista, cursor, from, to,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adaptador);
        db.close();
    }


    public void mostrarTabla (){
        helper = new SQLiteHelper(this);
        db = helper.getReadableDatabase();

        Cursor cursor =
                db.query(EstructuraBBDD.EstructuraEquipos.TABLE_NAME_EQUIPOS, null,
                        null, null, null, null, null);

        texto1.append("\n Tabla Equipos \n-----------");
        cursor.moveToFirst();
        int nfilas=cursor.getCount();
        int ncolumnas=cursor.getColumnCount();
        String fila="\n";
        for (int i = 0; i < nfilas; i++) {
            fila="\n";
            for(int j=0;j<ncolumnas;j++){
                fila=fila+cursor.getString(j)+" ";
            }
            texto1.append(fila);
            cursor.moveToNext();
        }

        db.close();
    }
}