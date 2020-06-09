package com.lessons.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory; // настройка и рабоа с сессиями (фабрика сессий)

    static {
        // настройка из hibernate.cfg.xml
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            // MetadataSources - для работы с методами маппинга объектов
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // The registry would be destroyed by  the SessionFactory, but e had trouble building the SessionFactory
            // so destroy it manually
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
