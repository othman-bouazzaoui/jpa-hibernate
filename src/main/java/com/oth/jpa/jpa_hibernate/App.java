package com.oth.jpa.jpa_hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Jpa-DB");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee firstEmployee = new Employee(1L, "Othman", "BOUAZZAOUI","Developer", 220000d);

        Employee secondEmployee = new Employee(2L,"Mohamed", "Khaled","Analyst", 120000d);

        entityManager.persist(firstEmployee);
        entityManager.persist(secondEmployee);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}