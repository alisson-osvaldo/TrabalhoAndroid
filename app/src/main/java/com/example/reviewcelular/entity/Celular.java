package com.example.reviewcelular.entity;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity (tableName = "celulares.tb")
public class Celular implements Serializable{

    @PrimaryKey (autoGenerate = true)
    private int id;
    private String modelo;
    private String marca;
    private String sistema;
    private int ram;

    public Celular() {
    }

    @Ignore
    public Celular(int id, String modelo, String marca, String sistema, int ram) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.sistema = sistema;
        this.ram = ram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }



}
