package fis.bank.criminalsystemmanagement.service;

import fis.bank.criminalsystemmanagement.model.CriminalCase;

import java.util.List;

public interface CriminalCaseService {
    void create(CriminalCase criminalCase);
    List<CriminalCase> getAll();
    CriminalCase update(CriminalCase criminalCase);
    void deleteById(Long id);

    CriminalCase findById(Long id);
}
