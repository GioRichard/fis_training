package fis.bank.criminalsystemmanagement.service;



import fis.bank.criminalsystemmanagement.model.Evidence;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EvidenceService {
    void create(Evidence evidence);
    Set<Evidence> getALl();
    Evidence findById(Long id);
    Evidence update(Evidence evidence);
    void deleteById(Long id);
}
