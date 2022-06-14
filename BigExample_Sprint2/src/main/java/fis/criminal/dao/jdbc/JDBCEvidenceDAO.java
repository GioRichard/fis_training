package fis.criminal.dao.jdbc;

import fis.criminal.dao.IEvidenceDAO;
import fis.criminal.dao.mem.MemoryDataSource;
import fis.criminal.model.Evidence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class JDBCEvidenceDAO implements IEvidenceDAO {
    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);

    @Override
    public void save(Evidence evidence) {

    }

    @Override
    public Optional<Evidence> get(long id) {
        try(Connection conn = DatabaseUtility.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT *FROM evidence WHERE id=?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            Evidence evidence = null;
            if(rs.next()){
                evidence = EvidenceMapper.get(rs);
            }
            Optional<Evidence> opt = Optional.of(evidence);
            if(opt.isPresent()){
                return Optional.of(opt.get());
            }
        }
        catch (Exception e){
            logger.error(e.toString());
        }
        return Optional.empty();
    }

    @Override
    public List<Evidence> getAll() {
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM evidence");
             ResultSet rs = stmt.executeQuery ()) {

            while (rs.next()) {
                Evidence evidence = EvidenceMapper.get(rs);
                if(evidence != null) MemoryDataSource.EVIDENCES.add(evidence);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return MemoryDataSource.EVIDENCES;
    }

    @Override
    public List<Evidence> update(Evidence evidence) {
        return null;
    }

    @Override
    public void delete(Evidence evidence) {

    }
}
