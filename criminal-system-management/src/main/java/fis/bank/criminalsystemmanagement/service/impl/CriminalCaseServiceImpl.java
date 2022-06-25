package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.model.CriminalCase;
import fis.bank.criminalsystemmanagement.repository.CriminalCaseRepository;
import fis.bank.criminalsystemmanagement.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalCaseServiceImpl implements CriminalCaseService {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;
    @Override
    public void create(CriminalCase criminalCase) {
        criminalCaseRepository.save(criminalCase);
    }

    @Override
    public List<CriminalCase> getAll() {
        return criminalCaseRepository.findAll();
    }

    @Override
    public CriminalCase update(CriminalCase criminalCase) {
        return criminalCaseRepository.save(criminalCase);
    }

    @Override
    public void deleteById(Long id) {
        criminalCaseRepository.deleteById(id);
    }

    @Override
    public CriminalCase findById(Long id) {
        return criminalCaseRepository.findById(id).orElse(null);
    }
}
