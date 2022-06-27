package com.pluralsight.persistence.module01.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class Main {

  public static void main(String[] args) {

    ApplicationContext context = SpringApplication.run(Main.class, args);

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
     EntityManager em = emf.createEntityManager();



  }


//  /**
//   * Gets an entity manager
//   */
//  //private static EntityManagerFactory emf;
//  private static EntityManager em;
//
//  /**
//   * Persists the book to the database
//   */
//  private static void persistBook(com.pluralsight.persistence.module01.demo02.Book book) {
//    em.persist(book);
//  }
//
//  /**
//   * Finds the book from the database
//   */
//  private static com.pluralsight.persistence.module01.demo02.Book findBook(Long id) {
//    return em.find(Book.class, id);
//  }
}