package com.example.reviewcelular.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.reviewcelular.database.dao.CelularDAO;
import com.example.reviewcelular.entity.Celular;

@Database(entities = {Celular.class}, version = 1, exportSchema = false)
public abstract class CelularesDB extends RoomDatabase {

    // constante com o nome do banco de dados
    private static final String DB_NAME = "celulares.db";

    // retorna uma intancia ativa de jogoDAO
    public abstract CelularDAO getCelularDAO();

    // atributo estático para garantir que haja apenas uma instance desta classe ativa por vez
    private static CelularesDB instance;

    // método que retorna a instancia ativa com o banco de dados
    public static CelularesDB getInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context, CelularesDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
