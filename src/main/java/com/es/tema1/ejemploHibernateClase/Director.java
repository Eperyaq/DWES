package com.es.tema1.ejemploHibernateClase;

import jakarta.persistence.*;

@Entity
@Table(name = "director")
public class Director {

    @Id
    private String dni;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private int edad;

    @OneToOne(mappedBy = "director" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cine cine;


    public Director() {
    }

    public Director(String dni, int edad, String nombre, Cine cine) {
        this.dni = dni;
        this.edad = edad;
        this.nombre = nombre;
        this.cine = cine;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
