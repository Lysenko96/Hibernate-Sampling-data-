package com.lessons.hibernate.entity;

import com.lessons.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorHelper {
    private SessionFactory sessionFactory;
    public AuthorHelper() { sessionFactory = HibernateUtil.getSessionFactory();}
    public List<Author> getAuthorList(){
        // открыть сессию для манипуляции с персист, объектами
        Session session = sessionFactory.openSession();
        session.get(Author.class,1L);// получение объекта по id
        // этап подготовки запроса
        // объект-конструктор запросов для Criteria API
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)
        criteriaQuery.select(root); // необязательный оператор, если просто нужно получить все значения
        // этап выполнения запроса
        Query query = session.createQuery(criteriaQuery);
        List<Author> authorList = query.getResultList();
        session.close();
        return authorList;
    }
    public Author  getAuthor(String string) { return null;}
}