package com.es.tema1.EjercicioEmail.service;

import com.es.tema1.EjercicioEmail.model.UserEmail;
import com.es.tema1.EjercicioEmail.repository.UserEmailRepository;
import com.es.tema1.EjercicioEmail.repository.UserEmailRepositoryAPI;
import com.es.tema1.ejerIntroCleanCode.services.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserEmailService {

    //Crear variable UserEmailRepository
    private UserEmailRepository repository;

    public UserEmailService(){
        this.repository = new UserEmailRepository();
    }

    public UserEmail getUserEmail(String email){

        if (email == null || email.isEmpty()) return null;
        if (validarEmail(email) == null){
            return null;
        }

        return repository.getUserEmail(email);
    }

    public UserEmail insertUserEmail(String nombre, String email){
        try {
            if (validarNombre(nombre) == null && validarEmail(email) == null){
                return null;
            } else {
                UserEmail usuario = new UserEmail(nombre, email);
                return repository.insertUserEmail(usuario);
            }
        }catch (Exception e){
            return null;
        }
    }

    public boolean deleterUserEmail(String email){
        if (validarEmail(email)== null){
            return false;
        }else {
            return true;
        }
    }

    public String validarNombre(String nombre){

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9].*");
        Matcher matcher = pattern.matcher(nombre);

        if (nombre == null || nombre.isEmpty()) {
            return null;
        }

        //Si el primer caracter del nombre es un simbolo retorna null
        if (!matcher.matches()){
            return null;
        }

        if (nombre.length() >15){
            return null;
        }
        //Si pasa todas las comprobaciones retorna el nombre, si no, nulo
        return nombre;
    }

    public String validarEmail(String email) {
        if(email.contains("@") && email.endsWith(".com") || email.endsWith(".es")){
            return email;
        } else {
            return null;
        }
    }


}
