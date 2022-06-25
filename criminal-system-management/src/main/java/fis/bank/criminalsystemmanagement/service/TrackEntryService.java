package fis.bank.criminalsystemmanagement.service;

import fis.bank.criminalsystemmanagement.model.TrackEntry;

import java.util.Set;

public interface TrackEntryService {
    void create(TrackEntry trackEntry);
    Set<TrackEntry> getALl();
    TrackEntry findById(Long id);
    TrackEntry update(TrackEntry trackEntry);
    void deleteById(Long id);
}
