package fis.bank.criminalsystemmanagement.service;

import fis.bank.criminalsystemmanagement.model.CriminalCase;

import java.util.List;
import java.util.Optional;

public interface CriminalCaseService {
    CriminalCase CreateCriminalCase(CriminalCase criminalCase);
    CriminalCase updateCriminalCase(CriminalCase criminalCase);
    CriminalCase deleteCriminalCaseById(Long id);
    List<CriminalCase> fillAll();

    Optional<CriminalCase> findById(Long id);
}
