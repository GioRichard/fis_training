package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.repository.CriminalCaseRepository;
import fis.bank.criminalsystemmanagement.service.CriminalCaseService;
import fis.bank.model.CriminalCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CriminalCaseServiceImplTest {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    @Autowired
    private CriminalCaseService criminalCaseService;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void createCriminalCase() {
        CriminalCase criminalCase = new CriminalCase(6L,1,null,null,"1234",
                "dai", "ngan",null,"note1",null,null);

        criminalCaseService.CreateCriminalCase(criminalCase);
    }

    @Test
    void updateCriminalCase() {
    }

    @Test
    void deleteCriminalCaseById() {
        criminalCaseService.deleteCriminalCaseById(1L);
    }

    @Test
    void fillAll() {
        criminalCaseService.fillAll();
    }

    @Test
    void findById() {
        criminalCaseService.findById(2L);
    }
}