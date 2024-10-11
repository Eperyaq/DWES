package com.es.tema1.EjercicioIsAdmin.io;

import com.es.tema1.EjercicioIsAdmin.controller.UserController;
import com.es.tema1.EjercicioIsAdmin.model.RespuestaHTTP;
import com.es.tema1.EjercicioIsAdmin.service.UserService;

import java.util.Scanner;

public class Console implements IOutputInterface{
    private static final  Scanner lector = new Scanner(System.in);
    private static final UserService service = new UserService();

    @Override
    public void Escribir(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public  void Escribir(String mensaje, boolean saltoLinea){
        if (!saltoLinea){
            System.out.print(mensaje);
        }else {
            System.out.println(mensaje);
        }
    }

    @Override
    public  String PreguntarString(String mensaje){
        String respuesta;

        do {
            Escribir(mensaje);
            respuesta = lector.nextLine();

            if (respuesta.isEmpty()) {
                Escribir("Error, no ha introducido nada.");
            }

        } while (respuesta.isEmpty());

        return respuesta;
    }

    @Override
    public  int PedirNum(String mensaje){
        int numero;

        while (true){
            try{
                Escribir(mensaje);
                String entrada = lector.nextLine();

                if (entrada.isEmpty()){
                    Escribir("Error, no has introducido nada, prueba de nuevo: ");
                    continue; //Vuelve al inicio del bucle
                }

                numero = Integer.parseInt(entrada);
                break; //Si no da error, se sale
            }catch (Exception e){
                Escribir("Error, pruebe de nuevo:");
                lector.nextLine(); //Limpia el buffer en caso de error.
            }
        }

        return numero;
    }

    @Override
    public void Menu(boolean admin){

        UserController controller = new UserController();

        String opcion = "";
        while (!opcion.equals("0")) {



            opcion = PreguntarString("""
                    
                    Elija opcion:
                    1. Insertar Usuario
                    2. Modificar Usuario
                    3. Obtener Usuario
                    4. Obtener lista de Usuarios
                    5. Eliminar Usuario
                    0. Salir
                    
                    """);


            switch (opcion) {
                case "1":

                    String unombre = PreguntarString("Inserta la ID de usuario");

                    String uemail = PreguntarString("Inserta el email del usuario");

                    String ucontra = PreguntarString("Inserta la contraseña del usuario.");



                    RespuestaHTTP r1 = controller.insert(unombre, uemail,ucontra, admin);

                    if (r1.getCodigoRespuesta() == 200) {
                        Escribir(r1.getUser().toString());
                    } else {
                        Escribir(r1.getMensajeRespuesta());
                    }

                break;

                case "2":
                    String id = PreguntarString("Inserta el id del usuario a cambiar");
                    int campoACambiar = PedirNumEnRango("Indique el campo que quiera cambiar: \n1. Cambiar Admin \n2. Cambiar Correo \n3. Cambiar Contraseña",1,3);
                    String valorCambiado = PreguntarString("Indique el valor del campo cambiado");

                    RespuestaHTTP r2 = controller.update(id,campoACambiar,valorCambiado);

                    if (r2.getCodigoRespuesta() == 200){
                        Escribir(r2.getUser().toString());
                    }

                case "3":
                    String id3 = PreguntarString("Inserta el ID del usuario");
                    RespuestaHTTP r3 = controller.getUser(id3);

                    if (r3.getCodigoRespuesta() == 200) {
                        Escribir(r3.getUser().toString());
                    } else {
                        Escribir(r3.getMensajeRespuesta());
                    }
                break;

                case "4":
                    Escribir("Mostrando todos los usuarios...");
                    RespuestaHTTP r4 = controller.getAllUsers();

                    if (r4.getCodigoRespuesta() == 200){

                    }else {
                        Escribir("Error al mostrar los usuarios");
                    }
                break;

                case "5":
                    String id5 =PreguntarString("Inserta el ID del usuario a eliminar");
                    RespuestaHTTP res5 = controller.deleteUser(id5);

                    if (res5.getCodigoRespuesta() == 200) {
                        Escribir("Borrado con exito");
                    } else {
                        Escribir("Error al borrar el usuario");
                    }
                    break;

                case "0":
                    System.out.println("Saliendo...");
                    break;

                default:
                    Escribir("Error opcion no valida");
                    break;
            }
        }
    }

    @Override
    public String ValidarEmail(String email) {
        if(email.contains("@") && email.endsWith(".com") || email.endsWith(".es") && email.length() < 20){
            return email;
        } else {
            return null;
        }
    }
    @Override
    public  int PedirNumEnRango(String mensaje, int min, int max) {
        int numero;
        while (true) {
            try {
                String entrada = PreguntarString(mensaje);

                if (entrada.isEmpty()) {  // Si la entrada está vacía
                    Escribir("Error: no has introducido nada. Inténtalo de nuevo.");
                    continue;  // Volver a pedir el número
                }

                numero = Integer.parseInt(entrada);  // Convierte la entrada en número

                if (numero >= min && numero <= max) {  // Verifica si está dentro del rango
                    break;  // Si el número está dentro del rango, se sale del bucle
                } else {
                    Escribir("Error: el número debe estar entre " + min + " y " + max + ". Inténtalo de nuevo.");
                }

            } catch (NumberFormatException e) {  // Si no es un número válido
                Escribir("Error: valor no válido. Inténtalo de nuevo.");
            }
        }

        return numero;  // Devuelve el número válido dentro del rango
    }

    @Override
    public boolean EsAdmin(){
        String esAdmin = PreguntarString("Eres admin s/n");

        boolean admin;
        if (esAdmin.equals("s")){
            admin = true;
        } else {
            admin = false;
        }
        return admin;
    }
}
