package com.es.tema1.ejemploHibernateClase;

import jakarta.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "calle", nullable = false, length = 50)
    private String calle;

    @Column(name = "numero", length = 50)
    private int numero;

    @Column(name = "codigo_postal", nullable = false, length = 50)
    private String cp;

    @OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cine cine; //Si queremos que se mapee direccionalmente


    public Direccion() {
    }

    public Direccion(String calle, int numero, String cp, Cine cine) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.cine = cine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
}
