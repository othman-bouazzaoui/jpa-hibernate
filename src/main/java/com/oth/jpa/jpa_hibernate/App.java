package com.oth.jpa.jpa_hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class App {

    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Jpa-DB");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Employee firstEmployee = new Employee(1, LocalDate.now(), "Othman", "BOUAZZAOUI", "Developer", 220000d);
            Employee secondEmployee = new Employee(1, LocalDate.now().plusDays(1), "Mohamed", "Khaled", "Analyst", 120000d);
            Employee thirdEmployee = new Employee(2, LocalDate.now(), "Mohamed", "Khaled", "Analyst", 120000d);

            entityManager.persist(thirdEmployee);
            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);

        }catch (Exception ex){
            System.err.println(" An exception => " + ex);

        }finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }

    }
}