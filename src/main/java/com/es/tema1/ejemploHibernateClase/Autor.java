package com.es.tema1.ejemploHibernateClase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Autor {

    @Id
    private String Dni;

    @Column
    private String nPeliculas;

    public Autor() {
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getnPeliculas() {
        return nPeliculas;
    }

    public void setnPeliculas(String nPeliculas) {
        this.nPeliculas = nPeliculas;
    }
}
