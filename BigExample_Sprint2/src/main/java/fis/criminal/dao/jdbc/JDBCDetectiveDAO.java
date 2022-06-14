package fis.criminal.dao.jdbc;

import fis.criminal.dao.IDetectiveDAO;
import fis.criminal.model.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCDetectiveDAO implements IDetectiveDAO {

    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);

    @Override
    public void save(Detective detective) {

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
        List<Detective> detectives = new ArrayList<>();
        try(
            Connection con = DatabaseUtility.getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM detective");
            ResultSet rs = stmt.executeQuery ()) {
                while (rs.next()) {
                    Detective detective = DetectiveMapper.get(rs);
                    if(detective != null) detectives.add(detective);
                }
            }
        catch (SQLException ex){
            logger.error(ex.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return detectives;
    }

    @Override
    public List<Detective> update(Detective detective) {

        return null;
    }

    @Override
    public void delete(Detective detective) {

    }
}
