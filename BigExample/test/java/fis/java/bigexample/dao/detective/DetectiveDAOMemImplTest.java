package fis.java.bigexample.dao.detective;


import fis.java.bigexample.model.Detective;
import fis.java.bigexample.model.DetectiveTest;
import fis.java.bigexample.model.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

import static fis.java.bigexample.model.enums.EmploymentStatus.ACTIVE;
import static org.junit.jupiter.api.Assertions.*;

class DetectiveDAOMemImplTest {

    @Test
    void add() {
        IDetectiveDAO iDetectiveDAO = DetectiveDAOMemImpl.getInstance();

        List<Detective> list = DetectiveTest.createDelective();

        Detective detective3 = new Detective(3L,1,null,null, "1", Rank.TRANEE,
                true, ACTIVE,null,null,"Nguyen","Trung", "Thanh","12345",null);

        list.add(detective3);

        assertEquals("Nguyen",list.get(2).getUserName());
    }

    @Test
    void get() {
        IDetectiveDAO iDetectiveDAO = DetectiveDAOMemImpl.getInstance();

        List<Detective> list = DetectiveTest.createDelective();
        list.stream().forEach(new Consumer<Detective>() {
            @Override
            public void accept(Detective detective) {
                iDetectiveDAO.add(detective);
            }
        });

        Detective detective = iDetectiveDAO.get(1L);


        detective = iDetectiveDAO.get(1L);
        assertEquals(1L,detective.getId());

        detective = iDetectiveDAO.get(3L);
        assertNull(detective.getId());

    }

    @Test
    void getAll() {
        IDetectiveDAO iDetectiveDAO = DetectiveDAOMemImpl.getInstance();

        List<Detective> list = DetectiveTest.createDelective();

        list.stream().forEach(new Consumer<Detective>() {
            @Override
            public void accept(Detective detective) {
                iDetectiveDAO.add(detective);
            }
        });

        int numOfDetective = iDetectiveDAO.getAll().size();

        assertEquals(2,numOfDetective);
    }

    @Test
    void update() {
    }

    @Test
    void remove() {
        IDetectiveDAO iDetectiveDAO = DetectiveDAOMemImpl.getInstance();

        List<Detective> list = DetectiveTest.createDelective();

        list.stream().forEach(new Consumer<Detective>() {
            @Override
            public void accept(Detective detective) {
                iDetectiveDAO.add(detective);
            }
        });

        int numOfDetective = iDetectiveDAO.getAll().size();

        Detective detective = iDetectiveDAO.remove(1L);


        assertEquals("Phong",detective.getUserName());


    }
}