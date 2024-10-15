package com.es.tema1.ejemploHibernateClase;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Crea un valor autoincremental
    private int id;

    @Column(name="titulo", length = 30, unique = true, nullable = false)
    private String titulo;

    @Column(name = "autor", length = 50, unique = false, nullable = false)
    private String autor;

    @Transient
    private String pelota;

    @Column(name = "fecha_lanzamiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaLanzamiento;

    public Pelicula() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPelota() {
        return pelota;
    }

    public void setPelota(String pelota) {
        this.pelota = pelota;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}