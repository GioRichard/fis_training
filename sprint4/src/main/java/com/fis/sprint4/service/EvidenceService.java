package com.fis.sprint4.service;

import com.fis.sprint4.model.Evidence;

import java.util.Set;

public interface EvidenceService {
    Evidence addEvidence(Evidence evidence);

    Evidence updateEvidence(Evidence evidence);

    Set<Evidence> getEvidences();

    Evidence getEvidence(Long id);

    void deleteEvidence(Long id);

}