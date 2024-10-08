package com.es.tema1.EjerProductos.repository;

import java.util.List;

public interface GenericRepositoryAPI<K,T>{
    //k primary key T objeto


    T insert(T x);

    T get(K key);

    List<T> getAll();

    void delete(K key);


}
