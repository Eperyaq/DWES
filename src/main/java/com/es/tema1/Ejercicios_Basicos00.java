package com.es.tema1;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    }

    public String Ejercicio2(){
      String nombre = "Elia";
      return nombre;
    }

    public String Ejercicio3(){
      String nombre = "Elia";
      String direccion  = "Calle Ancha";
      Integer telefono = 111222345;

      String cadenaFinal = "Mi nombre es " + nombre + " mi dirección es " + direccion + " y mi numero de telefono es " + telefono + ".";
      return cadenaFinal;
    }

    public String Ejercicio4(){

        Double peseta = 166.386;
        Scanner lectura = new Scanner(System.in); //Sirve para crear un objeto de lectura
        String resultado = "";

        System.out.println("Introduzca un numero de euros entero para hacer la conversión: ");
        try {
            Integer euros = lectura.nextInt(); //Lee una entrada y espera un entero si no, da un InputMissmatchException
            Double cambio = euros * peseta;

             resultado = "Tu cambio es " + cambio;


        }catch (InputMismatchException e){
            System.out.println("Error, el dato indicado no es el correcto.");
        } finally {
            lectura.close();
        }
        return resultado;
    }

    public String Ejercicio5(){

        Double conversion = 166.386;
        Scanner lectura = new Scanner(System.in); //Sirve para crear un objeto de lectura
        String resultado = "";

        System.out.println("Introduzca un numero de pesetas entero para hacer la conversión: ");
        try {
            Double pesetas = lectura.nextDouble(); //Lee una entrada y espera un entero si no, da un InputMissmatchException

            Double cambio = pesetas / conversion;

            resultado = String.format("Tu cambio es %.2f euros", cambio);


        }catch (InputMismatchException e){
            System.out.println("Error, el dato indicado no es el correcto.");
        } finally {
            lectura.close();
        }
        return resultado;
    }

    public String Ejercicio6(){

        double iva = 0.21;
        Scanner lectura = new Scanner(System.in);

        System.out.println("Introduce el precio sin IVA: ");
        double base = lectura.nextDouble();

        double cantidadIva = base * iva;
        double total = base + cantidadIva;

        String resultado = String.format("El precio final es %.2f ", total);

        lectura.close();

        return resultado;

    }

    public static void main(String[] args) {

        Ejercicios_Basicos00 ejercicios = new Ejercicios_Basicos00();

        System.out.println(ejercicios.Ejercicio6());

    }
}
