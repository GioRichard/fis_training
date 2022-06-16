package fis.criminal.dao.jdbc.mapper;

import fis.criminal.dao.jdbc.JDBCCriminalCaseDAO;
import fis.criminal.dao.jdbc.utils;
import fis.criminal.model.Detective;
import fis.criminal.model.enums.EmploymentStatus;
import fis.criminal.model.enums.Rank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetectiveMapper {
    public  static final Logger logger = LoggerFactory.getLogger(DetectiveMapper.class);
    public  static  final JDBCCriminalCaseDAO jdbcCriminalCaseDAO = new JDBCCriminalCaseDAO();
    public  static Detective get(ResultSet detectiveResultSet){
        try{
            Detective detective = new Detective();

            detective.setId(detectiveResultSet.getLong("id"));
            detective.setArmed(detectiveResultSet.getBoolean("armed"));
            detective.setVersion(detectiveResultSet.getInt("version"));
            detective.setCreatedAt(utils.covertLocalDateTimeToDate(detectiveResultSet.getDate("createdAt")));
            detective.setModifiedAt(utils.covertLocalDateTimeToDate(detectiveResultSet.getDate("modifiedAt")));
            detective.setUsername(detectiveResultSet.getString("username"));
            detective.setFirstName(detectiveResultSet.getString("firstName"));
            detective.setLastName(detectiveResultSet.getString("lastName"));
            detective.setPassword(detectiveResultSet.getString("pw"));
            detective.setHiringDate(utils.covertLocalDateTimeToDate(detectiveResultSet.getDate("hiringDate")));
            detective.setBadgeNumber(detectiveResultSet.getString("badgeNumber"));
            detective.setRank(Rank.valueOf(detectiveResultSet.getString("rankOfDetective")));
            detective.setStatus(EmploymentStatus.valueOf(detectiveResultSet.getString("status")));

            return detective;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return  null;
    }


}
