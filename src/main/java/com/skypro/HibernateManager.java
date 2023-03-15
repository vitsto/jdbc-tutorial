package com.skypro;

import com.skypro.entity.City;
import com.skypro.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.function.Consumer;


public class HibernateManager {
    private SessionFactory sessionFactory;
    private static HibernateManager hibernateManager;

    private HibernateManager() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Employee.class).addAnnotatedClass(City.class);
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public void withEntityManager(Consumer<EntityManager> function) {
        try (Session session = this.sessionFactory.openSession()) {
            session.beginTransaction();
            function.accept(session);
            session.getTransaction().commit();
        }
    }

    public static HibernateManager getInstance() {
        if (hibernateManager == null) {
            hibernateManager = new HibernateManager();
        }
        return hibernateManager;
    }
}
