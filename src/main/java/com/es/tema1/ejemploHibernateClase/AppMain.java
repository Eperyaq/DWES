package com.es.tema1.ejemploHibernateClase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AppMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadMySQL");
        EntityManager em = emf.createEntityManager();

        System.out.println("");
    }
}