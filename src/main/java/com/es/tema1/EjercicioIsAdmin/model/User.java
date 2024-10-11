package com.es.tema1.EjercicioIsAdmin.model;

public class User {

    private String Id;
    private String correo;
    private String encriptedPassword;
    private Boolean isAdmin;

    public User(String id, String correo, String encriptedPassword, Boolean isAdmin) {
        Id = id;
        this.correo = correo;
        this.encriptedPassword = encriptedPassword;
        this.isAdmin = isAdmin;
    }

    public User(String id, String correo, String encriptedPassword) { //Creado para que por defecto no sea admin
        Id = id;
        this.correo = correo;
        this.encriptedPassword = encriptedPassword;
        this.isAdmin = false;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEncriptedPassword() {
        return encriptedPassword;
    }

    public void setEncriptedPassword(String encriptedPassword) {
        this.encriptedPassword = encriptedPassword;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", correo='" + correo + '\'' +
                ", encriptedPassword='" + encriptedPassword + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
