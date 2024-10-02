package com.es.tema1.EjercicioEmail.repository;

import com.es.tema1.EjercicioEmail.model.UserEmail;

public interface UserEmailRepositoryAPI {

    UserEmail getUserEmail(String email);

    UserEmail insertUserEmail(UserEmail u);

    Boolean deleteUserEmail(String email);
}
