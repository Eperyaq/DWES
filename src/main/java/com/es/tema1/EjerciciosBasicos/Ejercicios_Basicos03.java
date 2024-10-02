package com.es.tema1.EjerciciosBasicos;

import java.util.Scanner;

public class Ejercicios_Basicos03 {
    public static void Ejercicio1(){

        for (int i = 0; i <= 100 ;  i++) {
            if (i % 5 == 0){
                System.out.println(i);
            }
        }
    }

    public static void Ejercicio2(){
        int limite = 100;
        int i = 0;
        while (i <= limite){
            if (i % 5 == 0){
                System.out.println(i);
            }
            i++;
        }
    }

    public static void Ejercicio3(){
        int limite = 100;
        int i = 0;
        do {
            if (i % 5 == 0){
                System.out.println(i);
            }
            i++;
        }while (i <= limite);
    }

    public void Ejercicio20() {

        Scanner lectura = new Scanner(System.in);

        try {
            System.out.println("Introduzca la altura: ");
            int altura = lectura.nextInt();

            System.out.println("Introduzca el caracter de la pirámide: ");
            String caracter = lectura.next();


            for (int i = 1; i <= altura; i++) {

                for (int j = 1; j <= (altura - i); j++) {
                    System.out.print(" ");
                }

                System.out.print(caracter);

                if (i > 1 && i < altura) {

                    for (int j = 1; j <= (2 * i - 3); j++) {
                        System.out.print(" ");
                    }

                    System.out.print(caracter);
                }

                if (i == altura) {
                    for (int j = 1; j <= (2 * i - 2); j++) {
                        System.out.print(caracter);
                    }
                }

                System.out.println();
            }
        }catch (Exception e){
            System.out.println("Error, algo ha ido mal");
        }
    }

    public static void Ejercicio21(){

        Scanner lectura = new Scanner(System.in);

        int countNumeros = 0;
        int sumaImpares = 0;
        int countImpares = 0;
        int mayorPar = Integer.MIN_VALUE;
        int numero;

        do {
            System.out.print("Introduce un número (negativo para terminar): ");
            numero = lectura.nextInt();


            if (numero < 0) {
                break;
            }

            countNumeros++;


            if (numero % 2 == 0) {
                if (numero > mayorPar) {
                    mayorPar = numero;
                }
            } else {
                sumaImpares += numero;
                countImpares++;
            }

        } while (numero >= 0);


        System.out.println("Has introducido " + countNumeros + " números.");

        if (countImpares > 0) {
            double mediaImpares = (double) sumaImpares / countImpares;
            System.out.println("La media de los impares es: " + mediaImpares);
        } else {
            System.out.println("No se introdujeron números impares.");
        }

        if (mayorPar != Integer.MIN_VALUE) {
            System.out.println("El mayor de los números pares es: " + mayorPar);
        } else {
            System.out.println("No se introdujeron números pares.");
        }

        lectura.close();
    }


    public static void main(String[] args) {
        Ejercicios_Basicos03 ejercicios03 = new Ejercicios_Basicos03();
        ejercicios03.Ejercicio21();
    }
}
