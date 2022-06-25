package com.fis.sprint4.service;

import com.fis.sprint4.model.CriminalCase;

import java.util.Set;

public interface CriminalCaseService {
    CriminalCase addCriminalCase(CriminalCase criminalCase);

    CriminalCase updateCriminalCase(CriminalCase criminalCase);

    Set<CriminalCase> getCriminalCases();

    CriminalCase getCriminalCase(Long id);

    void deleteCriminalCase(Long id);

}
