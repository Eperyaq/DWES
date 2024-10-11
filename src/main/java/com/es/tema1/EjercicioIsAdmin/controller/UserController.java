package com.es.tema1.EjercicioIsAdmin.controller;

import com.es.tema1.EjercicioIsAdmin.io.Console;
import com.es.tema1.EjercicioIsAdmin.io.IOutputInterface;
import com.es.tema1.EjercicioIsAdmin.model.RespuestaHTTP;
import com.es.tema1.EjercicioIsAdmin.model.User;
import com.es.tema1.EjercicioIsAdmin.service.UserService;

import javax.naming.LinkRef;
import java.util.List;

public class UserController {

    private UserService service;

    public UserController() { this.service = new UserService(); }


    public RespuestaHTTP insert(String id, String correo, String password, boolean isAdmin) {
        try {
            if (id == null || id.isEmpty() || correo == null || correo.isEmpty() || password == null || password.isEmpty()) {
                return new RespuestaHTTP(400, "Bad Request");

            }

            User usuario = service.insertUser(id, correo, password,isAdmin);


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

    public RespuestaHTTP getUser(String key){

        try {
            if (key.isEmpty() || key == null) {
                return new RespuestaHTTP(400, "Bad request");
            }else {
                User usuario = service.get(key);

                return usuario != null ?
                        new RespuestaHTTP(200, "Ok", usuario) :
                        new RespuestaHTTP(400, "Bad request");
            }
        }catch (Exception e){
            return new RespuestaHTTP(404, "Not found");
        }
    }

    public RespuestaHTTP update(String key, int campoACambiar, String valorCambiado){
        try {
            if ( key == null || key.isEmpty() || valorCambiado.isEmpty() || valorCambiado == null){
                return new RespuestaHTTP(400,"Bad request");
            } else {
                User usuario = service.update(key,campoACambiar,valorCambiado);

                if (usuario.getAdmin()) {
                    return usuario != null ?
                            new RespuestaHTTP(200, "Okey", usuario) :
                            new RespuestaHTTP(400, "Bad request");
                } else {
                    return new RespuestaHTTP(403, "Forbidden");
                }
            }
        }catch (Exception e ){
            return new RespuestaHTTP(404,"Not found");
        }
    }

    public RespuestaHTTP getAllUsers(){
        try {
            List<User> todosUsuarios = service.getAll();
            System.out.println(todosUsuarios);

            return todosUsuarios != null ?
                    new RespuestaHTTP(200, "Ok") :
                    new RespuestaHTTP(400, "Bad request");

        }catch (Exception e){
            return new RespuestaHTTP(404, "not found");
        }
    }

    public RespuestaHTTP deleteUser(String key){
        try {
            if (key.isEmpty() || key == null){
                new RespuestaHTTP(400, "Bad request");
            }

             User usuario = service.get(key);

            if (usuario.getAdmin()){ // si el usuario es admin puede realizar la operacion, si no, no
                service.delete(key);
                return usuario != null ?

                        new RespuestaHTTP(200, "Ok",usuario):
                        new RespuestaHTTP(400,"Bad request");
            }else {
                return new RespuestaHTTP(403, "Forbidden");
            }

        }catch (Exception e){
            return new RespuestaHTTP(404, "not found");
        }
    }

}
