package fis.criminal.dao.jdbc;

import fis.criminal.model.CriminalCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class CriminalCaseMapper {
    public static final Logger logger = LoggerFactory.getLogger(CriminalCaseMapper.class);

    public static CriminalCase get(ResultSet criminalCaseResultSet){
        try {
            CriminalCase criminalCase = new CriminalCase();

            criminalCase.setId(criminalCaseResultSet.getLong("id"));
            criminalCase.setVersion(criminalCaseResultSet.getInt("version"));
            criminalCase.setNumber(criminalCaseResultSet.getString("number"));
            criminalCase.setShortDescription(criminalCaseResultSet.getString("short_description"));
            criminalCase.setDetailedDescription(criminalCaseResultSet.getString("long_description"));

            //TODO add some add.

            return criminalCase;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }
}
