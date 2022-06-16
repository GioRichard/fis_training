package fis.criminal.dao.jdbc.mapper;

import fis.criminal.dao.jdbc.JDBCDetectiveDAO;
import fis.criminal.dao.jdbc.utils;
import fis.criminal.model.CriminalCase;

import fis.criminal.model.Detective;
import fis.criminal.model.enums.CaseStatus;
import fis.criminal.model.enums.CaseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CriminalCaseMapper {
    public static final Logger logger = LoggerFactory.getLogger(CriminalCaseMapper.class);
    public static  final JDBCDetectiveDAO jdbcDetectiveDAAO = new JDBCDetectiveDAO();
    public static CriminalCase get(ResultSet criminalCaseResultSet){
        try {
            CriminalCase criminalCase = new CriminalCase();

            criminalCase.setId(criminalCaseResultSet.getLong("id"));
            criminalCase.setVersion(criminalCaseResultSet.getInt("version"));
            criminalCase.setNumber(criminalCaseResultSet.getString("number"));
            criminalCase.setShortDescription(criminalCaseResultSet.getString("shortDescription"));
            criminalCase.setDetailedDescription(criminalCaseResultSet.getString("detailedDescription"));
            criminalCase.setNotes(criminalCaseResultSet.getString("note"));
            criminalCase.setCreatedAt(utils.covertLocalDateTimeToDate(criminalCaseResultSet.getDate("createdAt")));
            criminalCase.setModifiedAt(utils.covertLocalDateTimeToDate(criminalCaseResultSet.getDate("modifiedAt")));
            criminalCase.setType(CaseType.valueOf(criminalCaseResultSet.getString("type")));
            criminalCase.setStatus(CaseStatus.valueOf(criminalCaseResultSet.getString("status")));
            Optional<Detective> opt = jdbcDetectiveDAAO.get(criminalCaseResultSet.getLong("leadInvestigatorId"));
            if(opt.isPresent())
                criminalCase.setLeadInvestigator(opt.get());

            return criminalCase;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }
}
