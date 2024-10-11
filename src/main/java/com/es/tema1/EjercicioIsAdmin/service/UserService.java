package com.es.tema1.EjercicioIsAdmin.service;

import com.es.tema1.EjercicioEmail.model.UserEmail;
import com.es.tema1.EjercicioEmail.utils.EncryptUtil;
import com.es.tema1.EjercicioIsAdmin.Utils.EncryptedUtils;
import com.es.tema1.EjercicioIsAdmin.io.Console;
import com.es.tema1.EjercicioIsAdmin.io.IOutputInterface;
import com.es.tema1.EjercicioIsAdmin.model.User;
import com.es.tema1.EjercicioIsAdmin.repository.RepositoryInterface;
import com.es.tema1.EjercicioIsAdmin.repository.UserRepository;

import javax.naming.AuthenticationNotSupportedException;
import java.util.List;

/**
 * Servicio que maneja las operaciones relacionadas con los usuarios.
 * Incluye métodos para insertar, obtener, actualizar y eliminar usuarios.
 */
public class UserService {

    private RepositoryInterface<String, User> userRepository = new UserRepository();
    private IOutputInterface consola = new Console();

    /**
     * Inserta un nuevo usuario en el repositorio.
     *
     * @param id        El identificador del usuario.
     * @param correo    El correo electrónico del usuario.
     * @param contrasenia La contraseña del usuario.
     * @param isAdmin   Indica si el usuario es administrador.
     * @return El usuario insertado o null si no se pudo insertar.
     */
    public User insertUser(String id, String correo, String contrasenia, boolean isAdmin) {
        try {
            if (id.isEmpty() || correo.isEmpty() || contrasenia.isEmpty()) {
                consola.Escribir("Error, datos vacios...");
                return null;
            }

            String contra = EncryptedUtils.encriptador(contrasenia);
            String correoValido = consola.ValidarEmail(correo);

            if (correoValido != null) {
                if (correo.length() > 20) {
                    consola.Escribir("El correo no puede tener mas de 20 caracteres");
                    return null;
                } else {
                    User usuario = new User(id, correo, contra, isAdmin);
                    return userRepository.insert(usuario);
                }
            } else {
                consola.Escribir("Correo invalido");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Obtiene un usuario del repositorio por su clave.
     *
     * @param key La clave del usuario que se desea obtener.
     * @return El usuario correspondiente a la clave o null si no se encuentra.
     */
    public User get(String key) {
        if (key.isEmpty()) {
            consola.Escribir("Error, los datos vienen vacios");
            return null;
        } else {
            return userRepository.get(key);
        }
    }

    /**
     * Obtiene todos los usuarios del repositorio.
     *
     * @return Una lista de todos los usuarios.
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * Actualiza un usuario en el repositorio.
     *
     * @param key              La clave del usuario que se desea actualizar.
     * @param campoACambiar    El campo que se desea cambiar (1: admin, 2: correo, 3: contraseña).
     * @param valorCambiado    El nuevo valor para el campo especificado.
     * @return El usuario actualizado o null si no se pudo actualizar.
     */
    public User update(String key, int campoACambiar, String valorCambiado) {
        if (key.isEmpty() || valorCambiado.isEmpty()) {
            consola.Escribir("Error, los datos vienen vacios");
            return null;
        } else {
            return userRepository.update(key, campoACambiar, valorCambiado);
        }
    }

    /**
     * Elimina un usuario del repositorio.
     *
     * @param key La clave del usuario que se desea eliminar.
     * @return El usuario eliminado o null si no se pudo eliminar.
     */
    public User delete(String key) {
        if (key.isEmpty()) {
            consola.Escribir("Error, los datos vienen vacios");
            return null;
        } else {
            User usuario = get(key);
            userRepository.delete(key);
            return usuario;
        }
    }

}
