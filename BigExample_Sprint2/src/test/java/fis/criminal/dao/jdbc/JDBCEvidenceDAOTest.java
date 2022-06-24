package fis.criminal.dao.jdbc;

import fis.criminal.dao.IEvidenceDAO;
import fis.criminal.dao.mem.MemoryDataSource;
import fis.criminal.model.CriminalCase;
import fis.criminal.model.Evidence;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JDBCEvidenceDAOTest {

    @Test
    void save() {
        IEvidenceDAO iEvidenceDAO = new JDBCEvidenceDAO();
        Evidence c = new Evidence();
        c.setId(5L);
        c.setVersion(1);
        c.setCreatedAt(LocalDateTime.now());
        c.setModifiedAt(LocalDateTime.now());
        c.setNotes("Notes5");

        iEvidenceDAO.save(c);
    }

    @Test
    void get() {
        IEvidenceDAO iEvidenceDAO = new JDBCEvidenceDAO();
        Optional<Evidence> evidence = iEvidenceDAO.get(1L);
        System.out.println(evidence);

    }

    @Test
    void getAll() {
        IEvidenceDAO iEvidenceDAO = new JDBCEvidenceDAO();
        System.out.println(MemoryDataSource.EVIDENCES.size());
    }

    @Test
    void delete() {
        IEvidenceDAO iEvidenceDAO = new JDBCEvidenceDAO();
        Evidence c = new Evidence();
        c.setId(6L);
        c.setNumber("8888");
        c.setVersion(1);
        Evidence evidence = iEvidenceDAO.delete(c);
        assertEquals(1,evidence.getVersion());
    }
}