package fis.criminal.dao.jdbc.mapper;

import fis.criminal.dao.jdbc.Utils;
import fis.criminal.model.TrackEntry;
import fis.criminal.model.enums.TrackAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackEntryMapper {
    public static final Logger logger = LoggerFactory.getLogger(CriminalCaseMapper.class);

    public static TrackEntry get(ResultSet trackEntryResultSet){
        try {
            TrackEntry trackEntry = new TrackEntry();

            trackEntry.setId(trackEntryResultSet.getLong("id"));
            trackEntry.setVersion(trackEntryResultSet.getInt("version"));
            trackEntry.setDate((Utils.covertLocalDateTimeToDate(trackEntryResultSet.getDate("trackDate"))));
            trackEntry.setCreatedAt(Utils.covertLocalDateTimeToDate(trackEntryResultSet.getDate("createdAt")));
            trackEntry.setModifiedAt(Utils.covertLocalDateTimeToDate(trackEntryResultSet.getDate("trackDate")));
            trackEntry.setAction(TrackAction.valueOf(trackEntryResultSet.getString("rankOfDetective")));
            trackEntry.setReason(trackEntryResultSet.getString("reason"));
            return trackEntry;
        }catch (SQLException ex){
            logger.error(ex.toString());
        }
        return null;
    }
}
