package com.fis.sprint4.service;

import com.fis.sprint4.model.TrackEntry;

import java.util.Set;

public interface TrackEntryService {
    TrackEntry addTrackEntry(TrackEntry trackEntry);

    TrackEntry updateTrackEntry(TrackEntry trackEntry);

    Set<TrackEntry> getTrackEntries();

    TrackEntry getTrackEntry(Long id);

    void deleteTrackEntry(Long id);
}
