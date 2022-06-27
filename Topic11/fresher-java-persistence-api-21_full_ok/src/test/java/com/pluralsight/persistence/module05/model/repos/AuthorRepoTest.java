package model.repos;

import com.pluralsight.persistence.module05.model.repos.AuthorRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepoTest {
    @Autowired
    private AuthorRepo authorRepo;

    @Test
    void getAll() {
        System.out.println(authorRepo.getAll());
    }
}