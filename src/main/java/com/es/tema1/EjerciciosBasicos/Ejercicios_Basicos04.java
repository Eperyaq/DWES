package com.es.tema1.EjerciciosBasicos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
    public static void main(String[] args) {

        Ejercicio2();
    }
}

