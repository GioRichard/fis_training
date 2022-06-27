package fis.java.bigexample.dao.evidence;

import fis.java.bigexample.dao.detective.DetectiveDAOMemImpl;
import fis.java.bigexample.dao.detective.IDetectiveDAO;
import fis.java.bigexample.model.Detective;
import fis.java.bigexample.model.DetectiveTest;
import fis.java.bigexample.model.Evidence;
import fis.java.bigexample.model.EvidenceTest;
import fis.java.bigexample.model.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static fis.java.bigexample.model.enums.EmploymentStatus.ACTIVE;
import static org.junit.jupiter.api.Assertions.*;

class EvidenceDAOMemlmplTest {

    @Test
    void getInstance() {
    }

    @Test
    void add() {
        IEvidenceDAO iEvidenceDAO = EvidenceDAOMemlmpl.getInstance();

        List<Evidence> list = EvidenceTest.createEvidence();
        Evidence evidence2 = new Evidence(1L,1,null,null,null,null,
                "1","item1","note1",true,null);


        list.add(evidence2);

        assertEquals("item1",list.get(1).getItemName());
    }

    @Test
    void get() {
        IEvidenceDAO iEvidenceDAO = EvidenceDAOMemlmpl.getInstance();
        List<Evidence> list = EvidenceTest.createEvidence();
        list.stream().forEach(new Consumer<Evidence>() {
            @Override
            public void accept(Evidence evidence) {
                iEvidenceDAO.add(evidence);
            }
        });
        Evidence evidence = iEvidenceDAO.get(1L);

        evidence = iEvidenceDAO.get(1L);
        assertEquals(1L, evidence.getId());
    }

    @Test
    void getAll() {
        IEvidenceDAO iEvidenceDAO = EvidenceDAOMemlmpl.getInstance();
        List<Evidence> list = EvidenceTest.createEvidence();
        list.stream().forEach(new Consumer<Evidence>() {
            @Override
            public void accept(Evidence evidence) {
                iEvidenceDAO.add(evidence);
            }
        });

        int numOfevidence = iEvidenceDAO.getAll().size();

        assertEquals(2,numOfevidence);
    }

    @Test
    void update() {
    }

    @Test
    void remove() {
        IEvidenceDAO iEvidenceDAO = EvidenceDAOMemlmpl.getInstance();
        List<Evidence> list = EvidenceTest.createEvidence();
        list.stream().forEach(new Consumer<Evidence>() {
            @Override
            public void accept(Evidence evidence) {
                iEvidenceDAO.add(evidence);
            }
        });

        Evidence evidence = iEvidenceDAO.remove(1L);
        assertEquals("item1",evidence.getItemName());
    }
}