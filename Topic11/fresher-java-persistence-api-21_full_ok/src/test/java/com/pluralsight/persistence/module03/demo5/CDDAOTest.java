package demo5;

import com.pluralsight.persistence.module01.demo3.Book;
import com.pluralsight.persistence.module03.demo5.CDDAO;
import com.pluralsight.persistence.module05.model.CD;
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
class CDDAOTest {

    @Autowired
    private ApplicationContext context;

    private CDDAO cddao;

    @BeforeAll
    void initBookDAO(){
        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }

    @Test
    void persistCD() {
        cddao.persistCD(new CD());
    }


    @AfterEach
    void clearBookDAO(){
        this.cddao = null;
    }
}