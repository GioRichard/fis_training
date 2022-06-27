package com.pluralsight.persistence.module03.demo5;

import com.pluralsight.persistence.module03.model.Musician;
import com.pluralsight.persistence.module05.model.CD;

import javax.persistence.EntityManager;

public class MuscianDAO {
    private EntityManager em;
    public MuscianDAO(EntityManager em){
        this.em = em;
    }

    public void persistCD(Musician musician){
        em.getTransaction().begin();
        em.persist(musician);
        em.getTransaction().commit();
    }

    public  Musician findCD(Long id) {
        return em.find(Musician.class,id);
    }
}
