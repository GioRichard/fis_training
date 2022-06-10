package fis.criminal.dao.mem;

import fis.criminal.dao.ICriminalCaseDAO;
import fis.criminal.model.CriminalCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CriminalCaseDAOTest {

    @Test
    void save() {
        //A1: Arrange
        CriminalCase criminalCase = new CriminalCase();
        // init data
        // ...
        //A2: Action
        int before = MemoryDataSource.CRIMINAL_CASES.size();
        ICriminalCaseDAO iCriminalCaseDAO = new CriminalCaseDAO();
        iCriminalCaseDAO.save(criminalCase);
        //A3: Assert
        assertEquals(before+1, MemoryDataSource.CRIMINAL_CASES.size());
    }

    @Test
    void get() {
        System.out.println("test get");
    }
    @Test
    void getAll() {
        System.out.println("test getAll");
    }
    @Test
    void update() {
        System.out.println("test update");
    }
    @Test
    void delete() {
        System.out.println("test delete");
    }

    @Test
    void testDelete() {
    }
}