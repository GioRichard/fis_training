package fis.java.bigexample.model;

import fis.java.bigexample.model.enums.EmploymentStatus;
import fis.java.bigexample.model.enums.Rank;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static fis.java.bigexample.model.enums.EmploymentStatus.ACTIVE;
import static org.junit.jupiter.api.Assertions.*;

public class DetectiveTest {

    @Test
    void getBadgeNumber() {
    }

    @Test
    void setBadgeNumber() {
    }

    @Test
    void testContructor() {
        //a1
        Detective detective = new Detective(1L,1,null,null, "1", Rank.TRANEE,
                true, ACTIVE,null,null,"Phong","Ha", "Quoc","1234",null);

        //A2
        long id = detective.getId();

        //A3
        assertEquals(1L,id);
//        System.out.println(id);
    }

    public static List<Detective> createDelective(){
        List<Detective> detectiveList = new ArrayList<>();

        Detective detective1 = new Detective(1L,1,null,null, "1", Rank.TRANEE,
                true, ACTIVE,null,null,"Phong","Ha", "Quoc","1234",null);
        Detective detective2 = new Detective(2L,1,null,null, "1", Rank.TRANEE,
                true, ACTIVE,null,null,"Tran","Tinh", "Nguyen","123456",null);

        detectiveList.add(detective1);
        detectiveList.add(detective2);

        return  detectiveList;
    }

}