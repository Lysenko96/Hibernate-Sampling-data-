package com.lessons.hibernate;

import com.lessons.hibernate.entity.Author;
import com.lessons.hibernate.entity.AuthorHelper;
import com.lessons.hibernate.entity.Book;
import com.lessons.hibernate.entity.BookHelper;
import org.hibernate.Session;

public class Start {
    public static void main(String[] args) {
      Session session = HibernateUtil.getSessionFactory().openSession();
        for (Author author:new AuthorHelper().getAuthorList()) { System.out.println("author = " + author.getName()); }
        //System.out.println("new AuthorHelper().getAuthorList() = " + new AuthorHelper().getAuthorList());
        for (Book book:new BookHelper().getBookList()) { System.out.println("book = " + book.getName()); }
    }
}
