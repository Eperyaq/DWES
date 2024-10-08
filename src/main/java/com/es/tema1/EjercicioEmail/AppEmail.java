package com.es.tema1.EjercicioEmail;

import com.es.tema1.EjercicioEmail.controller.UserEmailController;
import com.es.tema1.EjercicioEmail.model.RespuestaHTTP;
import com.es.tema1.EjercicioEmail.model.UserEmail;

import java.util.Scanner;


public class AppEmail {

    public static void main(String[] args) {
        UserEmailController controller = new UserEmailController();

        Scanner lectura = new Scanner(System.in);

        System.out.println();
        String opcion = "";
        while (!opcion.equals("0")) {



            System.out.println("""
                    
                    Elija opcion:
                    1. Insertar Usuario
                    2. Obtener Usuario
                    3. Eliminar Usuario
                    0. Salir
                    
                    """);

            opcion = lectura.next();

            switch (opcion) {
                case "1":
                    System.out.println("Inserta el nombre del usuario: ");
                    String unombre = lectura.next();

                    System.out.println("Inserta el email del usuario: ");
                    String uemail = lectura.next();

                    System.out.println("Inserta la contraseña del usuario: ");
                    String ucontra = lectura.next();

                    RespuestaHTTP r1 = controller.insertUserEmail(unombre, uemail,ucontra);

                    if (r1.getCodigoRespuesta() == 200) {
                        System.out.println(r1.getUserEmail().toString()); //Error aqui creo
                    } else {
                        System.out.println(r1.getMensajeRespuesta());
                    }

                    break;

                case "2":
                    System.out.println("Inserta el email del usuario: ");
                    String email = lectura.next();
                    RespuestaHTTP r2 = controller.getUserEmail(email);

                    if (r2.getCodigoRespuesta() == 200) {
                        System.out.println(r2.getUserEmail().toString());
                    } else {
                        System.out.println(r2.getMensajeRespuesta());
                    }
                    break;

                case "3":
                    System.out.println("Inserta el email del usuario a borrar: ");
                    String uemail2 = lectura.next();
                    Boolean res = controller.deleteUserEmail(uemail2);

                    if (res) {
                        System.out.println("Borrado con exito");
                    } else {
                        System.out.println("Error al borrar el usuario");
                    }
                    break;
                case "0":
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Error opcion no valida");
                    break;
            }
        }

        RespuestaHTTP respuesta = controller.getUserEmail("eliaser@gmail.com");

        System.out.println(respuesta);
    }

}