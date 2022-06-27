package com.pluralsight.persistence.module01.demo3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookDAOTest {
    @Autowired
    private ApplicationContext context;
    private  BookDAO bookDAO;

    @BeforeAll
    void initBookDAO(){
       EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
       EntityManager entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    void persistBook() {
        bookDAO.persistBook(new Book(11L,"title1", "best",
                12.2f,"544533",453););
    }

    @Test
    void findBook() {
        Book book = bookDAO.findBook(12L);
        System.out.println("b"+book);
    }

    @Test
    void findAll() {
        System.out.println(bookDAO.findAll());
    }

    @Test
    void removeBook() {
        Book book =new Book(11L,"title1", "best",
                12.2f,"544533",453);

        bookDAO.removeBook(book);
    }

    @Test
    void raiseUnitCost(){
        bookDAO.raiseUnitCost(11L,2.5f);
    }

    @AfterEach
    void clearBookDAO(){
        this.bookDAO = null;
    }
}