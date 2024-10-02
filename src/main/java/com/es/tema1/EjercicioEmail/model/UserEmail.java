package com.es.tema1.EjercicioEmail.model;

import java.util.Objects;

public class UserEmail {
    private String nombre;
    private String email;

    public UserEmail(String nombre, String email){
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode(): 0;
    }

    @Override
    public String toString() {
        return "UserEmail{" +
                "nombre ='" + nombre + '\'' +
                ", email ='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEmail userEmail = (UserEmail) o;
        return Objects.equals(nombre, userEmail.nombre) && Objects.equals(email, userEmail.email);
    }
}
