package fis.criminal.dao.jdbc;

import fis.criminal.dao.IDetectiveDAO;
import fis.criminal.dao.jdbc.mapper.DetectiveMapper;
import fis.criminal.dao.mem.MemoryDataSource;
import fis.criminal.model.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class JDBCDetectiveDAO implements IDetectiveDAO {

    private final static Logger logger = LoggerFactory.getLogger(JDBCDetectiveDAO.class);

    @Override
    public void save(Detective detective) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement(" INSERT INTO detective VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setLong(1,detective.getId());
            stmt.setInt(2,detective.getVersion());
            stmt.setDate(3, Date.valueOf(detective.getCreatedAt().toLocalDate()));
            stmt.setDate(4, Date.valueOf(detective.getModifiedAt().toLocalDate()));
            stmt.setString(5,detective.getUsername());
            stmt.setString(6,detective.getFirstName());
            stmt.setString(7,detective.getLastName());
            stmt.setString(8,detective.getPassword());
            stmt.setDate(9,Date.valueOf(detective.getHiringDate().toLocalDate()));
            stmt.setString(10,detective.getBadgeNumber());
            stmt.setString(11,detective.getRank().toString());
            stmt.setBoolean(12,detective.getArmed());
            stmt.setString(13,detective.getStatus().toString());

            stmt.executeUpdate();
        }catch (Exception ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public Optional<Detective> get(long id) {
        try(Connection conn = DatabaseUtility.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT *FROM detective WHERE id=?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            Detective detective = null;
            if(rs.next()){
                detective= DetectiveMapper.get(rs);
            }
            Optional<Detective> opt = Optional.of(detective);
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
    public List<Detective> getAll() {
        try(
            Connection con = DatabaseUtility.getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM detective");
            ResultSet rs = stmt.executeQuery ()) {
                while (rs.next()) {
                    Detective detective = DetectiveMapper.get(rs);
                    if(detective != null) MemoryDataSource.DETECTIVES.add(detective);
                }
            }
        catch (SQLException ex){
            logger.error(ex.toString());
        } catch (Exception e) {
            logger.error(e.toString());
        }

        return MemoryDataSource.DETECTIVES;
    }

    @Override
    public List<Detective> update(Detective detective) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("UPDATE detective " +
                            "SET version = ?,createdAt = ?, modifiedAt = ?, username = ?, firstName = ?, " +
                            "lastName = ?, pw = ?" +
                            ",hiringDate = ?, badgeNumber = ?, rankOfDetective = ?, armed = ?, status =? WHERE id = ?");
            stmt.setInt(1,detective.getVersion());
            stmt.setDate(2, Date.valueOf(detective.getCreatedAt().toLocalDate()));
            stmt.setDate(3, Date.valueOf(detective.getModifiedAt().toLocalDate()));
            stmt.setString(4,detective.getUsername());
            stmt.setString(5,detective.getFirstName());
            stmt.setString(6,detective.getLastName());
            stmt.setString(7,detective.getPassword());
            stmt.setDate(8,Date.valueOf(detective.getHiringDate().toLocalDate()));
            stmt.setString(9,detective.getBadgeNumber());
            stmt.setString(10,detective.getRank().toString());
            stmt.setBoolean(11,detective.getArmed());
            stmt.setString(12,detective.getStatus().toString());
            stmt.setLong(13,detective.getId());

            stmt.executeUpdate();
        }catch (Exception ex) {
            logger.error(ex.toString());
        }

        return MemoryDataSource.DETECTIVES;
    }

    @Override
    public Detective delete(Detective detective) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("DELETE FROM detective WHERE id = ?");
            stmt.setLong(1,detective.getId());
            stmt.executeUpdate();

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return detective;
    }
}
