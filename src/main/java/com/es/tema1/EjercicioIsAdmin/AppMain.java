package com.es.tema1.EjercicioIsAdmin;

import com.es.tema1.EjercicioIsAdmin.controller.UserController;
import com.es.tema1.EjercicioIsAdmin.io.Console;
import com.es.tema1.EjercicioIsAdmin.io.IOutputInterface;
import com.es.tema1.EjercicioIsAdmin.model.User;
import com.es.tema1.EjercicioIsAdmin.repository.UserRepository;
import com.es.tema1.EjercicioIsAdmin.service.UserService;

public class AppMain {

    public static void main(String[] args) {

        IOutputInterface consola = new Console();

        boolean admin = consola.EsAdmin();
        consola.Menu(admin);



    }
}
