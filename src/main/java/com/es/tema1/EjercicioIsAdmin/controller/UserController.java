package com.es.tema1.EjercicioIsAdmin.controller;

import com.es.tema1.EjercicioIsAdmin.io.Console;
import com.es.tema1.EjercicioIsAdmin.io.IOutputInterface;
import com.es.tema1.EjercicioIsAdmin.model.RespuestaHTTP;
import com.es.tema1.EjercicioIsAdmin.model.User;
import com.es.tema1.EjercicioIsAdmin.service.UserService;

import java.util.List;

/**
 * Controlador para manejar las operaciones relacionadas con los usuarios.
 * Interactúa con el servicio de usuarios para realizar acciones como insertar, obtener, actualizar y eliminar usuarios.
 */
public class UserController {

    private UserService service;

    public UserController() {
        this.service = new UserService();
    }

    /**
     * Inserta un nuevo usuario en el sistema.
     *
     * @param id       El ID del usuario.
     * @param correo   El correo del usuario.
     * @param password La contraseña del usuario.
     * @param isAdmin  Indica si el usuario es administrador.
     * @return Un objeto RespuestaHTTP que contiene el estado de la operación.
     */
    public RespuestaHTTP insert(String id, String correo, String password, boolean isAdmin) {
        try {
            if (id == null || id.isEmpty() || correo == null || correo.isEmpty() || password == null || password.isEmpty()) {
                return new RespuestaHTTP(400, "Bad Request");
            }

            User usuario = service.insertUser(id, correo, password, isAdmin);

            if (isAdmin) {
                return usuario != null ?
                        new RespuestaHTTP(200, "Okey", usuario) :
                        new RespuestaHTTP(400, "Bad request");
            } else {
                return new RespuestaHTTP(403, "Forbidden");
            }

        } catch (Exception e) {
            return new RespuestaHTTP(404, "Not found");
        }
    }

    /**
     * Obtiene un usuario específico del sistema.
     *
     * @param key La clave (ID) del usuario a obtener.
     * @return Un objeto RespuestaHTTP que contiene el estado de la operación y el usuario solicitado.
     */
    public RespuestaHTTP getUser(String key) {
        try {
            if (key.isEmpty() || key == null) {
                return new RespuestaHTTP(400, "Bad request");
            } else {
                User usuario = service.get(key);
                return usuario != null ?
                        new RespuestaHTTP(200, "Ok", usuario) :
                        new RespuestaHTTP(400, "Bad request");
            }
        } catch (Exception e) {
            return new RespuestaHTTP(404, "Not found");
        }
    }

    /**
     * Actualiza un campo específico de un usuario.
     *
     * @param key             La clave del usuario a actualizar.
     * @param campoACambiar   El campo que se desea cambiar (1: admin, 2: correo, 3: contraseña).
     * @param valorCambiado   El nuevo valor para el campo especificado.
     * @return Un objeto RespuestaHTTP que contiene el estado de la operación y el usuario actualizado.
     */
    public RespuestaHTTP update(String key, int campoACambiar, String valorCambiado) {
        try {
            if (key == null || key.isEmpty() || valorCambiado.isEmpty() || valorCambiado == null) {
                return new RespuestaHTTP(400, "Bad request");
            } else {
                User usuario = service.update(key, campoACambiar, valorCambiado);

                if (usuario.getAdmin()) {
                    return usuario != null ?
                            new RespuestaHTTP(200, "Okey", usuario) :
                            new RespuestaHTTP(400, "Bad request");
                } else {
                    return new RespuestaHTTP(403, "Forbidden");
                }
            }
        } catch (Exception e) {
            return new RespuestaHTTP(404, "Not found");
        }
    }

    /**
     * Obtiene todos los usuarios del sistema.
     *
     * @return Un objeto RespuestaHTTP que contiene el estado de la operación.
     */
    public RespuestaHTTP getAllUsers() {
        try {
            List<User> todosUsuarios = service.getAll();
            System.out.println(todosUsuarios);
            return todosUsuarios != null ?
                    new RespuestaHTTP(200, "Ok") :
                    new RespuestaHTTP(400, "Bad request");
        } catch (Exception e) {
            return new RespuestaHTTP(404, "Not found");
        }
    }

    /**
     * Elimina un usuario del sistema.
     *
     * @param key La clave (ID) del usuario a eliminar.
     * @return Un objeto RespuestaHTTP que contiene el estado de la operación.
     */
    public RespuestaHTTP deleteUser(String key) {
        try {
            if (key.isEmpty() || key == null) {
                return new RespuestaHTTP(400, "Bad request");
            }

            User usuario = service.get(key);

            if (usuario.getAdmin()) { // si el usuario es admin puede realizar la operación
                service.delete(key);
                return usuario != null ?
                        new RespuestaHTTP(200, "Ok", usuario) :
                        new RespuestaHTTP(400, "Bad request");
            } else {
                return new RespuestaHTTP(403, "Forbidden");
            }

        } catch (Exception e) {
            return new RespuestaHTTP(404, "Not found");
        }
    }
}
