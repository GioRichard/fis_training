package fis.bank.criminalsystemmanagement.service;



import fis.bank.criminalsystemmanagement.model.Evidence;

import java.util.List;
import java.util.Optional;

public interface EvidenceService {
    Evidence CreateEvidence(Evidence evidence);
    Evidence updateEvidence(Evidence evidence);
    Evidence deleteEvidenceById(Long id);
    List<Evidence> fillAll();

    Optional<Evidence> findById(Long id);
}
