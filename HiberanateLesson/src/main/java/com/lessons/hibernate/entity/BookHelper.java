package com.lessons.hibernate.entity;

import com.lessons.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookHelper {
    private SessionFactory sessionFactory;
    public BookHelper() { sessionFactory = HibernateUtil.getSessionFactory();}
    public List<Book> getBookList(){
        // открыть сессию для манипуляции с персист, объектами
        Session session = sessionFactory.openSession();
        session.get(Book.class,1L);// получение объекта по id
        System.out.println(session.get(Book.class,3L).getName());
        // этап подготовки запроса
        // объект-конструктор запросов для Criteria API
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);// первостепенный, корневой entity (в sql запросе - from)
        criteriaQuery.select(root); // необязательный оператор, если просто нужно получить все значения
        // этап выполнения запроса
        Query query = session.createQuery(criteriaQuery);
        List<Book> bookList = query.getResultList();
        session.close();
        return bookList;
    }
}
