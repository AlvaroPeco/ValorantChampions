package com.example.valorantchampions;

import android.provider.BaseColumns;

public class EstructuraBBDD {
    public static final String SQL_CREATE_ENTRIES_EQUIPOS =
            "CREATE TABLE IF NOT EXISTS "+ EstructuraEquipos.TABLE_NAME_EQUIPOS +
                    "(" + EstructuraEquipos._ID + " integer PRIMARY KEY, "
                    + EstructuraEquipos.COLUMN_NAME_EQUIPO + " text, "
                    + EstructuraEquipos.COLUMN_NAME_CIUDAD + " text, "
                    + EstructuraEquipos.COLUMN_NAME_PUNTOS + " integer, "
                    + EstructuraEquipos.COLUMN_FOTO_FOTO + " integer);";

    public static final String SQL_CREATE_ENTRIES_PARTIDOS =
            "CREATE TABLE IF NOT EXISTS "+ Partidos.TABLE_NAME_PARTIDOS+
            "(" + Partidos._ID + " integer PRIMARY KEY, "
            + Partidos.COLUMN_NAME_ENCUENTRO + " integer, "
            + Partidos.COLUMN_NAME_FECHA + " text, "
            + Partidos.COLUMN_NAME_EQUIPO1 + " text, "
            + Partidos.COLUMN_NAME_EQUIPO2 + " text, "
            + Partidos.COLUMN_NAME_PUNTUACION1 + " integer "
            + Partidos.COLUMN_NAME_PUNTUACION2 + " integer);";

    public static final String SQL_DELETE_ENTRIES_EQUIPOS =
            "DROP TABLE IF EXISTS " + EstructuraEquipos.TABLE_NAME_EQUIPOS;
    public static final String SQL_DELETE_ENTRIES_PARTIDOS =
            "DROP TABLE IF EXISTS " + Partidos.TABLE_NAME_PARTIDOS;
    private EstructuraBBDD() {}

    /* Clase interna que define la estructura de la tabla de operas */

    public static class EstructuraEquipos implements BaseColumns {
        public static final String TABLE_NAME_EQUIPOS = "Equipos";
        public static final String COLUMN_NAME_EQUIPO = "Equipo";
        public static final String COLUMN_NAME_CIUDAD = "Ciudad";
        public static final String COLUMN_NAME_PUNTOS = "Puntos";
        public static final String COLUMN_FOTO_FOTO = "foto";
    }

    public static class Partidos implements BaseColumns {
        public static final String TABLE_NAME_PARTIDOS = "Encuentros";
        public static final String COLUMN_NAME_ENCUENTRO = "Encuentro";
        public static final String COLUMN_NAME_FECHA = "Fecha";
        public static final String COLUMN_NAME_EQUIPO1 = "NombreEquipo1";
        public static final String COLUMN_NAME_EQUIPO2 = "NombreEquipo2";
        public static final String COLUMN_NAME_PUNTUACION1 = "Puntuacion1";
        public static final String COLUMN_NAME_PUNTUACION2 = "Puntuacion2";
    }
}
