package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.repository.EvidenceRepository;
import fis.bank.criminalsystemmanagement.service.EvidenceService;
import fis.bank.model.Evidence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvidenceServiceImpl implements EvidenceService {

    @Autowired
    private EvidenceRepository evidenceRepository;
    @Override
    public Evidence CreateEvidence(Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    @Override
    public Evidence updateEvidence(Evidence evidence) {
        return evidenceRepository.save(evidence);
    }

    @Override
    public Evidence deleteEvidenceById(Long id) {
        Optional<Evidence> opt = evidenceRepository.findById(id);
        if(opt.isPresent())
            evidenceRepository.deleteById(id);
        else
            throw new IllegalArgumentException(String.format("ID khong ton tai: %s",id));
        return null;
    }

    @Override
    public List<Evidence> fillAll() {
        return evidenceRepository.findAll();
    }

    @Override
    public Optional<Evidence> findById(Long id) {
        return evidenceRepository.findById(id);
    }
}
