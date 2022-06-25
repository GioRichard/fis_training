package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.model.CriminalCase;
import fis.bank.criminalsystemmanagement.model.Detective;
import fis.bank.criminalsystemmanagement.model.enums.CaseStatus;
import fis.bank.criminalsystemmanagement.model.enums.CaseType;
import fis.bank.criminalsystemmanagement.repository.EvidenceRepository;
import fis.bank.criminalsystemmanagement.service.CriminalCaseService;
import fis.bank.criminalsystemmanagement.service.DetectiveService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CriminalCaseServiceImplTest {
    @Autowired
    CriminalCaseService criminalCaseService;

    @Autowired
    DetectiveService detectiveService;

    @Test
    @Order(1)
    void findAll() {
        assertEquals(2,criminalCaseService.getAll().size());
    }

    @Test
    @Order(2)
    void findById() {
        CriminalCase criminalCase = criminalCaseService.findById(1L);
        assertEquals("4444",criminalCase.getNumber());
    }

    @Test
    @Order(3)
    void save() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCreatedAt(LocalDateTime.now());
        criminalCase.setModifiedAt(LocalDateTime.now());
        criminalCase.setVersion(1);
        criminalCase.setDetailedDescription("detail3");
        criminalCase.setNotes("notes3");
        criminalCase.setNumber("123412");
        criminalCase.setShortDescription("short3");
        criminalCase.setCaseStatus(CaseStatus.UNDER_INVESTIGATION);
        criminalCase.setCaseType(CaseType.UNCATEGORIZED);
        Detective detective = detectiveService.findById(2L);
        criminalCase.setLeadInvestigator(detective);
        criminalCaseService.create(criminalCase);
        assertEquals(3,criminalCaseService.getAll().size());
    }

    @Test
    @Order(4)
    void deleteById() {
        criminalCaseService.deleteById(3L);
        assertEquals(2,criminalCaseService.getAll().size());
    }
}