package fis.criminal.dao.jdbc;
import fis.criminal.dao.ITrackEntryDAO;
import fis.criminal.dao.jdbc.mapper.TrackEntryMapper;
import fis.criminal.dao.mem.MemoryDataSource;

import fis.criminal.model.TrackEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;
import java.util.Optional;
public class JDBCTrackEntryDAO implements ITrackEntryDAO {
    private final static Logger logger = LoggerFactory.getLogger(JDBCTrackEntryDAO.class);

    @Override
    public void save(TrackEntry trackEntry) {

    }

    @Override
    public Optional<TrackEntry> get(long id) {
        try(Connection conn = DatabaseUtility.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT *FROM trackentry WHERE id=?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            TrackEntry trackentry = null;
            if(rs.next()){
                trackentry = TrackEntryMapper.get(rs);
            }
            Optional<TrackEntry> opt = Optional.of(trackentry);
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
    public List<TrackEntry> getAll() {
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM trackentry");
             ResultSet rs = stmt.executeQuery ()) {

            while (rs.next()) {
                TrackEntry trackEntry = TrackEntryMapper.get(rs);
                if(trackEntry != null) MemoryDataSource.TRACK_ENTRIES.add(trackEntry);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        catch (Exception e) {
            logger.error(e.toString());
        }
        return MemoryDataSource.TRACK_ENTRIES;
    }

    @Override
    public List<TrackEntry> update(TrackEntry trackEntry) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("UPDATE trackentry " +
                            "SET version = ?,createdAt = ?, modifiedAt = ?, trackDate = ?," +
                            " action = ?, reason = ?, detectiveId = ?, evidenceId =? WHERE id = ?");
            stmt.setInt(1,trackEntry.getVersion());
            stmt.setDate(2, Date.valueOf(trackEntry.getCreatedAt().toLocalDate()));
            stmt.setDate(3, Date.valueOf(trackEntry.getModifiedAt().toLocalDate()));
            stmt.setDate(4, Date.valueOf(trackEntry.getDate().toLocalDate()));
            stmt.setString(5,trackEntry.getAction().toString());
            stmt.setString(6,trackEntry.getReason());
            stmt.setLong(7,trackEntry.getId());

            stmt.executeUpdate();
        }catch (Exception ex) {
            logger.error(ex.toString());
        }

        return MemoryDataSource.TRACK_ENTRIES;
    }

    @Override
    public TrackEntry delete(TrackEntry trackEntry) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("DELETE FROM trackentry WHERE id = ?");
            stmt.setLong(1,trackEntry.getId());
            stmt.executeUpdate();

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return trackEntry;
    }
}

