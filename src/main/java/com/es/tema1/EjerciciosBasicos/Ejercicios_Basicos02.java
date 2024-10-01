package com.es.tema1.EjerciciosBasicos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicios_Basicos02 {

    public static void Ejercicio1(){
        Scanner lectura = new Scanner(System.in);

        System.out.println("Escoge un dia de la semana: ");
        String dia = lectura.nextLine().toLowerCase();

        switch (dia){
            case "lunes":
                System.out.println("El lunes hay Hora de libre configuración.");
            break;
            case "martes":
                System.out.println("El martes hay Hora de entorno servidor .");
            break;
            case "miercoles":
                System.out.println("El miércoles hay Hora de entorno servidor.");
            break;
            case "jueves":
                System.out.println("El jueves hay Hora de diseño de interfaz.");
            break;
            case "viernes":
                System.out.println("El viernes hay Hora de diseño de interfaz.");
            break;
            default:
                System.out.println("Ese dia no hay clases");
        }
        lectura.close();
    }

    public static void Ejercicio2(){
        Scanner lectura = new Scanner(System.in);

        System.out.println("Introduzca una hora, solo la hora: ");
        try {
            int hora = lectura.nextInt();
            switch (hora){
               case  6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                    System.out.println("Buenos dias!");
                break;
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                    System.out.println("Buenas tardes!");
                break;
                case 21:
                case 22:
                case 23:
                case 24:
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("Buenas noches!");
                break;
                default:
                    System.out.println("Esa hora está mal.");
                break;
            }
        }catch (InputMismatchException e){
            System.out.println("Error, algo ha ido mal.");
        }
    }

    public static void Ejercicio3(){
        boolean todoBien = true;
        Scanner lectura = new Scanner(System.in);
        try {
            while (todoBien) {
              System.out.println("Escribe un numero del 1-7: ");

                  int num = lectura.nextInt();

                  if (num >= 1 && num <= 7) {
                      todoBien = false;
                      switch (num) {
                          case 1:
                              System.out.println("Lunes");
                              break;
                          case 2:
                              System.out.println("Martes");
                              break;
                          case 3:
                              System.out.println("Miércoles");
                              break;
                          case 4:
                              System.out.println("Jueves");
                              break;
                          case 5:
                              System.out.println("Viernes");
                              break;
                          case 6:
                              System.out.println("Sábado");
                              break;
                          case 7:
                              System.out.println("Domingo");
                              break;

                      }
                  } else {
                      System.out.println("Error, prueba de nuevo");
                  }
              }
        }catch (InputMismatchException e){
            System.out.println("Error, algo ha ido mal.");
        }
    }

    public static void Ejercicio20(){
        Scanner lectura = new Scanner(System.in);

        System.out.println("Introduce un numero entero positivo de hasta 5 cifras: ");
        int numero = lectura.nextInt();

        if (numero <0 || numero > 99999){
            System.out.println("El numero debe ser positivo y tener 5 cifras");
        } else {
            int numeroOriginal = numero;
            int numeroInvertido = 0;

            while (numero != 0) {
                int digito = numero % 10;
                numeroInvertido = numeroInvertido * 10 + digito;
                numero /= 10;
            }

            if (numeroOriginal == numeroInvertido) {
                System.out.println("El número " + numeroOriginal + " es capicúa.");
            } else {
                System.out.println("El número " + numeroOriginal + " no es capicúa.");
            }
        }
        lectura.close();
    }

    public static void Ejercicio21(){
        Scanner lectura = new Scanner(System.in);

        System.out.println("Introduce la nota del primer examen: ");
        try {
            int nota1 = lectura.nextInt();

            System.out.println("Introduce la nota del segundo examen: ");
            int nota2 = lectura.nextInt();

            float media = (nota1 + nota2) / 2; //porque no me salen decimales? si pongo 7 y 10 me sale 8.0 en vez de 8.5

            if (media >= 5) {
                System.out.println("Tu nota media es: " + media);
            } else {
                System.out.println("Cual ha sido el resultado de la recuperacion? (Apto, noApto)");
                String recu = lectura.next().toLowerCase();
                if (recu.equals("apto")) {
                    System.out.println("Tu nota en programacion = 5 ");
                } else {
                    System.out.println("Tu nota = " + media);
                }
            }
        }catch (Exception e){
            System.out.println("Algo ha ido mal...");
        }finally {
            lectura.close();
        }
    }


    public static void Ejercicio22(){
        Scanner lectura = new Scanner(System.in);

        final int MINUTOS_POR_DIA = 24 * 60;

        final int MINUTOS_FIN_SEMANA = (4 * MINUTOS_POR_DIA) + (15 * 60);


        System.out.print("Introduce el día de la semana (lunes = 1, martes = 2...): ");
        int dia = lectura.nextInt();


        System.out.print("Introduce la hora (0-23): ");
        int hora = lectura.nextInt();
        System.out.print("Introduce los minutos (0-59): ");
        int minutos = lectura.nextInt();

        int minutosPasados = ((dia - 1) * MINUTOS_POR_DIA) + (hora * 60) + minutos;

        int minutosRestantes = MINUTOS_FIN_SEMANA - minutosPasados;

        System.out.println("Faltan " + minutosRestantes + " minutos para el fin de semana.");

        lectura.close();
    }

    public static void main(String[] args) {
        Ejercicios_Basicos02 ejercicios2 = new Ejercicios_Basicos02();

        ejercicios2.Ejercicio22();

    }
}
