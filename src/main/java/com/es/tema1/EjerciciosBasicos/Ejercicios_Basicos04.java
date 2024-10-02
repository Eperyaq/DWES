package com.es.tema1.EjerciciosBasicos;

import javax.security.sasl.SaslClient;
import java.util.Random;
import java.util.Scanner;

public class Ejercicios_Basicos04 {

    public static void Ejercicio1(){
        Random random = new Random();

        int i = 0;
        int sumaTotal = 0;
        while (i<3) {
            int resultado = random.nextInt(6) + 1;
            System.out.println("El dado ha salido: " + resultado);
            i++;
            sumaTotal = sumaTotal + resultado;
        }
        System.out.println("resultado de la suma = " +sumaTotal);
    }

    public static void Ejercicio2(){
        String[] palos = {" Picas"," Corazones"," Diamantes"," Treboles"};
        String[] numeros =  {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        Random random = new Random();

        String paloSacado = palos[random.nextInt(palos.length)];
        String valor = numeros[random.nextInt(numeros.length)];

        System.out.println("Carta seleccionada " + valor  + paloSacado);
    }

    public static void Ejercicio3(){
        String[] palos = {" Espada"," Oro"," Basto"," Copas"};
        String[] numeros =  {"2","3","4","5","6","7","Sota","Caballo","Rey","As"};

        Random random = new Random();

        String paloSacado = palos[random.nextInt(palos.length)];
        String valor = numeros[random.nextInt(numeros.length)];

        System.out.println("Carta seleccionada " + valor  + paloSacado);
    }

    public static void Ejercicio13(){

        Random random = new Random();
        int dado1;
        int dado2;
        int veces = 0;
        do {
            dado1 = random.nextInt(6) + 1;
            dado2 = random.nextInt(6) + 1;
            veces++;
            System.out.println("Tirada " + veces + " dado 1 - " + dado1 + " dado 2 - " + dado2);
        }while (dado1 != dado2);
        System.out.println("Los dados tienen el mismo valor en el intento numero " + veces);
    }

    public static void Ejercicio14(){
        Scanner lectura = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Piensa en un numero 0-100");

        int num = lectura.nextInt();
        int oportunidades = 5;
        int min = 0;
        int max = 100;

        while (oportunidades > 0) {

            int pensado = random.nextInt((max - min) + 1) + min;
            System.out.println("El número que la máquina ha pensado es: " + pensado);

            System.out.println("El número es mayor, menor o acierto?");
            String respuesta = lectura.next().toLowerCase();

            if (respuesta.equals("acierto")) {
                System.out.println("ha adivinado tu número en " + (6 - oportunidades) + " intentos");
                break;
            } else if (respuesta.equals("mayor")) {
                min = pensado + 1;
            } else if (respuesta.equals("menor")) {
                max = pensado - 1;
            } else {
                System.out.println("Respuesta no válida. Responde con 'mayor', 'menor' o 'acierto'.");
                continue;
            }

            oportunidades--;
            if (oportunidades == 0) {
                System.out.println("La máquina se quedó sin intentos.");
            }
        }

        lectura.close();
    }
    public static void main(String[] args) {

        Ejercicio14();
    }
}

