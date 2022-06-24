package fis.criminal.dao.jdbc;

import fis.criminal.dao.IStorageDAO;
import fis.criminal.dao.jdbc.mapper.StorageMapper;
import fis.criminal.dao.mem.MemoryDataSource;
import fis.criminal.model.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class JDBCStorageDAO implements IStorageDAO {
    private final static Logger logger = LoggerFactory.getLogger(JDBCStorageDAO.class);

    @Override
    public void save(Storage storage) {

    }

    @Override
    public Optional<Storage> get(long id) {
        try(Connection conn = DatabaseUtility.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT *FROM storage WHERE id=?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            Storage storage = null;
            if(rs.next()){
                storage = StorageMapper.get(rs);
            }
            Optional<Storage> opt = Optional.of(storage);
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
    public List<Storage> getAll() {
        try (Connection con = DatabaseUtility.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM storage");
             ResultSet rs = stmt.executeQuery ()) {

            while (rs.next()) {
                Storage storage = StorageMapper.get(rs);
                if(storage != null) MemoryDataSource.STORAGES.add(storage);
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return MemoryDataSource.STORAGES;
    }

    @Override
    public List<Storage> update(Storage storage) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("UPDATE storage " +
                            "SET version = ?,createdAt = ?, modifiedAt = ?, name = ?, location = ? WHERE id = ?");
            stmt.setInt(1,storage.getVersion());
            stmt.setDate(2, Date.valueOf(storage.getCreatedAt().toLocalDate()));
            stmt.setDate(3, Date.valueOf(storage.getModifiedAt().toLocalDate()));
            stmt.setString(4,storage.getName());
            stmt.setString(5,storage.getLocation());
            stmt.setLong(11,storage.getId());

            stmt.executeUpdate();
        }catch (Exception ex) {
            logger.error(ex.toString());
        }

        return MemoryDataSource.STORAGES;
    }

    @Override
    public Storage delete(Storage storage) {
        try(Connection con = DatabaseUtility.getConnection()) {
            PreparedStatement stmt =
                    con.prepareStatement("DELETE FROM storage WHERE id = ?");
            stmt.setLong(1,storage.getId());
            stmt.executeUpdate();

        }catch (Exception ex) {
            logger.error(ex.toString());
        }
        return storage;
    }
}
