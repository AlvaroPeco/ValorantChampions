package com.example.valorantchampions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SyncStatusObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class eliminar_equipos extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteHelper helper;
    EditText nombre;
    String nombreEquipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_equipos);
        helper=new SQLiteHelper(this);
        db = helper.getWritableDatabase();
        nombre=findViewById(R.id.textNombreEquipo);
        nombreEquipo = String.valueOf(nombre.getText());

    }


    private void eliminarEquipos(String nombreDelEquipo) {
        db.delete("Equipos", "Equipo=?", new String []{String.valueOf(nombreDelEquipo)});
    }

    public void eliminarEquipo(View view) {
        eliminarEquipos(nombreEquipo);
    }
}