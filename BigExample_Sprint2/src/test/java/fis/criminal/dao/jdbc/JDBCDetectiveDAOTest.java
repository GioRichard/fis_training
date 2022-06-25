package fis.criminal.dao.jdbc;

import fis.criminal.dao.IDetectiveDAO;
import fis.criminal.model.Detective;
import fis.criminal.model.enums.EmploymentStatus;
import fis.criminal.model.enums.Rank;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

class JDBCDetectiveDAOTest {

    @Test
    void save() {
        IDetectiveDAO iDetectiveDAO = new JDBCDetectiveDAO();
        Detective c = new Detective();
        c.setId(5L);
        c.setVersion(1);
        c.setCreatedAt(LocalDateTime.now());
        c.setModifiedAt(LocalDateTime.now());
        c.setUsername("Phong");
        c.setRank(Rank.INSPECTOR);
        c.setHiringDate(LocalDateTime.now());
        c.setArmed(Boolean.TRUE);
        c.setStatus(EmploymentStatus.ACTIVE);

        iDetectiveDAO.save(c);

    }

    @Test
    void getAll() {
        IDetectiveDAO iDetectiveDAO = new JDBCDetectiveDAO();
        List<Detective> detectiveList = iDetectiveDAO.getAll();
        System.out.println(detectiveList);
    }

    @Test
    void findById() {
        IDetectiveDAO iDetectiveDAO = new JDBCDetectiveDAO();
        Optional<Detective> detective = iDetectiveDAO.get(1L);
        System.out.println(detective);
    }
}