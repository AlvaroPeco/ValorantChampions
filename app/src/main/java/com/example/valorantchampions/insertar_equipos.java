package com.example.valorantchampions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class insertar_equipos extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteHelper helper;
    TextView nombre, ciudad;
    String nombre1, ciudad1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_equipos);
        helper=new SQLiteHelper(this);
        db = helper.getWritableDatabase();
        nombre = findViewById(R.id.textNombre);
        ciudad = findViewById(R.id.textCiudad);
        nombre1 = String.valueOf(nombre.getText());
        ciudad1 = String.valueOf(ciudad.getText());
    }

    public void insertarEquipos(String equipo, String ciudad) {
            ContentValues values = new ContentValues();
            values.put("Equipo", equipo);
            values.put("Ciudad", ciudad);
            values.put("Puntos", 0);
            values.put("Foto", R.drawable.nuevousuario);
            db.insert("Equipos", null, values);
    }

    public void insertaEquipos(View view) {
        insertarEquipos(nombre1, ciudad1);
    }
}