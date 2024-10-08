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

    public RespuestaHTTP login(String email, String password){
        try {
            if (email == null || email.isEmpty()) return new RespuestaHTTP("Bad request",400);
            if (password == null || password.isEmpty()) return new RespuestaHTTP("Bad request",400);
            boolean respuestaService = service.login(email,password);
            return respuestaService ?
                    new RespuestaHTTP("Ok",200):
                    new RespuestaHTTP("no autorizado", 401);
        }catch (Exception e){
            return new RespuestaHTTP("Server error",500);
        }
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

    public RespuestaHTTP insertUserEmail(String email, String nombre, String password){
        try {
            if (nombre == null || nombre.isEmpty() || email == null || email.isEmpty()) {

                return new RespuestaHTTP("Bad Request", 400);
            } else {

                UserEmail u = service.insertUserEmail(email, nombre, password);
                return u != null ?
                    new RespuestaHTTP(u, "Ok", 200):
                    new RespuestaHTTP("Bad Request", 400);

            }
        }catch (Exception e){
            return new RespuestaHTTP("Not found", 404);
        }
    }

    public Boolean deleteUserEmail(String email){

//        try{
//            if (email == null || email.isEmpty()) {
//                return new RespuestaHTTP("Bad Request", 400);
//            }else {
//                service.deleterUserEmail(email);
//                return new RespuestaHTTP("Ok", 200);
//            }
//        }catch (Exception e){
//            return new RespuestaHTTP("Error de servidor", 500);
//        }

        try {
            UserEmail u = service.deleterUserEmail(email);
            return u != null;

        } catch (Exception e) {
            return false;
        }
    }
}
