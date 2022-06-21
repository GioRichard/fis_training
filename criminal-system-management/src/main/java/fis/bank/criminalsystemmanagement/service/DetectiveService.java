package fis.bank.criminalsystemmanagement.service;


import fis.bank.criminalsystemmanagement.model.Detective;

import java.util.List;
import java.util.Optional;

public interface DetectiveService {
    Detective CreateDetective(Detective detective);
    Detective updateDetective(Detective detective);
    Detective deleteDetectiveById(Long id);
    List<Detective> fillAll();

    Optional<Detective> findById(Long id);
}
