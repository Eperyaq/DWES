package com.es.tema1.EjerProductos.repository;

import com.es.tema1.EjerProductos.model.Empleado;
import com.es.tema1.EjerProductos.model.Producto;

import java.util.*;

public class ProductoRepository implements GenericRepositoryAPI<String, Producto> {

    private Set<Producto> bddProductos = new HashSet<>();


    @Override
    public Producto insert(Producto x) {
        bddProductos.add(x);
        return x;
    }

    @Override
    public Producto get(String key) {
        return  bddProductos
                .stream()
                .filter(p-> p.getId().equals(key))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Producto> getAll() {

        return bddProductos.stream().toList();
    }

    @Override
    public void delete(String key) {
        Producto productToDelete = bddProductos
                .stream()
                .filter(p -> p.getId().equals(key))
                .findFirst()
                .orElse(null);

        bddProductos.remove(productToDelete);
    }
}
