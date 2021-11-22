package com.example.reviewcelular.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.reviewcelular.entity.Celular;

import java.util.List;

@Dao
public interface CelularDAO {

    @Insert
    void salvarCelular(Celular celular);

    @Update
    void editarCelular(Celular celular);

    @Delete
    void excluirCelular(Celular celular);

    @Query("SELECT * FROM `celulares.tb`")
    List<Celular> getCelulares();


}
