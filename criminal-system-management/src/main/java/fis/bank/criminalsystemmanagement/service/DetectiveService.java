package fis.bank.criminalsystemmanagement.service;


import fis.bank.criminalsystemmanagement.model.Detective;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DetectiveService {
    void create(Detective detective);
    Set<Detective> getALl();
    Detective findById(Long id);
    Detective update(Detective detective);
    void deleteById(Long id);
}
