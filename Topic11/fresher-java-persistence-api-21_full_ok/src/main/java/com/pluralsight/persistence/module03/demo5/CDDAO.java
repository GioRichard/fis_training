package com.pluralsight.persistence.module03.demo5;

import com.pluralsight.persistence.module01.demo3.Book;
import com.pluralsight.persistence.module05.model.CD;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CDDAO {
    private EntityManager em;
    public  CDDAO (EntityManager em){
        this.em = em;
    }

    public void persistCD(CD cd){
        em.getTransaction().begin();
        em.persist(cd);
        em.getTransaction().commit();
    }

    public  CD findCD(Long id) {
        return em.find(CD.class,id);
    }
}
