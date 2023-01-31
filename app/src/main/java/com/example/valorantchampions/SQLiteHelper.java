package com.example.valorantchampions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "bdValorant.db";
    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EstructuraBBDD.SQL_CREATE_ENTRIES_EQUIPOS);
        db.execSQL(EstructuraBBDD.SQL_CREATE_ENTRIES_PARTIDOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(EstructuraBBDD.SQL_DELETE_ENTRIES_EQUIPOS);
        db.execSQL(EstructuraBBDD.SQL_CREATE_ENTRIES_PARTIDOS);
    }
}
