package fis.bank.criminalsystemmanagement.repository.impl;

import fis.bank.criminalsystemmanagement.model.CriminalCase;
import fis.bank.criminalsystemmanagement.model.Evidence;
import fis.bank.criminalsystemmanagement.model.Storage;
import fis.bank.criminalsystemmanagement.model.enums.CaseStatus;
import fis.bank.criminalsystemmanagement.model.enums.CaseType;
import fis.bank.criminalsystemmanagement.repository.CriminalCaseRepository;
import fis.bank.criminalsystemmanagement.repository.StorageRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EvidenceRepositoryImplTest {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    @Qualifier("ExtraEvidenceRepositoryImpl")
    private EvidenceRepositoryImpl evidenceRepository;

    @Test
    @Order(1)
    void create() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCaseStatus(CaseStatus.CLOSED);
        criminalCase.setCaseType(CaseType.FELONY);
        criminalCase.setShortDescription("short6");
        criminalCase.setDetailedDescription("detail6");
        criminalCaseRepository.save(criminalCase);

        Storage storage = new Storage();
        storage.setLocation("Location6");
        storage.setName("name6");
        storageRepository.save(storage);

        Evidence evidence = new Evidence();;
        evidence.setStorage(storage);
        evidence.setCriminalCase(criminalCase);
        evidence.setArchived(true);
        evidence.setVersion(1);
        evidence.setItemName("item6");
        evidence.setNotes("note6");
        evidence.setNumber("B6");
        evidenceRepository.create(evidence);
    }

    @Test
    @Order(2)
    void getALl() {
        evidenceRepository.getALl().forEach(System.out::println);
    }

    @Test
    @Order(3)
    void findById() {
        System.out.println(evidenceRepository.findById(1L));
    }

    @Test
    @Order(4)
    void update() {
        Evidence evidence = new Evidence();
        evidence.setId(1L);
        evidence.setVersion(2);
        evidence.setNotes("note6");
        evidence.setItemName("item6");
    }

    @Test
    @Order(5)
    void deleteById() {
        evidenceRepository.deleteById(2L);
    }
}