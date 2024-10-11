package com.es.tema1.EjercicioIsAdmin.io;

public interface IOutputInterface {

    void Escribir(String mensaje);
    void Escribir(String mensaje,boolean saltoLinea);

    String PreguntarString(String mensaje);

    int PedirNum(String mensaje);

    void Menu(boolean admin);
    String ValidarEmail(String email);
    int PedirNumEnRango(String mensaje, int min, int max);
     boolean EsAdmin();
}
