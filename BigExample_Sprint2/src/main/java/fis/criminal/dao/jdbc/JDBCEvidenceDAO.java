package fis.criminal.dao.jdbc;

import fis.criminal.dao.IEvidenceDAO;
import fis.criminal.dao.jdbc.mapper.EvidenceMapper;
import fis.criminal.dao.mem.MemoryDataSource;
import fis.criminal.model.Evidence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class JDBCEvidenceDAO implements IEvidenceDAO {
    private final static Logger logger = LoggerFactory.getLogger(JDBCEvidenceDAO.class);

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
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("UPDATE evidence " +
                            "SET version = ?,createdAt = ?, modifiedAt = ?, number = ?, itemName = ?, " +
                            "note = ?, archived = ? WHERE id = ?");
            stmt.setInt(1,evidence.getVersion());
            stmt.setDate(2, Date.valueOf(evidence.getCreatedAt().toLocalDate()));
            stmt.setDate(3, Date.valueOf(evidence.getModifiedAt().toLocalDate()));
            stmt.setString(4,evidence.getNumber());
            stmt.setString(5,evidence.getItemName());
            stmt.setString(6,evidence.getNotes());
            stmt.setBoolean(7,evidence.getArchived());
            stmt.setLong(8,evidence.getId());

            stmt.executeUpdate();
        }catch (Exception ex) {
            logger.error(ex.toString());
        }

        return MemoryDataSource.EVIDENCES;
    }

    @Override
    public Evidence delete(Evidence evidence) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("DELETE FROM evidence WHERE id = ?");
            stmt.setLong(1,evidence.getId());
            stmt.executeUpdate();

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return evidence;
    }
}
