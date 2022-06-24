package fis.criminal.dao.jdbc.mapper;

import fis.criminal.dao.jdbc.Utils;
import fis.criminal.model.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StorageMapper {
    public static final Logger logger = LoggerFactory.getLogger(CriminalCaseMapper.class);

    public static Storage get(ResultSet evidenceResultSet){
        try {
            Storage storage = new Storage();

            storage.setId(evidenceResultSet.getLong("id"));
            storage.setVersion(evidenceResultSet.getInt("version"));
            storage.setName(evidenceResultSet.getString("name"));
            storage.setCreatedAt(Utils.covertLocalDateTimeToDate(evidenceResultSet.getDate("createdAt")));
            storage.setModifiedAt(Utils.covertLocalDateTimeToDate(evidenceResultSet.getDate("modifiedAt")));
            storage.setLocation(evidenceResultSet.getString("location"));

            return storage;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }
}
