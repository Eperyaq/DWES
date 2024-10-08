package com.es.tema1.EjercicioEmail.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

    /**
    * Método que recide la password sin encriptar, la encripta y la retorna encriptada usando hash
    * @param password Contraseña sin encriptar
     * @return password encriptada.
    */
    public static String encryptPassword(String password){
        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            //Este es el metodo que lo hashea y lo mete en un array de bytes
            byte [] hashByte = digest.digest(password.getBytes(StandardCharsets.UTF_8));


            //convertir cada posicion del array en string

            StringBuilder passwordHased = new StringBuilder();
            for (byte b: hashByte){
                String hex = String.format("%02x", b);
                // lo pasa a hexadecimal %02x x= hexadecimal 2 = 2 digitos 0 = que si lleva 1 digito que rellene con ceros
                passwordHased.append(hex);
            }

            return password.toString();
        }catch (NoSuchAlgorithmException e ){
            e.printStackTrace();
        }
        return "";
    }



}
