package com.es.tema1.ejemploHibernateClase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AppMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadMySQL");
        EntityManager em = emf.createEntityManager();

        Direccion dir = new Direccion("Senda perdida",8,"11111", null);
        Director director = new Director("12345A",25,"Elia",null);

        Cine cine = new Cine("Yelmo",100,dir, director);
        //1º empezar una transaccion
        em.getTransaction().begin();

        //2º se realizan las operaciones que queramos, hagamos un insert
        em.persist(dir);
        em.persist(cine);

        //3º para que se reflejen los datos en la BDD hay que hacer un commit
        em.getTransaction().commit();

        //4º cerramos la transaccion
        //em.close();  quitada porque si no no nos deja seguir



        //HAcer una consulta
        //1º abrir transaccion

        em.getTransaction().begin();

        //2º Realizar la consulta
        Cine cineBusqueda = em.find(Cine.class,1 ); //indicamos lo que queremos buscar y una primary key

        System.out.println(cineBusqueda.getNombre());

        System.out.println(cineBusqueda.getDireccion().getCalle());

        //em.close();
        //----------------------------------------------------------------------//

        em.persist(director);
        //Creo un director y lo meto en la bdd
        //Despues hago commit y lo busco para comprobar que se haya añadido bien

        Director direcotrbuscado = em.find(Director.class, "12345A");
        System.out.println("El director " + direcotrbuscado.getNombre() + " Tiene " +  direcotrbuscado.getEdad() + " años.");
    }
}