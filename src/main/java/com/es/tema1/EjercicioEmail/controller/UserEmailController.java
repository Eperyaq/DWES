package com.es.tema1.EjercicioEmail.controller;

import com.es.tema1.EjercicioEmail.model.RespuestaHTTP;
import com.es.tema1.EjercicioEmail.model.UserEmail;
import com.es.tema1.EjercicioEmail.service.UserEmailService;
import com.es.tema1.ejerIntroCleanCode.clases.User;

public class UserEmailController {

    private UserEmailService service;

    //Constructor
    public UserEmailController(){
        this.service = new UserEmailService();
    }

    public RespuestaHTTP getUserEmail(String email){

        try{

            UserEmail u = service.getUserEmail(email);

            return u != null ?
                    new RespuestaHTTP(u,"Todo ok", 200) :
                    new RespuestaHTTP("Bad request", 400);


        }catch (Exception e){
            return new RespuestaHTTP("Fatal internall Error", 500);
        }

    }

    public RespuestaHTTP insertUserEmail(String email, String nombre){
        try {
            if (nombre == null || nombre.isEmpty() || email == null || email.isEmpty()) {

                return new RespuestaHTTP("Bad Request", 400);
            } else {
                service.insertUserEmail(nombre, email);
                return new RespuestaHTTP("Ok", 200);
            }
        }catch (Exception e){
            return new RespuestaHTTP("Not found", 404);
        }
    }

    public RespuestaHTTP deleteUserEmail(String email){

        try{
            if (email == null || email.isEmpty()) {
                return new RespuestaHTTP("Bad Request", 400);
            }else {
                service.deleterUserEmail(email);
                return new RespuestaHTTP("Ok", 200);
            }
        }catch (Exception e){
            return new RespuestaHTTP("Error de servidor", 500);
        }
    }
}
