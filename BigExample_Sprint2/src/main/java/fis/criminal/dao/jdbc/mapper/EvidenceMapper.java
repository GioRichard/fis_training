package fis.criminal.dao.jdbc.mapper;


import fis.criminal.dao.jdbc.mapper.CriminalCaseMapper;
import fis.criminal.dao.jdbc.utils;
import fis.criminal.model.Evidence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EvidenceMapper {
    public static final Logger logger = LoggerFactory.getLogger(CriminalCaseMapper.class);

    public static Evidence get(ResultSet evidenceResultSet){
        try {
            Evidence evidence = new Evidence();

            evidence.setId(evidenceResultSet.getLong("id"));
            evidence.setVersion(evidenceResultSet.getInt("version"));
            evidence.setNumber(evidenceResultSet.getString("number"));
            evidence.setCreatedAt(utils.covertLocalDateTimeToDate(evidenceResultSet.getDate("createdAt")));
            evidence.setModifiedAt(utils.covertLocalDateTimeToDate(evidenceResultSet.getDate("modifiedAt")));
            evidence.setItemName(evidenceResultSet.getString("itemName"));
            evidence.setNotes(evidenceResultSet.getString("note"));
            evidence.setArchived(evidenceResultSet.getBoolean("archived"));

            return evidence;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }
}
