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
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuentros);
        lv = findViewById(R.id.listaEncuentros);
        texto=findViewById(R.id.textView4);
        helper=new SQLiteHelper(this);
        db = helper.getWritableDatabase();
        consultaEncuentros();

        // Cursor cursor2 = db.query("Encuentros", null, null, null, null,null, null);
        // mostrarTabla(cursor2);
        // db.close();

    }

    public void mostrarTabla(Cursor c) {
        //los mostramos en el cuadro de texto que tenemos en el layout
        texto.append("\n Tabla encuentros \n-----------");
        c.moveToFirst();
        int nfilas=c.getCount();
        int ncolumnas=c.getColumnCount();
        String fila="\n";
        for (int i = 0; i < nfilas; i++) {
            fila="\n";
            for(int j=0;j<ncolumnas;j++){
                fila=fila+c.getString(j)+" ";
            }
            texto.append(fila);
            c.moveToNext();
        }
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