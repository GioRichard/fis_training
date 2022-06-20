package fis.bank.criminalsystemmanagement.service.impl;

import fis.bank.criminalsystemmanagement.repository.CriminalCaseRepository;
import fis.bank.criminalsystemmanagement.service.CriminalCaseService;
import fis.bank.model.CriminalCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriminalCaseServiceImpl implements CriminalCaseService {
    @Autowired
    private CriminalCaseRepository criminalCaseRepository;
    @Override
    public CriminalCase CreateCriminalCase(CriminalCase criminalCase) {
        return criminalCaseRepository.save(criminalCase);
    }

    @Override
    public CriminalCase updateCriminalCase(CriminalCase criminalCase) {
        return criminalCaseRepository.save(criminalCase);
    }

    @Override
    public CriminalCase deleteCriminalCaseById(Long id) {
        Optional<CriminalCase> opt = criminalCaseRepository.findById(id);
        if(opt.isPresent())
            criminalCaseRepository.deleteById(id);
        else
            throw new IllegalArgumentException(String.format("ID khong ton tai: %s",id));
        return null;
    }

    @Override
    public List<CriminalCase> fillAll() {
        return criminalCaseRepository.findAll();
    }

    @Override
    public Optional<CriminalCase> findById(Long id) {
        return criminalCaseRepository.findById(id);
    }
}
