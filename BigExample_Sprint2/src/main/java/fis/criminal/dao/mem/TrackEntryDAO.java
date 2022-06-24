package fis.criminal.dao.mem;

import fis.criminal.dao.ITrackEntryDAO;
import fis.criminal.model.TrackEntry;

import java.util.List;
import java.util.Optional;

public class TrackEntryDAO implements ITrackEntryDAO {
    @Override
    public void save(TrackEntry trackEntry) {
        MemoryDataSource.TRACK_ENTRIES.add(trackEntry);
    }

    @Override
    public Optional<TrackEntry> get(long id) {

        return MemoryDataSource.TRACK_ENTRIES.stream()
                .filter(trackEntry -> trackEntry.getId() ==id)
                .findFirst();
    }

    @Override
    public List<TrackEntry> getAll() {

        return MemoryDataSource.TRACK_ENTRIES;
    }

    @Override
    public List<TrackEntry> update(TrackEntry newTrackEntry) {

        Optional<TrackEntry> trackEntry = get(newTrackEntry.getId());
        if(trackEntry.isPresent()){
            TrackEntry updateTrackEntry= trackEntry.get();
            updateTrackEntry.replaceWith(newTrackEntry);
        }
        return null;
    }

    @Override
    public TrackEntry delete(TrackEntry trackEntry) {
        MemoryDataSource.TRACK_ENTRIES.remove(trackEntry);
        return null;
    }
}
