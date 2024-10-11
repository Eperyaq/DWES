package com.es.tema1.EjercicioIsAdmin.model;

import com.es.tema1.EjercicioIsAdmin.service.UserService;
import java.util.List;

/**
 * Clase que representa la respuesta de una operación HTTP relacionada con el usuario.
 * Incluye el código de respuesta, un mensaje descriptivo y un objeto User si es necesario.
 */
public class RespuestaHTTP {
    private int codigoRespuesta;
    private String mensajeRespuesta;
    private User user;

    /**
     * Constructor para crear una respuesta HTTP sin un objeto User.
     * @param codigoRespuesta El código de respuesta HTTP.
     * @param mensajeRespuesta El mensaje descriptivo de la respuesta.
     */
    public RespuestaHTTP(int codigoRespuesta, String mensajeRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensajeRespuesta = mensajeRespuesta;
    }

    /**
     * Constructor para crear una respuesta HTTP con un objeto User.
     * @param codigoRespuesta El código de respuesta HTTP.
     * @param mensajeRespuesta El mensaje descriptivo de la respuesta.
     * @param user El objeto User relacionado con la respuesta.
     */
    public RespuestaHTTP(int codigoRespuesta, String mensajeRespuesta, User user) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensajeRespuesta = mensajeRespuesta;
        this.user = user;
    }

    /**
     * Obtiene el código de respuesta.
     * @return El código de respuesta HTTP.
     */
    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    /**
     * Establece el código de respuesta.
     * @param codigoRespuesta El nuevo código de respuesta HTTP.
     */
    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    /**
     * Obtiene el mensaje de respuesta.
     * @return El mensaje descriptivo de la respuesta.
     */
    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    /**
     * Establece el mensaje de respuesta.
     * @param mensajeRespuesta El nuevo mensaje descriptivo de la respuesta.
     */
    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    /**
     * Obtiene el objeto User relacionado con la respuesta.
     * @return El objeto User si está presente, de lo contrario null.
     */
    public User getUser() {
        return user;
    }

    /**
     * Establece el objeto User relacionado con la respuesta.
     * @param user El nuevo objeto User para la respuesta.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Devuelve una representación en forma de cadena de la respuesta HTTP.
     * @return Una cadena que representa el objeto RespuestaHTTP.
     */
    @Override
    public String toString() {
        return "RespuestaHTTP{" +
                "codigoRespuesta=" + codigoRespuesta +
                ", mensajeRespuesta='" + mensajeRespuesta + '\'' +
                ", user=" + user +
                '}';
    }
}
