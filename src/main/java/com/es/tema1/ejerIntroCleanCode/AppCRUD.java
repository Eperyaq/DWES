package com.es.tema1.ejerIntroCleanCode;

import com.es.tema1.ejerIntroCleanCode.clases.ResponseEntity;
import com.es.tema1.ejerIntroCleanCode.clases.User;
import com.es.tema1.ejerIntroCleanCode.controller.UserController;
import com.es.tema1.ejerIntroCleanCode.repository.UserRepository;
import com.es.tema1.ejerIntroCleanCode.services.UserService;

import java.util.ArrayList;

public class AppCRUD {


    public static void main(String[] args) {


        ArrayList<User> bddUsers = new ArrayList<>();
        bddUsers.add(new User("Diego", "1234"));
        bddUsers.add(new User("Juan", "1234"));
        bddUsers.add(new User("Paco", "1234"));

        UserController userController = new UserController();



        ResponseEntity r1 = userController.getUser("Diego");
        ResponseEntity r2 = userController.getUser("ydgey");
        ResponseEntity r3 = userController.getUser("");


//        ResponseEntity r4 = userController.insertUser("Maria", "456");
//        ResponseEntity r5 = userController.insertUser("Maria", "12334");
//        ResponseEntity r6 = userController.insertUser("", "");
//
//        ResponseEntity r7 = userController.deleteUser("Maria");
//        ResponseEntity r8 = userController.deleteUser("Maria");
//        ResponseEntity r9 = userController.deleteUser("");
//
//        ResponseEntity r10 =userController.modifyUser("Diego", new User("", "09876"));
//        ResponseEntity r11 =userController.modifyUser("Diego", new User("Diego", ""));
//        ResponseEntity r12 =userController.modifyUser("Diego", new User("deijedij", ""));
//

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
//        System.out.println(r4);
//        System.out.println(r5);
//        System.out.println(r6);
//        System.out.println(r7);
//        System.out.println(r8);
//        System.out.println(r9);
//        System.out.println(r10);
//        System.out.println(r11);
//        System.out.println(r12);

        if (r1.getCodigoRespuesta().containsKey(200)){
            System.out.println("Usuario encontrado");
            System.out.println(r1.getBody());
        }
    }
}
