package com.es.tema1.EjercicioIsAdmin.io;

import com.es.tema1.EjercicioIsAdmin.controller.UserController;
import com.es.tema1.EjercicioIsAdmin.model.RespuestaHTTP;
import com.es.tema1.EjercicioIsAdmin.service.UserService;

import java.util.Scanner;

/**
 * Clase Console que implementa la interfaz IOutputInterface.
 * Esta clase permite interactuar con el usuario a través de la consola.
 * Incluye métodos para escribir, preguntar, y gestionar entradas de números
 * o cadenas, así como menús interactivos para la administración de usuarios.
 */
public class Console implements IOutputInterface {

    private static final Scanner lector = new Scanner(System.in);
    private static final UserService service = new UserService();

    /**
     * Escribe un mensaje en la consola con un salto de línea al final.
     * @param mensaje El mensaje a mostrar.
     */
    @Override
    public void Escribir(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Escribe un mensaje en la consola con o sin salto de línea, según el parámetro.
     * @param mensaje El mensaje a mostrar.
     * @param saltoLinea Si es true, incluye un salto de línea, si es false, no lo incluye.
     */
    @Override
    public void Escribir(String mensaje, boolean saltoLinea) {
        if (!saltoLinea) {
            System.out.print(mensaje);
        } else {
            System.out.println(mensaje);
        }
    }

    /**
     * Solicita una cadena de texto al usuario. Si la entrada está vacía, vuelve a preguntar.
     * @param mensaje El mensaje que se muestra al usuario para solicitar la entrada.
     * @return La cadena de texto ingresada por el usuario.
     */
    @Override
    public String PreguntarString(String mensaje) {
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

    /**
     * Solicita un número al usuario, validando que sea un número entero.
     * Si la entrada es inválida o vacía, vuelve a preguntar.
     * @param mensaje El mensaje que se muestra al usuario para solicitar el número.
     * @return El número entero ingresado por el usuario.
     */
    @Override
    public int PedirNum(String mensaje) {
        int numero;
        while (true) {
            try {
                Escribir(mensaje);
                String entrada = lector.nextLine();
                if (entrada.isEmpty()) {
                    Escribir("Error, no has introducido nada, prueba de nuevo: ");
                    continue;
                }
                numero = Integer.parseInt(entrada);
                break;
            } catch (Exception e) {
                Escribir("Error, pruebe de nuevo:");
                lector.nextLine(); // Limpia el buffer en caso de error.
            }
        }
        return numero;
    }

    /**
     * Muestra un menú interactivo para la administración de usuarios.
     * Permite al usuario realizar operaciones como insertar, modificar, obtener,
     * listar o eliminar usuarios.
     * @param admin Un booleano que indica si el usuario actual tiene permisos de administrador.
     */
    @Override
    public void Menu(boolean admin) {
        UserController controller = new UserController();
        String opcion = "";
        while (!opcion.equals("0")) {
            opcion = PreguntarString("""
                    Elija opción:
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
                    RespuestaHTTP r1 = controller.insert(unombre, uemail, ucontra, admin);
                    if (r1.getCodigoRespuesta() == 200) {
                        Escribir(r1.getUser().toString());
                    } else {
                        Escribir(r1.getMensajeRespuesta());
                    }
                    break;

                case "2":
                    String id = PreguntarString("Inserta el id del usuario a cambiar");
                    int campoACambiar = PedirNumEnRango("Indique el campo que quiera cambiar: \n1. Cambiar Admin \n2. Cambiar Correo \n3. Cambiar Contraseña", 1, 3);
                    String valorCambiado = PreguntarString("Indique el valor del campo cambiado");
                    RespuestaHTTP r2 = controller.update(id, campoACambiar, valorCambiado);
                    if (r2.getCodigoRespuesta() == 200) {
                        Escribir(r2.getUser().toString());
                    }
                    break;

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
                    if (r4.getCodigoRespuesta() == 200) {
                        // Imprimir lista de usuarios aquí
                    } else {
                        Escribir("Error al mostrar los usuarios");
                    }
                    break;

                case "5":
                    String id5 = PreguntarString("Inserta el ID del usuario a eliminar");
                    RespuestaHTTP res5 = controller.deleteUser(id5);
                    if (res5.getCodigoRespuesta() == 200) {
                        Escribir("Borrado con éxito");
                    } else {
                        Escribir("Error al borrar el usuario");
                    }
                    break;

                case "0":
                    Escribir("Saliendo...");
                    break;

                default:
                    Escribir("Error, opción no válida");
                    break;
            }
        }
    }

    /**
     * Valida un correo electrónico. Comprueba si el correo contiene "@" y termina en ".com" o ".es",
     * y si su longitud es menor de 20 caracteres.
     * @param email El correo electrónico a validar.
     * @return El correo válido o null si no cumple las condiciones.
     */
    @Override
    public String ValidarEmail(String email) {
        if ((email.contains("@") && (email.endsWith(".com") || email.endsWith(".es"))) && email.length() < 20) {
            return email;
        } else {
            return null;
        }
    }

    /**
     * Solicita un número al usuario dentro de un rango especificado. Si el número ingresado no está
     * en el rango, vuelve a preguntar.
     * @param mensaje El mensaje que se muestra al usuario.
     * @param min El valor mínimo del rango.
     * @param max El valor máximo del rango.
     * @return El número válido dentro del rango.
     */
    @Override
    public int PedirNumEnRango(String mensaje, int min, int max) {
        int numero;
        while (true) {
            try {
                String entrada = PreguntarString(mensaje);
                if (entrada.isEmpty()) {
                    Escribir("Error: no has introducido nada. Inténtalo de nuevo.");
                    continue;
                }
                numero = Integer.parseInt(entrada);
                if (numero >= min && numero <= max) {
                    break;
                } else {
                    Escribir("Error: el número debe estar entre " + min + " y " + max + ". Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                Escribir("Error: valor no válido. Inténtalo de nuevo.");
            }
        }
        return numero;
    }

    /**
     * Pregunta al usuario si es administrador.
     * @return true si el usuario es administrador, false en caso contrario.
     */
    @Override
    public boolean EsAdmin() {
        String esAdmin = PreguntarString("Eres admin s/n");
        return esAdmin.equals("s");
    }
}
