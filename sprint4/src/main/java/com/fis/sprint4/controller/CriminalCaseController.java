package com.fis.sprint4.controller;

import com.fis.sprint4.model.CriminalCase;
import com.fis.sprint4.service.CriminalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/criminalCase")
@CrossOrigin("*")
public class CriminalCaseController {

    @Autowired
    private CriminalCaseService criminalCaseService;

    @PostMapping("/")
    public ResponseEntity<CriminalCase> addCriminalCase(@RequestBody CriminalCase criminalCase) {
        CriminalCase criminalCase1 = this.criminalCaseService.addCriminalCase(criminalCase);
        return ResponseEntity.ok(criminalCase1);
    }

    @PutMapping("/")
    public CriminalCase updateCriminalCase(@RequestBody CriminalCase criminalCase) {
        return this.criminalCaseService.updateCriminalCase(criminalCase);
    }

    @DeleteMapping("/{id}")
    public void deleteCriminalCase(@PathVariable Long id) {
        this.criminalCaseService.deleteCriminalCase(id);
    }

    @GetMapping("/")
    public Set<CriminalCase> getCriminalCases() {
        return this.criminalCaseService.getCriminalCases();
    }
}

