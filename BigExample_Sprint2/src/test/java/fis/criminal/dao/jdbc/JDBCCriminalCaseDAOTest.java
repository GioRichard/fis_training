package fis.criminal.dao.jdbc;

import fis.criminal.dao.ICriminalCaseDAO;
import fis.criminal.dao.mem.MemoryDataSource;
import fis.criminal.model.CriminalCase;
import fis.criminal.model.Detective;
import fis.criminal.model.enums.CaseStatus;
import fis.criminal.model.enums.CaseType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class JDBCCriminalCaseDAOTest {

    @Test
    void save() {
        ICriminalCaseDAO iCriminalCaseDAO = new JDBCCriminalCaseDAO();
        CriminalCase c = new CriminalCase();
        c.setId(5L);
        c.setVersion(1);
        c.setCreatedAt(LocalDateTime.now());
        c.setModifiedAt(LocalDateTime.now());
        c.setNumber("66666");
        c.setType(CaseType.MISDEMEANOR);
        c.setShortDescription("shortDesc2");
        c.setDetailedDescription("DetailDesc2");
        c.setStatus(CaseStatus.CLOSED);
        c.setNotes("notes2");
        Detective d = new Detective();
        d.setId(1L);
        c.setLeadInvestigator(d);
        iCriminalCaseDAO.save(c);
    }

    @Test
    void getAll() {
        ICriminalCaseDAO iCriminalCaseDAO = new JDBCCriminalCaseDAO();
        System.out.println(MemoryDataSource.CRIMINAL_CASES.size());
    }

    @Test
    void delete() {
        ICriminalCaseDAO iCriminalCaseDAO = new JDBCCriminalCaseDAO();
        CriminalCase c = new CriminalCase();
        c.setId(6L);
        c.setNumber("8888");
        c.setType(CaseType.MISDEMEANOR);
        c.setShortDescription("shortDesc6");
        c.setDetailedDescription("DetailDesc6");
        CriminalCase criminalCase = iCriminalCaseDAO.delete(c);
        assertEquals("8888",criminalCase.getNumber());
    }


    @Test
    void testDelete() {
        ICriminalCaseDAO iCriminalCaseDAO = new JDBCCriminalCaseDAO();
        CriminalCase c = new CriminalCase();
        c.setId(7L);
        c.setNumber("99");
        c.setType(CaseType.MISDEMEANOR);
        c.setShortDescription("shortDesc7");
        c.setDetailedDescription("DetailDesc7");
        assertFalse(iCriminalCaseDAO.delete(7L));
    }
}