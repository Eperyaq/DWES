package com.es.tema1.EjercicioIsAdmin.model;

import com.es.tema1.EjercicioIsAdmin.service.UserService;

import java.util.List;

public class RespuestaHTTP {
    private int codigoRespuesta;
    private String mensajeRespuesta;
    private User user;


    public RespuestaHTTP(int codigoRespuesta, String mensajeRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public RespuestaHTTP(int codigoRespuesta, String mensajeRespuesta, User user) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensajeRespuesta = mensajeRespuesta;
        this.user = user;
    }


    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    @Override
    public String toString() {
        return "RespuestaHTTP{" +
                "codigoRespuesta=" + codigoRespuesta +
                ", mensajeRespuesta='" + mensajeRespuesta + '\'' +
                ", user=" + user +
                '}';
    }
}
