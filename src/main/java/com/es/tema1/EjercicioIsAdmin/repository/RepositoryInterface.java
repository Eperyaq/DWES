package com.es.tema1.EjercicioIsAdmin.repository;

import java.util.List;

public interface RepositoryInterface<K, T> {
    //K primary key T User
    T insert(T x);

    T get(K key);

    List<T> getAll();

    T update(K key, int campoACambiar,String valorCambiado);

    void delete(K key);
}
