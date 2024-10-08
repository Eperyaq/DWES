package com.es.tema1.EjerProductos.service;

import com.es.tema1.EjerProductos.model.Empleado;
import com.es.tema1.EjerProductos.model.Producto;
import com.es.tema1.EjerProductos.repository.GenericRepositoryAPI;
import com.es.tema1.EjerProductos.repository.ProductoRepository;

import java.util.List;

public class ProductoService  {

    private GenericRepositoryAPI<String, Producto> repository;

    public ProductoService(){
        this.repository = new ProductoRepository();
    }

    public Producto insert(Producto newProduct){
        if (newProduct == null) return null;

        return repository.insert(newProduct);
    }
}
