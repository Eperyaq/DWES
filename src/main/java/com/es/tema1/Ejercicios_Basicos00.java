package com.es.tema1;

public class Ejercicios_Basicos00 {


    public String Ejercicio1(){
        int x = 144;
        int y = 999;

        int suma = x+y;
        int resta = x-y;
        int multiplicacion = x*y;
        int division = x/y;

        System.out.println(x);
        System.out.println(y);

        return("suma = " + suma + " resta = " + resta + " multiplicacion = " + multiplicacion + " division = " + division);

    };

    public String Ejercicio2(){
      String nombre = "Elia";
      return nombre;
    };

    public static void main(String[] args) {

        Ejercicios_Basicos00 ejercicios = new Ejercicios_Basicos00();

        System.out.println(ejercicios.Ejercicio2());

    }
}
