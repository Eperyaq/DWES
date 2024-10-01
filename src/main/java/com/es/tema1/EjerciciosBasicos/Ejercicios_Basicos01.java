package com.es.tema1.EjerciciosBasicos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicios_Basicos01 {

    public String Ejercicio1(){
        Scanner lectura = new Scanner(System.in);
        int resultado = 0;
        try {
            System.out.println("Introduzca un numero: ");
            Integer num1 = lectura.nextInt();
            System.out.println("Introduzca otro numero: ");
            Integer num2 = lectura.nextInt();

            resultado = num1 * num2;
        }catch (InputMismatchException e){
            System.out.println("Error, el valor introducido no es correcto.");
        }finally {
            lectura.close();
        }

        return "El resultado es " + resultado;
    }

    public String Ejercicio2(){

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

    public String Ejercicio3(){

        double peseta = 166.386;
        Scanner lectura = new Scanner(System.in); //Sirve para crear un objeto de lectura
        String resultado = "";

        System.out.println("Introduzca un numero de euros entero para hacer la conversión: ");
        try {
            int euros = lectura.nextInt(); //Lee una entrada y espera un entero si no, da un InputMissmatchException
            double cambio = euros * peseta;

            resultado = "Tu cambio es " + cambio;


        }catch (InputMismatchException e){
            System.out.println("Error, el dato indicado no es el correcto.");
        } finally {
            lectura.close();
        }
        return resultado;
    }

    public Double ejercicio11(){

        Scanner lectura = new Scanner(System.in);

        System.out.println("Introduce el numero de MB");
        double mb = lectura.nextDouble();

        return mb * 1024;
    }

    public Double Ejercicio12(){
        Scanner lectura = new Scanner(System.in);
        double resultado = 0;

        try {
            System.out.println("Introduzca la base imponible: ");
            double base = lectura.nextDouble();
            lectura.nextLine(); //para consumir el salto de linea

            System.out.println("Introduzca el tipo de IVA (general, reducido o superreducido): ");
            String tipoIva = lectura.nextLine();

            double iva = 0;
            if (!tipoIva.equals("general") && !tipoIva.equals("reducido") && !tipoIva.equals("superreducido")){
                System.out.println("Erroor");
            } else {
                switch (tipoIva){
                    case "general":
                        iva = 0.21;
                    break;
                    case "reducido":
                        iva = 0.10;
                    break;
                    case "superreducido":
                        iva = 0.04;
                    break;
                }
                System.out.println("Introduzca el código promocional (nopro, mitad, meno5, 5porc): ");
                String codigoPro = lectura.nextLine();
                if (!codigoPro.equals("nopro") && !codigoPro.equals("mitad") && !codigoPro.equals("meno5") && !codigoPro.equals("5porc")){
                    System.out.println("Error, prueba de nuevo");
                }else {
                    switch (codigoPro) {
                        case "nopro":
                            System.out.println("No se ha aplicado codigo.");
                            resultado = (base * iva);
                        break;
                        case "mitad":
                            resultado = (base + (base * iva)) / 2;
                            System.out.println("Se ha hecho un descuento de la mitad del precio. ");
                        break;
                        case "meno5":
                            resultado = base + (base * iva) -5;
                            System.out.println("Se ha hecho un descuento y se han quitado 5 euros del precio.");
                        break;
                        case "5porc":
                            resultado = (base + (base * iva)) * 0.05;
                            System.out.println("Se ha aplicado un descuento del 5% ");
                        break;

                    }
                }
            }
        } catch (Exception e){
            System.out.println("Error, algo ha ido mal...");
        }finally {
            lectura.close();
        }
        return resultado;
    }

    public static void Ejercicio13(){
        Scanner lectura = new Scanner(System.in);

        System.out.println("Introduce la primera nota del primer examen: ");
        double notaPrimer = lectura.nextDouble();

        System.out.println("Que nota quieres sacar en el trimestre?: ");
        double nota = lectura.nextDouble();

        double notaExamen = (nota - (notaPrimer * 0.4))/ 0.6;

        System.out.printf("Para tener un %.1f en el trimestre necesitas sacar un %.2f en el segundo examen.", nota, notaExamen );

        lectura.close();
    }

    public static void main(String[] args) {
        Ejercicios_Basicos01 ejercicios01= new Ejercicios_Basicos01();

        ejercicios01.Ejercicio13();
    }
}
