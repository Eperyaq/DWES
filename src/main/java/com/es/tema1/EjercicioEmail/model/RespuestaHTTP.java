package com.es.tema1.EjercicioEmail.model;

public class RespuestaHTTP {

    private int codigoRespuesta;
    private String mensajeRespuesta;
    private UserEmail userEmail;

    //constructor1

    public RespuestaHTTP(String mensajeRespuesta, int codigoRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
        this.codigoRespuesta = codigoRespuesta;
    }

    //constructor 2

    public RespuestaHTTP(UserEmail u, String mensajeRespuesta, int codigoRespuesta) {
        this.userEmail = u;
        this.mensajeRespuesta = mensajeRespuesta;
        this.codigoRespuesta = codigoRespuesta;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public UserEmail getUserEmail() {
        return userEmail;
    }

    @Override
    public String toString() {
        return "RespuestaHTTP{" +
                "codigoRespuesta=" + codigoRespuesta +
                ", mensajeRespuesta='" + mensajeRespuesta + '\'' +
                ", userEmail=" + userEmail +
                '}';
    }
}
