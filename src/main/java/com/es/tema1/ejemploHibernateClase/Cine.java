package com.es.tema1.ejemploHibernateClase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Cine {

    @Id
    private String id;

    @Column
    private String nombre;

    @Column
    private int nAsientos;


    public Cine() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getnAsientos() {
        return nAsientos;
    }

    public void setnAsientos(int nAsientos) {
        this.nAsientos = nAsientos;
    }
}
