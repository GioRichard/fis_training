package fis.bank.criminalsystemmanagement.repository;

import fis.bank.criminalsystemmanagement.model.Detective;
import fis.bank.criminalsystemmanagement.model.TrackEntry;
import fis.bank.criminalsystemmanagement.model.enums.TrackAction;

import java.util.Date;
import java.util.Set;

public interface TrackEntryRepository extends AbstractRepoRepository<TrackEntry>{
    Set<TrackEntry> findByDetectiveId(Long detectiveId);

    Set<TrackEntry> findByEvidenceId(Long evidenceId);

    Set<TrackEntry> findByDate(Date date);

    Set<TrackEntry> findByDateAndAction(Date date, TrackAction action);
}
