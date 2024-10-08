package com.es.tema1.EjerProductos.repository;

import com.es.tema1.EjerProductos.model.Empleado;
import com.es.tema1.EjerProductos.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository implements GenericRepositoryAPI<String, Empleado>{

    ArrayList<Empleado> bddEmpleados = new ArrayList<>();

    @Override
    public Empleado insert(Empleado x) {
        bddEmpleados.add(x);
        return x;
    }

    @Override
    public Empleado get(String key) {
        return  bddEmpleados
                .stream()
                .filter(e-> e.getDni().equals(key))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Empleado> getAll() {
        return bddEmpleados;
    }

    @Override
    public void delete(String key) {
        Empleado empleToDelete = bddEmpleados
                .stream()
                .filter(e-> e.getDni().equals(key))
                .findFirst()
                .orElse(null);

        bddEmpleados.remove(empleToDelete);
    }
}
