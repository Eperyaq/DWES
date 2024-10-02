package com.es.tema1.EjercicioEmail.repository;

import com.es.tema1.EjercicioEmail.model.UserEmail;

import java.util.ArrayList;

public class UserEmailRepository implements UserEmailRepositoryAPI {

    //base de datos de mentira
    ArrayList<UserEmail> bddUserEmail;

    public UserEmailRepository(){
        this.bddUserEmail = new ArrayList<>();

        bddUserEmail.add(new UserEmail("Elia","elia@elia.es"));
        bddUserEmail.add(new UserEmail("pedro","pedro@elia.es"));
        bddUserEmail.add(new UserEmail("Maria","maria@elia.es"));
        bddUserEmail.add(new UserEmail("Juan","juan@elia.es"));
        bddUserEmail.add(new UserEmail("Jorge","jorge@elia.es"));
    }

    @Override
    public UserEmail getUserEmail(String email) {
        //return bddUserEmail.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);

        UserEmail userReturn = null;
        for ( UserEmail u : bddUserEmail){
            if (u.getEmail().equals(email)){
                userReturn = u;
                break;
            }
        }
        return userReturn;
    }

    @Override
    public UserEmail insertUserEmail(UserEmail u) {
        bddUserEmail.add(u);
        return getUserEmail(u.getEmail());
    }

    @Override
    public Boolean deleteUserEmail(String email) {
        //return bddUserEmail.removeIf(u -> u.getEmail().equals(email));
        return bddUserEmail.remove(getUserEmail(email));
    }
}
