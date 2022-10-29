package com.oth.jpa.jpa_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main( String[] args )
    {

        Configuration cfg = new Configuration();
        cfg = cfg.configure("META-INF/hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Employee firstEmployee = new Employee(1L, "Othman", "BOUAZZAOUI","Developer", 220000d);

        Employee secondEmployee = new Employee(2L,"Mohamed", "Khaled","Analyst", 120000d);

        Transaction transaction = session.beginTransaction();

        session.save(firstEmployee);
        session.save(secondEmployee);

        transaction.commit();

        session.close();
        factory.close();
    }
}