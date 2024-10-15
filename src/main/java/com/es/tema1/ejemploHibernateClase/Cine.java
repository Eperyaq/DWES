package com.es.tema1.ejemploHibernateClase;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cine")
public class Cine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    @Column(name = "numero_asientos")
    private int nAsientos;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_direccion") // le das el nombre a la clave foranea
    private Direccion direccion;


    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "dni_director")
    private Director director;


    public Cine() {
    }

    public Cine(String nombre, int nAsientos, Direccion direccion, Director direc) {
        this.nombre = nombre;
        this.nAsientos = nAsientos;
        this.direccion = direccion;
        this.director = direc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
