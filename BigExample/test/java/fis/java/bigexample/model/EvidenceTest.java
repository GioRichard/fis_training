package fis.java.bigexample.model;

import fis.java.bigexample.model.enums.CaseStatus;
import fis.java.bigexample.model.enums.CaseType;
import fis.java.bigexample.model.enums.Rank;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static fis.java.bigexample.model.enums.EmploymentStatus.ACTIVE;
import static org.junit.jupiter.api.Assertions.*;

public class EvidenceTest {

    @Test
    void getCriminalCase() {
    }

    @Test
    void testContructor() {
        //a1
        Evidence evidence = new Evidence(1L,1,null,null,null,null,
                "1","item1","note1",true,null);

        //A2
        long id = evidence.getId();

        //A3
        assertEquals(1L,id);
//        System.out.println(id);
    }

    public static List<Evidence> createEvidence(){
        List<Evidence> evidenceList = new ArrayList<>();

        CriminalCase criminalCase =new CriminalCase();
        criminalCase.setNumber("1");
        criminalCase.setType(CaseType.FELONY);
        criminalCase.setStatus(CaseStatus.DISMISSED);
        criminalCase.setDetailedDescription("aaa");
        criminalCase.setShortDescription("a");
        criminalCase.setNotes("notes1");

        Storage storage = new Storage();
        storage.setName("data1");
        storage.setLocation("left");

        Evidence evidence1 = new Evidence(1L,1,null,null,criminalCase,storage,
                "1","item1","note1",true,null);

        evidenceList.add(evidence1);
        return  evidenceList;
    }
}