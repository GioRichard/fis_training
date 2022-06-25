package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.repository.EvidenceRepository;
import fis.bank.criminalsystemmanagement.service.EvidenceService;
import fis.bank.criminalsystemmanagement.model.Evidence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    @Autowired
    private EvidenceRepository evidenceRepository;

    @Override
    public void create(Evidence evidence) {
        evidenceRepository.save(evidence);
    }

    @Override
    public Set<Evidence> getALl() {
        return (Set<Evidence>) evidenceRepository.findAll();
    }

    @Override
    public Evidence findById(Long id) {
        return null;
    }

    @Override
    public Evidence update(Evidence evidence) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
