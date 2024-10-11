package com.es.tema1.EjercicioIsAdmin.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Clase utilitaria para el manejo de funciones de encriptación.
 * En particular, esta clase proporciona métodos para encriptar contraseñas
 * utilizando el algoritmo SHA-3 de 256 bits.
 */
public class EncryptedUtils {

    /**
     * Encripta una contraseña utilizando el algoritmo SHA-3 de 256 bits.
     *
     * @param password La contraseña en texto plano que se desea encriptar.
     * @return La representación en formato hexadecimal de la contraseña encriptada.
     *         Si la contraseña está vacía, se retorna una cadena vacía.
     */
    public static String encriptador(String password) {
        try {
            if (!password.isEmpty()) {
                MessageDigest digest = MessageDigest.getInstance("SHA3-256");

                byte[] hashByte = digest.digest(password.getBytes(StandardCharsets.UTF_8));

                StringBuilder hexString = new StringBuilder(); // Valor con la contraseña encriptada y junta

                for (byte b : hashByte) {
                    String hex = String.format("%02x", b);
                    hexString.append(hex);
                }
                return hexString.toString();
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
