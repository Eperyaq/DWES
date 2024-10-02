package com.es.tema1.EjercicioEmail;

import com.es.tema1.EjercicioEmail.controller.UserEmailController;
import com.es.tema1.EjercicioEmail.model.RespuestaHTTP;
import com.es.tema1.EjercicioEmail.model.UserEmail;


public class AppEmail {

    public static void main(String[] args) {
        UserEmailController controlado = new UserEmailController();
        controlado.insertUserEmail("pepe@billuela.es","pepe");

        RespuestaHTTP respuesta = controlado.getUserEmail("pepe@billuela.es");

        System.out.println(respuesta);
    }
}
