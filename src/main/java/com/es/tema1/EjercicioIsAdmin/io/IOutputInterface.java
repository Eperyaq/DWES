package com.es.tema1.EjercicioIsAdmin.io;

/**
 * Interfaz que define los métodos para la salida de datos y la interacción con el usuario.
 * Proporciona métodos para escribir mensajes en la consola, solicitar información del usuario,
 * validar correos electrónicos y gestionar menús.
 */
public interface IOutputInterface {

    /**
     * Escribe un mensaje en la salida.
     *
     * @param mensaje El mensaje a escribir.
     */
    void Escribir(String mensaje);

    /**
     * Escribe un mensaje en la salida, con la opción de agregar un salto de línea.
     *
     * @param mensaje     El mensaje a escribir.
     * @param saltoLinea  Si es verdadero, se añade un salto de línea al final del mensaje.
     */
    void Escribir(String mensaje, boolean saltoLinea);

    /**
     * Pregunta al usuario por una cadena de texto.
     *
     * @param mensaje El mensaje de la pregunta.
     * @return La respuesta del usuario como cadena.
     */
    String PreguntarString(String mensaje);

    /**
     * Solicita un número entero al usuario.
     *
     * @param mensaje El mensaje que solicita el número.
     * @return El número ingresado por el usuario.
     */
    int PedirNum(String mensaje);

    /**
     * Muestra un menú en la salida.
     *
     * @param admin Si es verdadero, se muestra un menú de administrador; de lo contrario, un menú de usuario.
     */
    void Menu(boolean admin);

    /**
     * Valida un correo electrónico proporcionado.
     *
     * @param email La dirección de correo electrónico a validar.
     * @return El correo electrónico validado o null si no es válido.
     */
    String ValidarEmail(String email);

    /**
     * Solicita un número entero dentro de un rango específico.
     *
     * @param mensaje El mensaje que solicita el número.
     * @param min     El valor mínimo del rango.
     * @param max     El valor máximo del rango.
     * @return El número ingresado por el usuario dentro del rango especificado.
     */
    int PedirNumEnRango(String mensaje, int min, int max);

    /**
     * Verifica si el usuario actual es un administrador.
     *
     * @return true si el usuario es administrador, false en caso contrario.
     */
    boolean EsAdmin();
}
