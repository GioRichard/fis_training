package fis.criminal.dao.jdbc;

import fis.criminal.dao.ICriminalCaseDAO;
import fis.criminal.dao.IStorageDAO;
import fis.criminal.model.CriminalCase;
import fis.criminal.model.Storage;
import fis.criminal.model.enums.CaseType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCStorageDAOTest {

    @Test
    void getAll() {
        IStorageDAO iStorageDAO = new JDBCStorageDAO();
        List<Storage> storageList = iStorageDAO.getAll();
        System.out.println(storageList);
    }
    @Test
    void delete() {
        IStorageDAO iStorageDAO = new JDBCStorageDAO();
        Storage c = new Storage();
        c.setId(6L);
        c.setLocation("HaNoi");
        Storage storage = iStorageDAO.delete(c);
        assertEquals("HaNoi",storage.getLocation());
    }
}