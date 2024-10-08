package com.es.tema1.EjerProductos.model;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String id, double precio, String nombre, int stock) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
//--------------------------------------------------------
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
