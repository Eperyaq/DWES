package com.es.tema1.EjercicioIsAdmin.repository;

import java.util.List;

/**
 * Interfaz genérica que define las operaciones básicas de un repositorio.
 * Proporciona métodos para insertar, obtener, actualizar y eliminar entidades.
 *
 * @param <K> Tipo de la clave primaria del repositorio.
 * @param <T> Tipo de la entidad que se maneja en el repositorio.
 */
public interface RepositoryInterface<K, T> {

    /**
     * Inserta una nueva entidad en el repositorio.
     *
     * @param x La entidad a insertar.
     * @return La entidad insertada.
     */
    T insert(T x);

    /**
     * Obtiene una entidad del repositorio mediante su clave.
     *
     * @param key La clave de la entidad a obtener.
     * @return La entidad encontrada o null si no existe.
     */
    T get(K key);

    /**
     * Obtiene todas las entidades del repositorio.
     *
     * @return Lista de todas las entidades en el repositorio.
     */
    List<T> getAll();

    /**
     * Actualiza un campo de una entidad específica en el repositorio.
     *
     * @param key           La clave de la entidad a actualizar.
     * @param campoACambiar Campo a cambiar según lo que se desee modificar.
     * @param valorCambiado El nuevo valor para el campo a cambiar.
     * @return La entidad actualizada o null si no se encuentra.
     */
    T update(K key, int campoACambiar, String valorCambiado);

    /**
     * Elimina una entidad del repositorio mediante su clave.
     *
     * @param key La clave de la entidad a eliminar.
     */
    void delete(K key);
}
