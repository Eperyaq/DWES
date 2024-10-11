package com.es.tema1.EjercicioIsAdmin.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class EncryptedUtils {

    public static String encriptador(String password){
        try {
            if (!password.isEmpty()) {
                MessageDigest digest = MessageDigest.getInstance("SHA3-256");

                byte[] hashByte = digest.digest(password.getBytes(StandardCharsets.UTF_8));

                StringBuilder hexString = new StringBuilder(); //Valor con la contraseña encriptada y junta

                for (byte b : hashByte) {
                    String hex = String.format("%02x", b);
                    hexString.append(hex);
                }
                return hexString.toString();
            }
            return "";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

}
