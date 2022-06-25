package fis.criminal.dao.jdbc;

import fis.criminal.dao.ITrackEntryDAO;
import fis.criminal.model.TrackEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JDBCTrackEntryDAOTest {
    @Test
    void getAll() {
        ITrackEntryDAO iTrackEntryDAO = new JDBCTrackEntryDAO();
        List<TrackEntry> trackEntryList = iTrackEntryDAO.getAll();
        System.out.println(trackEntryList);
    }
    @Test
    void delete() {
        ITrackEntryDAO iTrackEntryDAO = new JDBCTrackEntryDAO();
        TrackEntry c = new TrackEntry();
        c.setId(6L);
        c.setReason("Reason1");
        TrackEntry trackEntry = iTrackEntryDAO.delete(c);
        assertEquals("Reason1",trackEntry.getReason());
    }
}