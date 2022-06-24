package fis.criminal.dao.jdbc;

import fis.criminal.dao.ICriminalCaseDAO;
import fis.criminal.dao.jdbc.mapper.CriminalCaseMapper;
import fis.criminal.dao.mem.MemoryDataSource;
import fis.criminal.model.CriminalCase;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class JDBCCriminalCaseDAO implements ICriminalCaseDAO {

    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);

    @Override
    public void save(CriminalCase criminalCase) {
        try(Connection conn = DatabaseUtility.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO criminalcase VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setLong(1,criminalCase.getId());
            stmt.setInt(2,criminalCase.getVersion());
            stmt.setDate(3,Date.valueOf(criminalCase.getCreatedAt().toLocalDate()));
            stmt.setDate(4, Date.valueOf(criminalCase.getModifiedAt().toLocalDate()));
            stmt.setString(5,criminalCase.getNumber());
            stmt.setString(6,criminalCase.getType().toString());
            stmt.setString(7,criminalCase.getShortDescription());
            stmt.setString(8,criminalCase.getDetailedDescription());
            stmt.setString(9,criminalCase.getStatus().toString());
            stmt.setString(10,criminalCase.getNotes());
            stmt.setLong(11,criminalCase.getLeadInvestigator().getId());
            stmt.executeUpdate();
        }
        catch (Exception e){
            logger.error(e.toString());
        }
    }

    @Override
    public Optional<CriminalCase> get(long id) {
        try(Connection conn = DatabaseUtility.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT *FROM criminalcase WHERE id=?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            CriminalCase criminalCase = null;
            if(rs.next()){
                criminalCase= CriminalCaseMapper.get(rs);
            }
            Optional<CriminalCase> opt = Optional.of(criminalCase);
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
    public List<CriminalCase> getAll() {

        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM criminalcase");
             ResultSet rs = stmt.executeQuery ()) {

            while (rs.next()) {
                CriminalCase criminalCase = CriminalCaseMapper.get(rs);
                if(criminalCase != null) MemoryDataSource.CRIMINAL_CASES.add(criminalCase);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return MemoryDataSource.CRIMINAL_CASES;
    }

    @Override
    public List<CriminalCase> update(CriminalCase criminalCase) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("UPDATE criminalcase " +
                            "SET version = ?,createdAt = ?, modifiedAt = ?, number = ?, type = ?, " +
                            "shortDescription = ?, detailedDescription = ?" +
                            ",status = ?, note = ?, leadInvestigatorId = ? WHERE id = ?");
            stmt.setInt(1,criminalCase.getVersion());
            stmt.setDate(2, Date.valueOf(criminalCase.getCreatedAt().toLocalDate()));
            stmt.setDate(3, Date.valueOf(criminalCase.getModifiedAt().toLocalDate()));
            stmt.setString(4,criminalCase.getNumber());
            stmt.setString(5, criminalCase.getType().toString());
            stmt.setString(6,criminalCase.getShortDescription());
            stmt.setString(7,criminalCase.getDetailedDescription());
            stmt.setString(8, criminalCase.getStatus().toString());
            stmt.setString(9, criminalCase.getNotes());
            stmt.setLong(10, criminalCase.getLeadInvestigator().getId());
            stmt.setLong(11,criminalCase.getId());
            stmt.executeUpdate();
        }catch (Exception ex) {
            logger.error(ex.toString());
        }

        return MemoryDataSource.CRIMINAL_CASES;
    }

    @Override
    public CriminalCase delete(CriminalCase criminalCase) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("DELETE FROM criminalcase WHERE id = ?");
            stmt.setLong(1,criminalCase.getId());
            stmt.executeUpdate();

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return criminalCase;
    }

    @Override
    public boolean delete(long id) {

        return MemoryDataSource.CRIMINAL_CASES.remove(id);
    }
}
