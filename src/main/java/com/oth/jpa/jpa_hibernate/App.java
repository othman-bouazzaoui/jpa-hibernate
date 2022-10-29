package com.oth.jpa.jpa_hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Jpa-DB");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            EmployeeAddress address1 = new EmployeeAddress("0600000000", "12 Xx Rabat");
            EmployeeAddress address2 = new EmployeeAddress("0600000002", "12 Xx Rabat");
            EmployeeAddress address3 = new EmployeeAddress("0600000001", "12 Xx Rabat");

            Department dept1 = new Department("IT");
            Department dept2 = new Department("Finance");
            Department dept3 = new Department("RH");

            Project project1 = new Project("Project1");
            Project project2 = new Project("Project2");
            Project project3 = new Project("Project3");

            Employee firstEmployee = new Employee("Othman", "BOUAZZAOUI", "Developer", 220000d, address1);
            Employee secondEmployee = new Employee("Mohamed", "Khaled", "Analyst", 120000d, address2);
            Employee thirdEmployee = new Employee("Mohamed", "Khaled", "Analyst", 120000d, address3);

            firstEmployee.setDepartment(dept1);
            secondEmployee.setDepartment(dept1);
            thirdEmployee.setDepartment(dept3);

            firstEmployee.setProjects(project1);
            secondEmployee.setProjects(project1);
            thirdEmployee.setProjects(project2);

            entityManager.persist(dept1);
            entityManager.persist(dept2);
            entityManager.persist(dept3);

            entityManager.persist(address1);
            entityManager.persist(address2);
            entityManager.persist(address3);

            entityManager.persist(thirdEmployee);
            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);

            System.out.println(firstEmployee);
            System.out.println(secondEmployee);
            System.out.println(thirdEmployee);

        } catch (Exception ex) {
            System.err.println(" An exception => " + ex);

        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }

    }
}