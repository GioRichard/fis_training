package com.pluralsight.persistence.module05.model.repos;


import com.pluralsight.persistence.module05.model.CD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository

public class CdRepo implements ICdRepos{
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Autowired
    public CdRepo(EntityManagerFactory entityManagerFactory){
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<CD> getAll() {
        TypedQuery<CD> query = entityManager.createNamedQuery(CD.FIND_ALL,CD.class);
        return query.getResultList();
    }
}
