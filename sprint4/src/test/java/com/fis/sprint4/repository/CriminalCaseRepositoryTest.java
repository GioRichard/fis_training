package com.fis.sprint4.repository;

import com.fis.sprint4.model.CriminalCase;
import com.fis.sprint4.model.Detective;
import com.fis.sprint4.model.num.CaseStatus;
import com.fis.sprint4.model.num.CaseType;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CriminalCaseRepositoryTest {
    @Autowired
    CriminalCaseRepository criminalCaseRepository;

    @Test
    public void FindById() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        CriminalCase result = this.criminalCaseRepository.findById(employee.getId()).get();
        assertEquals(employee.getId(), result.getId());
    }

    @Test
    public void Save() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        CriminalCase found = this.criminalCaseRepository.findById(employee.getId()).get();
        assertEquals(employee.getId(), found.getId());
    }


    @Test
    public void DeleteById() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        this.criminalCaseRepository.deleteById(employee.getId());
        List<CriminalCase> result = new ArrayList<>(this.criminalCaseRepository.findAll());
        assertEquals(result.size(), 1);
    }
    @Test
    public void FindAll() {
        CriminalCase employee = getCriminalCase();
        this.criminalCaseRepository.save(employee);
        List<CriminalCase> result = new ArrayList<>(this.criminalCaseRepository.findAll());
        assertEquals(result.size(), 3);
    }
    @Test
    private CriminalCase getCriminalCase() {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCreateAt(LocalDateTime.now());
        criminalCase.setModifiedAt(LocalDateTime.now());
        criminalCase.setVersion(2);
        criminalCase.setDetailedDescription("detail3");
        criminalCase.setNotes("note3");
        criminalCase.setNumber("333333");
        criminalCase.setShortDescription("short3");
        criminalCase.setStatus(CaseStatus.valueOf("COLD"));
        criminalCase.setType(CaseType.valueOf("UNCATEGORIZED"));
        Detective detective = new Detective();
        detective.setId(3L);
        criminalCase.setLeadInvestigator(detective);
        return criminalCase;
    }

}