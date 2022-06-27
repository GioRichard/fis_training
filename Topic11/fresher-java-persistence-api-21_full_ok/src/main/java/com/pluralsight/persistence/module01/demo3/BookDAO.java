package com.pluralsight.persistence.module01.demo3;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class BookDAO {
    EntityTransaction transaction;

    private EntityManager em;

    public BookDAO(EntityManager em){
        this.transaction =em.getTransaction();
        this.em = em;
    }

    public  void persistBook(com.pluralsight.persistence.module01.demo3.Book book){
        transaction.begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public com.pluralsight.persistence.module01.demo3.Book findBook(Long id){
        return  em.find(Book.class,id);
    }

    public List<Book> findAll() {
        Query query = em.createQuery("FROM Book");
        return query.getResultList();
    }

    public  void removeBook(Book book){
       Book bookDelete = em.merge(book);
       transaction.begin();
       em.remove(bookDelete);
       transaction.commit();
    }

    public Book raiseUnitCost(Long id, Float raise) {
        Book book = em.find(Book.class, id);

        if (book != null) {
            transaction.begin();

            book.setUnitCost(book.getUnitCost() + raise);
            transaction.commit();

        }
        return book;
    }
}
