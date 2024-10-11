package com.es.tema1.EjercicioIsAdmin;

import com.es.tema1.EjercicioIsAdmin.io.Console;
import com.es.tema1.EjercicioIsAdmin.io.IOutputInterface;

/**
 * Clase principal de la aplicación que inicia el programa.
 * Esta clase se encarga de crear la interfaz de consola,
 * determinar si el usuario es administrador y mostrar el menú correspondiente.
 */
public class AppMain {

    /**
     * Método principal que se ejecuta al iniciar la aplicación.
     *
     * @param args Argumentos de línea de comandos, no utilizados en esta aplicación.
     */
    public static void main(String[] args) {
        IOutputInterface consola = new Console(); // Crea una instancia de la interfaz de salida

        boolean admin = consola.EsAdmin(); // Pregunta si el usuario es administrador
        consola.Menu(admin); // Muestra el menú según el rol del usuario
    }
}
