package com.es.tema1.ejerIntroCleanCode.controller;

import com.es.tema1.ejerIntroCleanCode.clases.ResponseEntity;
import com.es.tema1.ejerIntroCleanCode.clases.User;
import com.es.tema1.ejerIntroCleanCode.services.UserService;

public class UserController {

    private UserService userService = new UserService();

    /*
    RECORDAMOS QUE EL CONTROLLER SE ENCARGA DE ADMINISTRAR LAS PETICIONES
    Y RESPUESTAS HTTP
     */

    // Funcion de delete del Controller
    public ResponseEntity deleteUser(String nombre) {

        try {

            // Si el controller obtiene un true, significa que ha ido bien, y que se ha eliminado correctamente
            return userService.deleteUser(nombre) ?
                    new ResponseEntity(200, "Usuario Eliminado") :
                    new ResponseEntity(400, "Bad Request");


        } catch (Exception e) {
            // Si capturamos una excepción, significa que ha habido un error interno del sistema
            return new ResponseEntity(500, "mensaje:Una excepcion ha ocurrido");

        }
    }

    public ResponseEntity getUser(String nombre){
        try{
            User u = userService.getUser(nombre);
            return u == null ?
                    new ResponseEntity(404, "Error Not Found"):
                    new ResponseEntity(200, u.toString());

        }catch (Exception e){
            return new ResponseEntity(500, "una excepcion ha ocurrido!");
        }
    }
}
